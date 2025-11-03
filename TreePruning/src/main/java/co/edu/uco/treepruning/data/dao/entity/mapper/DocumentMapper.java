package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.DocumentEntity;

public class DocumentMapper {
	public static DocumentEntity map(final ResultSet resultSet) {
        var document = new DocumentEntity();

        try {
            document.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("documentId")));
            document.setName(resultSet.getString("documentName"));
            document.setCode(resultSet.getString("documentCode"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return document;
    }
	
	public static DocumentEntity pqrMap(final ResultSet resultSet) {
        var document = new DocumentEntity();

        try {
            document.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("documentPersonPQRId")));
            document.setName(resultSet.getString("documentPersonPQRName"));
            document.setCode(resultSet.getString("documentPersonPQRCode"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return document;
    }
	
	public static DocumentEntity managerMap(final ResultSet resultSet) {
        var document = new DocumentEntity();

        try {
            document.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("documentManagerId")));
            document.setName(resultSet.getString("documentPersonManagerName"));
            document.setCode(resultSet.getString("documentPersonManagerCode"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return document;
    }
	
	public static DocumentEntity operatorMap(final ResultSet resultSet) {
        var document = new DocumentEntity();

        try {
            document.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("documentPersonOperatorId")));
            document.setName(resultSet.getString("documentPersonOperatorName"));
            document.setCode(resultSet.getString("documentPersonOperatorCode"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return document;
    }
}
