package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.RiskEntity;

public final class RiskMapper {


    public static RiskEntity map(final ResultSet resultSet) {
        var risk = new RiskEntity();

        try {
            risk.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("riskId")));
            risk.setName(resultSet.getString("riskName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_RISK_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RISK_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_RISK_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RISK_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return risk;
    }
}

