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
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.entity.OperatorDAO;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.OperatorMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.OperatorSql;
import co.edu.uco.treepruning.entity.OperatorEntity;

public final class OperatorSqlServerDAO extends SqlConnection implements OperatorDAO {

    public OperatorSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(final OperatorEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(OperatorSql.CREATE)) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getPerson().getId());
            preparedStatement.setObject(3, entity.getQuadrille().getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_CREATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_CREATE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_CREATE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_CREATE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<OperatorEntity> findAll() {
        return findByFilter(new OperatorEntity());
    }

    @Override
    public List<OperatorEntity> findByFilter(final OperatorEntity filterEntity) {
        var parameterList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parameterList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            for (var index = 0; index < parameterList.size(); index++) {
                preparedStatement.setObject(index + 1, parameterList.get(index));
            }

            return executeSentenceFindByFilter(preparedStatement);

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public OperatorEntity findById(final UUID id) {
        return findByFilter(new OperatorEntity(id)).stream().findFirst().orElse(new OperatorEntity());
    }

    @Override
    public void update(final OperatorEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(OperatorSql.UPDATE)) {

            preparedStatement.setObject(1, entity.getPerson().getId());
            preparedStatement.setObject(2, entity.getQuadrille().getId());
            preparedStatement.setObject(3, entity.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_UPDATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_UPDATE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_UPDATE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_UPDATE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(OperatorEntity entity){
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(OperatorSql.DELETE)) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_DELETE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_DELETE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_DELETE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_DELETE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final OperatorEntity filterEntity, final List<Object> parameterList) {

        var sql = new StringBuilder(OperatorSql.FIND_BY_FILTER);

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
            final OperatorEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new OperatorEntity());

        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "o.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getPerson().getId()),
                "o.persona = ?",filterEntityValidated.getPerson().getId());

        addCondition(conditions, parameterList,!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getQuadrille().getId()),
                "o.cuadrilla = ?",filterEntityValidated.getQuadrille().getId());

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

    private List<OperatorEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listOperator = new ArrayList<OperatorEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listOperator.add(OperatorMapper.map(resultSet));
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return listOperator;
    }


}