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
        	
        	
            administrator.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            administrator.setUsername(resultSet.getString("nombreUsuario"));
            administrator.setEmail(resultSet.getString("correoElectronico"));
            administrator.setEmailConfirmed(resultSet.getBoolean("correoConfirmado"));
            administrator.setMobilePhone(resultSet.getString("numeroCelular"));
            administrator.setMobilePhoneConfirmed(resultSet.getBoolean("celularConfirmado"));
            
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

