package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.ToolEntity;

public final class ToolMapper {


    public static ToolEntity map(final ResultSet resultSet) {
        var tool = new ToolEntity();

        try {
            tool.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("toolId")));
            tool.setName(resultSet.getString("toolName"));
            tool.setDescription(resultSet.getString("toolDescription"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_TOOL_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TOOL_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_TOOL_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TOOL_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return tool;
    }
}