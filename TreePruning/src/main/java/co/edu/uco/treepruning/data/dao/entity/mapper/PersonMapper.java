package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.PersonEntity;

public final class PersonMapper {

    public static PersonEntity map(final ResultSet resultSet) {
        var person = new PersonEntity();

        try {
            person.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            person.setFirstName(resultSet.getString("firstName"));
            person.setSecondName(resultSet.getString("secondName"));
            person.setLastName(resultSet.getString("lastName"));
            person.setSecondLastName(resultSet.getString("secondLastName"));
            person.setDocument(resultSet.getString("document"));
            person.setDocumentNumber(resultSet.getString("documentNumber"));
            person.setBirthDate(resultSet.getDate("birthDate") != null ? resultSet.getDate("fechaNacimiento").toLocalDate() : null);
            person.setAddress(resultSet.getString("adress"));
            person.setEmail(resultSet.getString("email"));
            person.setEmailConfirmed(resultSet.getBoolean("emailConfirmed"));
            person.setPhone(resultSet.getString("phone"));
            person.setPhoneConfirmed(resultSet.getBoolean("phoneConfirmed"));
            person.setAge(resultSet.getInt("age"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PERSON_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PERSON_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return person;
    }
}

