package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.DocumentEntity;

public final class DocumentMapper {


    public static DocumentEntity map(final ResultSet resultSet) {
        var document = new DocumentEntity();

        try {
            document.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            document.setName(resultSet.getString("name"));
            document.setCode(resultSet.getString("code"));

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
