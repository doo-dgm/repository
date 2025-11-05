package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.PersonEntity;

public class PersonMapper {
	public static PersonEntity map(final ResultSet resultSet) {
        var person = new PersonEntity();

        try {
        	var documentType = DocumentMapper.map(resultSet);
        	person.setDocument(documentType);
        	
            person.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("personId")));
            person.setFirstName(resultSet.getString("personFirstName"));
            person.setSecondName(resultSet.getString("personMiddleName"));
            person.setFirstLastName(resultSet.getString("personSurname"));
            person.setSecondLastName(resultSet.getString("personSecondSurname"));
            person.setDocumentNumber(resultSet.getString("personDocumentNumber"));
            person.setBirthDate(DateHelper.getDateHelper().dateToLocalDate(resultSet.getDate("personBirthDate")));
            person.setAddress(resultSet.getString("personAddress"));
            person.setEmail(resultSet.getString("personEmail"));
            person.setEmailConfirmed(resultSet.getBoolean("personEmailConfirmed"));
            person.setPhone(resultSet.getString("personPhone"));
            person.setPhoneConfirmed(resultSet.getBoolean("personPhoneConfirmed"));
            person.setAge(resultSet.getInt("personAge"));

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
	
	public static PersonEntity operatorMap(final ResultSet resultSet) {
        var person = new PersonEntity();

        try {
        	var documentType = DocumentMapper.operatorMap(resultSet);
        	person.setDocument(documentType);
        	
            person.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("personOperatorId")));
            person.setFirstName(resultSet.getString("personOperatorFirstName"));
            person.setSecondName(resultSet.getString("personOperatorMiddleName"));
            person.setFirstLastName(resultSet.getString("personOperatorSurname"));
            person.setSecondLastName(resultSet.getString("personOperatorSecondSurname"));
            person.setDocumentNumber(resultSet.getString("personOperatorDocumentNumber"));
            person.setBirthDate(DateHelper.getDateHelper().dateToLocalDate(resultSet.getDate("personOperatorBirthDate")));
            person.setAddress(resultSet.getString("personOperatorAddress"));
            person.setEmail(resultSet.getString("personOperatorEmail"));
            person.setEmailConfirmed(resultSet.getBoolean("personOperatorEmailConfirmed"));
            person.setPhone(resultSet.getString("personOperatorPhone"));
            person.setPhoneConfirmed(resultSet.getBoolean("personOperatorPhoneConfirmed"));
            person.setAge(resultSet.getInt("personOperatorAge"));

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
	
	public static PersonEntity pqrMap(final ResultSet resultSet) {
        var person = new PersonEntity();

        try {
        	var documentType = DocumentMapper.pqrMap(resultSet);
        	person.setDocument(documentType);
        	
            person.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("personPQRId")));
            person.setFirstName(resultSet.getString("personPQRFirstName"));
            person.setSecondName(resultSet.getString("personPQRMiddleName"));
            person.setFirstLastName(resultSet.getString("personPQRSurname"));
            person.setSecondLastName(resultSet.getString("personPQRSecondSurname"));
            person.setDocumentNumber(resultSet.getString("personPQRDocumentNumber"));
            person.setBirthDate(DateHelper.getDateHelper().dateToLocalDate(resultSet.getDate("personPQRBirthDate")));
            person.setAddress(resultSet.getString("personPQRAddress"));
            person.setEmail(resultSet.getString("personPQREmail"));
            person.setEmailConfirmed(resultSet.getBoolean("personPQREmailConfirmed"));
            person.setPhone(resultSet.getString("personPQRPhone"));
            person.setPhoneConfirmed(resultSet.getBoolean("personPQRPhoneConfirmed"));
            person.setAge(resultSet.getInt("personPQRAge"));

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
	
	public static PersonEntity managerMap(final ResultSet resultSet) {
        var person = new PersonEntity();

        try {
        	var documentType = DocumentMapper.managerMap(resultSet);
        	person.setDocument(documentType);
        	
            person.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("personManagerId")));
            person.setFirstName(resultSet.getString("personManagerFirstName"));
            person.setSecondName(resultSet.getString("personManagerMiddleName"));
            person.setFirstLastName(resultSet.getString("personManagerSurname"));
            person.setSecondLastName(resultSet.getString("personManagerSecondSurname"));
            person.setDocumentNumber(resultSet.getString("personManagerDocumentNumber"));
            person.setBirthDate(DateHelper.getDateHelper().dateToLocalDate(resultSet.getDate("personManagerBirthDate")));
            person.setAddress(resultSet.getString("personManagerAddress"));
            person.setEmail(resultSet.getString("personManagerEmail"));
            person.setEmailConfirmed(resultSet.getBoolean("personManagerEmailConfirmed"));
            person.setPhone(resultSet.getString("personManagerPhone"));
            person.setPhoneConfirmed(resultSet.getBoolean("personManagerPhoneConfirmed"));
            person.setAge(resultSet.getInt("personManagerAge"));

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
