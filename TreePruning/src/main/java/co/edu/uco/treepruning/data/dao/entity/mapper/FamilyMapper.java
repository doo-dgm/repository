package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.FamilyEntity;

public final class FamilyMapper {


    public static FamilyEntity map(final ResultSet resultSet) {
        var family = new FamilyEntity();

        try {
            family.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            family.setScientificName(resultSet.getString("scientific_name"));
            family.setCommonName(resultSet.getString("common_name"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_FAMILY_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FAMILY_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_FAMILY_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FAMILY_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return family;
    }
}
