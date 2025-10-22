package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.OperatorEntity;

public final class OperatorMapper {


    public static OperatorEntity map(final ResultSet resultSet) {
        var operator = new OperatorEntity();

        try {
            operator.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            var person = PersonMapper.map(resultSet);
            operator.setPerson(person);
            var quadrille = QuadrilleMapper.map(resultSet);
            operator.setQuadrille(quadrille);

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_OPERATOR_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPERATOR_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return operator;
    }
}

