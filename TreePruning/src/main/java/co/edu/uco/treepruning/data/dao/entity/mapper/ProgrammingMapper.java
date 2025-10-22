package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.ProgrammingEntity;

public final class ProgrammingMapper {

    private ProgrammingMapper() {
        super();
    }

    public static ProgrammingEntity map(final ResultSet resultSet) {
        var programming = new ProgrammingEntity();

        try {
            programming.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            programming.setInitialDate(resultSet.getObject("initialDate", LocalDate.class));
            programming.setFrequencyMonths(resultSet.getInt("frequencyMonths"));
            programming.setQuantity(resultSet.getInt("quantity"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return programming;
    }
}
