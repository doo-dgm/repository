package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.MunicipalityEntity;

public class MunicipalityMapper {
	
	public static MunicipalityEntity map(final ResultSet resultSet) {
        var municipality = new MunicipalityEntity();

        try {
        	
        	var state = StateMapper.map(resultSet);
        	municipality.setState(state);
        	
        	municipality.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("municipalityId")));
            municipality.setName(resultSet.getString("municipalityName"));
                 

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
	
	public static MunicipalityEntity pqrMap(final ResultSet resultSet) {
        var municipality = new MunicipalityEntity();

        try {
        	
        	var state = StateMapper.pqrMap(resultSet);
        	municipality.setState(state);
        	
        	municipality.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("municipalityPQRId")));
            municipality.setName(resultSet.getString("municipalityPQRName"));
                 

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
	
	public static MunicipalityEntity treeMap(final ResultSet resultSet) {
        var municipality = new MunicipalityEntity();

        try {
        	
        	var state = StateMapper.treeMap(resultSet);
        	municipality.setState(state);
        	
        	municipality.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("municipalityTreeId")));
            municipality.setName(resultSet.getString("municipalityTreeName"));
                 

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
