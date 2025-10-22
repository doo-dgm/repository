package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.StatusEntity;

public final class StatusMapper {

    private StatusMapper() {
        super();
    }

    public static StatusEntity map(final ResultSet resultSet) {
        var status = new StatusEntity();

        try {
            status.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            status.setName(resultSet.getString("name"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATUS_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATUS_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATUS_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATUS_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return status;
    }
}
