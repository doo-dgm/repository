package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.PruningToolEntity;

public final class PruningToolMapper {


    public static PruningToolEntity map(final ResultSet resultSet) {
        var pruningTool = new PruningToolEntity();

        try {
            var pruning = PruningMapper.map(resultSet);
            pruningTool.setPruning(pruning);
            
            var tool = ToolMapper.map(resultSet);
            pruningTool.setTool(tool);

            pruningTool.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PRUNING_TOOL_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PRUNING_TOOL_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PRUNING_TOOL_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PRUNING_TOOL_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return pruningTool;
    }
}

