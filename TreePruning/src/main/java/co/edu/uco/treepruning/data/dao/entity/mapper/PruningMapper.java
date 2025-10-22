package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.PruningEntity;

public final class PruningMapper {

    public static PruningEntity map(final ResultSet resultSet) {
        var pruning = new PruningEntity();

        try {
            var status = StatusMapper.map(resultSet);
            var tree = TreeMapper.map(resultSet);
            var quadrille = QuadrilleMapper.map(resultSet);
            var type = TypeMapper.map(resultSet);
            var pqr = PQRMapper.map(resultSet);
            var programming = ProgrammingMapper.map(resultSet);

     
            pruning.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            pruning.setState(status);
            pruning.setPlannedDate(resultSet.getObject("plannedDate", LocalDate.class));
            pruning.setExecutedDate(resultSet.getObject("executedDate", LocalDate.class));
            pruning.setTree(tree);
            pruning.setQuadrille(quadrille);
            pruning.setType(type);
            pruning.setPqr(pqr);
            pruning.setProgramming(programming);
            pruning.setPhotographicRecordPath(resultSet.getString("photoRecord"));
            pruning.setObservations(resultSet.getString("observations"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PRUNING_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PRUNING_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PRUNING_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PRUNING_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return pruning;
    }
}

