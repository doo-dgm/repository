package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.TypeEntity;

public final class TypeMapper {

    public static TypeEntity map(final ResultSet resultSet) {
        var type = new TypeEntity();

        try {
            type.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("typeId")));
            type.setName(resultSet.getString("typeName"));

        } catch (final SQLException exception) {
            String userMessage = MessagesEnum.USER_ERROR_TYPE_MAPPER.getContent();
            String technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            String userMessage = MessagesEnum.USER_ERROR_TYPE_MAPPER_UNEXPECTED.getContent();
            String technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return type;
    }
}