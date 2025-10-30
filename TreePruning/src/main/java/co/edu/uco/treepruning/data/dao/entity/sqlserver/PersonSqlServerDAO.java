package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.entity.PersonDAO;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.PersonMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.PersonSql;
import co.edu.uco.treepruning.entity.PersonEntity;

public final class PersonSqlServerDAO extends SqlConnection implements PersonDAO {

    public PersonSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(final PersonEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(PersonSql.CREATE)) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setString(3, entity.getSecondName());
            preparedStatement.setString(4, entity.getFirstLastName());
            preparedStatement.setString(5, entity.getSecondLastName());
            preparedStatement.setObject(6, entity.getDocument());
            preparedStatement.setString(7, entity.getDocumentNumber());
            preparedStatement.setObject(8, entity.getBirthDate()); 
            preparedStatement.setString(9, entity.getAddress());
            preparedStatement.setString(10, entity.getEmail());
            preparedStatement.setBoolean(11, entity.isEmailConfirmed());
            preparedStatement.setString(12, entity.getPhone());
            preparedStatement.setBoolean(13, entity.isPhoneConfirmed());
            preparedStatement.setInt(14, entity.getAge());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_CREATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_CREATE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_CREATE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_CREATE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<PersonEntity> findAll() {
        return findByFilter(new PersonEntity());
    }

    @Override
    public List<PersonEntity> findByFilter(final PersonEntity filterEntity) {
        var parameterList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parameterList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            for (var index = 0; index < parameterList.size(); index++) {
                preparedStatement.setObject(index + 1, parameterList.get(index));
            }

            return executeSentenceFindByFilter(preparedStatement);

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public PersonEntity findById(final UUID id) {
        return findByFilter(new PersonEntity(id)).stream().findFirst().orElse(new PersonEntity());
    }

    @Override
    public void update(final PersonEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(PersonSql.UPDATE)) {

            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getSecondName());
            preparedStatement.setString(3, entity.getFirstLastName());
            preparedStatement.setString(4, entity.getSecondLastName());
            preparedStatement.setObject(5, entity.getDocument());
            preparedStatement.setString(6, entity.getDocumentNumber());
            preparedStatement.setObject(7, entity.getBirthDate());
            preparedStatement.setString(8, entity.getAddress());
            preparedStatement.setString(9, entity.getEmail());
            preparedStatement.setBoolean(10, entity.isEmailConfirmed());
            preparedStatement.setString(11, entity.getPhone());
            preparedStatement.setBoolean(12, entity.isPhoneConfirmed());
            preparedStatement.setInt(13, entity.getAge());
            preparedStatement.setObject(14, entity.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_UPDATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_UPDATE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_UPDATE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_UPDATE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(final UUID id) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(PersonSql.DELETE)) {

            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_DELETE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_DELETE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_DELETE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_DELETE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final PersonEntity filterEntity, final List<Object> parametersList) {

        var sql = new StringBuilder(PersonSql.FIND_BY_FILTER);

        createWhereClauseFindByFilter(sql, parametersList, filterEntity);

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
            final PersonEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new PersonEntity());

        final var conditions = new ArrayList<String>();

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "p.id = ?",filterEntityValidated.getId());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getFirstName()), "p.nombreUno = ?",filterEntityValidated.getFirstName());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getSecondName()), "p.nombreDos = ?",filterEntityValidated.getSecondName());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getFirstLastName()), "p.apellidoUno = ?",filterEntityValidated.getFirstLastName());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getSecondLastName()), "p.apellidoDos = ?",filterEntityValidated.getSecondLastName());

        addCondition(conditions, parametersList,
        		!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getDocument().getId()), "p.Documento = ?",filterEntityValidated.getDocument().getId());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getDocumentNumber()), "p.numeroDocumento = ?",filterEntityValidated.getDocumentNumber());

        addCondition(conditions, parametersList,
                filterEntityValidated.getBirthDate() != null, "p.fechaNacimiento = ?",filterEntityValidated.getBirthDate());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getAddress()), "p.direccion = ?",filterEntityValidated.getAddress());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getEmail()), "p.email = ?",filterEntityValidated.getEmail());

        addCondition(conditions, parametersList,
                !filterEntityValidated.isEmailConfirmed(), "p.correoConfirmado = ?",filterEntityValidated.isEmailConfirmed());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getPhone()), "p.telefono = ?",
                filterEntityValidated.getPhone());

        addCondition(conditions, parametersList,
                !filterEntityValidated.isPhoneConfirmed(), "p.telefonoConfirmado = ?",
                filterEntityValidated.isPhoneConfirmed());

        addCondition(conditions, parametersList,
                NumericHelper.getDefaultInt(filterEntityValidated.getAge()) > 0, "p.edad = ?", filterEntityValidated.getAge());

        if (!conditions.isEmpty()) {
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", conditions));
        }
    }

    private void addCondition(final List<String> conditions, final List<Object> parametersList,
            final boolean condition, final String clause, final Object value) {
        if (condition) {
            conditions.add(clause);
            parametersList.add(value);
        }
    }

    private List<PersonEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listPerson = new ArrayList<PersonEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listPerson.add(PersonMapper.map(resultSet));
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return listPerson;
    }
}
