package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.CountryEntity;

public final class CountryMapper {
	
	public static CountryEntity map(final ResultSet resultSet) {
        var country = new CountryEntity();

        try {
         
            country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("countryId")));
            country.setName(resultSet.getString("countryName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_COUNTRY_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_COUNTRY_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_COUNTRY_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_COUNTRY_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return country;
    }

    public static CountryEntity pqrMap(final ResultSet resultSet) {
        var country = new CountryEntity();

        try {
         
            country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("countryPQRId")));
            country.setName(resultSet.getString("countryPQRName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_COUNTRY_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_COUNTRY_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_COUNTRY_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_COUNTRY_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return country;
    }
    
    public static CountryEntity treeMap(final ResultSet resultSet) {
        var country = new CountryEntity();

        try {
         
            country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("countryTreeId")));
            country.setName(resultSet.getString("countryTreeName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_COUNTRY_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_COUNTRY_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_COUNTRY_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_COUNTRY_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return country;
    }
}

