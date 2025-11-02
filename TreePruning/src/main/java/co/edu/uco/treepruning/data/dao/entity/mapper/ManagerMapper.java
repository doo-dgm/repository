package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.ManagerEntity;

public final class ManagerMapper {

    public static ManagerEntity map(final ResultSet resultSet) {
        var manager = new ManagerEntity();

        try {
        	
        	var person = PersonMapper.map(resultSet);
        	manager.setPerson(person);
        	
            manager.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("managerId")));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_MANAGER_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_MANAGER_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_MANAGER_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_MANAGER_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return manager;
    }
}

