package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.StateEntity;

public final class StateMapper {
	
	public static StateEntity map(final ResultSet resultSet) {
        var state = new StateEntity();

        try {

            var country = CountryMapper.map(resultSet);
            state.setCountry(country);
            
            state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("stateId")));
            state.setName(resultSet.getString("stateName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return state;
    }

    public static StateEntity pqrMap(final ResultSet resultSet) {
        var state = new StateEntity();

        try {

            var country = CountryMapper.pqrMap(resultSet);
            state.setCountry(country);
            
            state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("statePQRId")));
            state.setName(resultSet.getString("statePQRName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return state;
    }
    
    public static StateEntity treeMap(final ResultSet resultSet) {
        var state = new StateEntity();

        try {

            var country = CountryMapper.treeMap(resultSet);
            state.setCountry(country);
            
            state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("stateTreeId")));
            state.setName(resultSet.getString("stateTreeName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_STATE_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return state;
    }
}

