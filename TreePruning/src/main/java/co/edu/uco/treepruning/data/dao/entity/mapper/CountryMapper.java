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
         
            country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            country.setName(resultSet.getString("name"));

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

