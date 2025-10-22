package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.PQREntity;
import co.edu.uco.treepruning.entity.StatusEntity;
import co.edu.uco.treepruning.entity.RiskEntity;
import co.edu.uco.treepruning.entity.SectorEntity;
import co.edu.uco.treepruning.entity.PersonEntity;

public final class PQRMapper {


    public static PQREntity map(final ResultSet resultSet) {
        var pqr = new PQREntity();

        try {
            var status = StatusMapper.map(resultSet);
            var risk = RiskMapper.map(resultSet);
            var sector = SectorMapper.map(resultSet);
            var person = PersonMapper.map(resultSet);
            
            pqr.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            pqr.setDate(resultSet.getObject("fecha", LocalDate.class));
            pqr.setStatus(status);
            pqr.setRisk(risk);
            pqr.setSector(sector);
            pqr.setPerson(person);
            pqr.setPhotographicRecordPath(resultSet.getString("photoRecord"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PQR_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PQR_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return pqr;
    }
}

