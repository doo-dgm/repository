package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.AdministratorEntity;

public final class AdministratorMapper {
    
    public static AdministratorEntity map(ResultSet resultSet) {
        var administrator = new AdministratorEntity();
        try {
        	
            administrator.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("administratorId")));
            administrator.setUsername(resultSet.getString("administratorUsername"));
            administrator.setEmail(resultSet.getString("administratorEmail"));
            administrator.setEmailConfirmed(resultSet.getBoolean("administratorEmailConfirmed"));
            administrator.setMobilePhone(resultSet.getString("administratorMobilePhone"));
            administrator.setMobilePhoneConfirmed(resultSet.getBoolean("administratorMobilePhoneConfirmed"));
            
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
        return administrator;
    }
}

