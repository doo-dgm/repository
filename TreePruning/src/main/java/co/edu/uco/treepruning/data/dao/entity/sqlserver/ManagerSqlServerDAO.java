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
import co.edu.uco.treepruning.data.dao.entity.ManagerDAO;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.ManagerMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.ManagerSql;
import co.edu.uco.treepruning.entity.ManagerEntity;

public final class ManagerSqlServerDAO extends SqlConnection implements ManagerDAO {

    public ManagerSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(final ManagerEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(ManagerSql.CREATE)) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getPerson().getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<ManagerEntity> findAll() {
        return findByFilter(new ManagerEntity());
    }

    @Override
    public List<ManagerEntity> findByFilter(final ManagerEntity filterEntity) {
        var parameterList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parameterList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            for (var index = 0; index < parameterList.size(); index++) {
                preparedStatement.setObject(index + 1, parameterList.get(index));
            }

            return executeSentenceFindByFilter(preparedStatement);

        } catch (final TreePruningException exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final SQLException exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public ManagerEntity findById(final UUID id) {
        return findByFilter(new ManagerEntity(id)).stream().findFirst().orElse(null);
    }

    @Override
    public void update(final ManagerEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(ManagerSql.UPDATE)) {

            preparedStatement.setObject(1, entity.getPerson().getId());
            preparedStatement.setObject(2, entity.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(final UUID entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(ManagerSql.DELETE)) {

            preparedStatement.setObject(1, entity);
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

    }

    private String createSentenceFindByFilter(final ManagerEntity filterEntity, final List<Object> parameterList) {

        var sql = new StringBuilder(ManagerSql.FIND_BY_FILTER);

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
            final ManagerEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ManagerEntity());

        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),"m.id = ?", filterEntityValidated.getId());
        addCondition(conditions, parameterList,!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getPerson().getId()),"m.persona = ?", filterEntityValidated.getPerson().getId());

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

    private List<ManagerEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listManager = new ArrayList<ManagerEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listManager.add(ManagerMapper.map(resultSet));
            }
        } catch (final SQLException exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return listManager;
    }
}

