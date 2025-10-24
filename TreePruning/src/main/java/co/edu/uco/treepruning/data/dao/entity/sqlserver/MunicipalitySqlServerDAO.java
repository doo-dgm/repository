package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.MunicipalityDAO;
import co.edu.uco.treepruning.data.dao.entity.mapper.MunicipalityMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.MunicipalitySql;
import co.edu.uco.treepruning.entity.MunicipalityEntity;

public final class MunicipalitySqlServerDAO extends SqlConnection implements MunicipalityDAO {

    public MunicipalitySqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public MunicipalityEntity findById(final UUID id) {
        return findByFilter(new MunicipalityEntity(id)).stream().findFirst().orElse(new MunicipalityEntity());
    }

    @Override
    public List<MunicipalityEntity> findAll() {
        return findByFilter(new MunicipalityEntity());
    }

    @Override
    public List<MunicipalityEntity> findByFilter(final MunicipalityEntity filterEntity) {
        var parameterList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parameterList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            for (var index = 0; index < parameterList.size(); index++) {
                preparedStatement.setObject(index + 1, parameterList.get(index));
            }

            return executeSentenceFindByFilter(preparedStatement);

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_MUNICIPALITY_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_MUNICIPALITY_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_MUNICIPALITY_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_MUNICIPALITY_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final MunicipalityEntity filterEntity, final List<Object> parameterList) {

        var sql = new StringBuilder(MunicipalitySql.FIND_BY_FILTER);

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
            final MunicipalityEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new MunicipalityEntity());

        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "m.id = ?",
                filterEntityValidated.getId());

        addCondition(conditions, parameterList,!TextHelper.isEmptyWithTrim(filterEntityValidated.getName()), "m.name = ?",
                filterEntityValidated.getName());

        addCondition(conditions, parameterList,!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getState().getId()),
                "m.state = ?",
                filterEntityValidated.getState().getId());

        if (!conditions.isEmpty()) {
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", conditions));
        }
    }

    private void addCondition(final List<String> conditions, final List<Object> parameterList,
            final boolean condition, final String clause, final Object value) {
        if (condition) {
            conditions.add(clause);
            parameterList.add(value);
        }
    }

    private List<MunicipalityEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listMunicipality = new ArrayList<MunicipalityEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listMunicipality.add(MunicipalityMapper.map(resultSet));
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_MUNICIPALITY_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_MUNICIPALITY_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_MUNICIPALITY_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_MUNICIPALITY_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return listMunicipality;
    }
}

