package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.MunicipalityEntity;
import co.edu.uco.treepruning.entity.StateEntity;

public final class MunicipalityMapper {

    public static MunicipalityEntity map(final ResultSet resultSet) {
        var municipality = new MunicipalityEntity();

        try {
        	
        	var state = new StateEntity();
            municipality.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            municipality.setName(resultSet.getString("name"));
            state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("departamento")));
            municipality.setState(state);

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_MUNICIPALITY_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_MUNICIPALITY_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_MUNICIPALITY_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_MUNICIPALITY_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return municipality;
    }
}

