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
import co.edu.uco.treepruning.data.dao.entity.mapper.AdministratorMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.AdministratorSql;
import co.edu.uco.treepruning.data.dao.entity.AdministratorDAO;
import co.edu.uco.treepruning.entity.AdministratorEntity;

public final class AdministratorSqlServerDAO extends SqlConnection implements AdministratorDAO {

    public AdministratorSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(final AdministratorEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(AdministratorSql.CREATE)) {
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getUsername());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setBoolean(4, entity.isEmailConfirmed());
            preparedStatement.setString(5, entity.getMobilePhone());
            preparedStatement.setBoolean(6, entity.isMobilePhoneConfirmed());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_CREATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_CREATE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_CREATE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_CREATE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void update(final AdministratorEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(AdministratorSql.UPDATE)) {
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setBoolean(3, entity.isEmailConfirmed());
            preparedStatement.setString(4, entity.getMobilePhone());
            preparedStatement.setBoolean(5, entity.isMobilePhoneConfirmed());
            preparedStatement.setObject(6, entity.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_UPDATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_UPDATE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_UPDATE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_UPDATE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(final UUID id) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = this.getConnection().prepareStatement(AdministratorSql.DELETE)) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_DELETE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_DELETE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_DELETE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_DELETE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public AdministratorEntity findById(final UUID id) {
        return findByFilter(new AdministratorEntity(id)).stream().findFirst().orElse(new AdministratorEntity());
    }

    @Override
    public List<AdministratorEntity> findAll() {
        return findByFilter(new AdministratorEntity());
    }

    @Override
    public List<AdministratorEntity> findByFilter(AdministratorEntity filterEntity) {
        var parametersList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parametersList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
            for (int index = 0; index < parametersList.size(); index++) {
                preparedStatement.setObject(index + 1, parametersList.get(index));
            }

            return executeSentenceFindByFilter(preparedStatement);
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final AdministratorEntity filterEntity, final List<Object> parametersList) {
        var sql = new StringBuilder(AdministratorSql.FIND_BY_FILTER);

        createWhereClauseFindByFilter(sql, parametersList, filterEntity);

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,final AdministratorEntity filterEntity) {
        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new AdministratorEntity());
        final var conditions = new ArrayList<String>();
        
        addCondition(conditions, parametersList,!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "a.id = ?",filterEntityValidated.getId());
        addCondition(conditions, parametersList,!TextHelper.isEmptyWithTrim(filterEntityValidated.getUsername()), "a.nombreUsuario = ?", filterEntityValidated.getUsername());
        addCondition(conditions, parametersList,!TextHelper.isEmptyWithTrim(filterEntityValidated.getEmail()), "a.correoElectronico = ?",filterEntityValidated.getEmail());
        addCondition(conditions, parametersList, !filterEntityValidated.isEmailConfirmed(), "a.correoConfirmado = ?", filterEntityValidated.isEmailConfirmed());
        addCondition(conditions, parametersList,!TextHelper.isEmptyWithTrim(filterEntityValidated.getMobilePhone()), "a.numeroCelular = ?",filterEntityValidated.getMobilePhone());
        addCondition(conditions, parametersList, !filterEntityValidated.isMobilePhoneConfirmed(), "a.celularConfirmado = ?", filterEntityValidated.isMobilePhoneConfirmed());
        
        

        if (!conditions.isEmpty()) {
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", conditions));
        }
  
	}

	private void addCondition(final List<String> conditions, final List<Object> parametersList, final boolean condition,
            final String clause, final Object value) {
        if (condition) {
            conditions.add(clause);
            parametersList.add(value);
        }
    }

    private List<AdministratorEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listAdministrator = new ArrayList<AdministratorEntity>();

        try (var resultset = preparedStatement.executeQuery()) {
            while (resultset.next()) {
                listAdministrator.add(AdministratorMapper.map(resulset));
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return listAdministrator;
    }

}

