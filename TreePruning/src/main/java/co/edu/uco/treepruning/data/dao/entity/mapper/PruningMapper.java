package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.PruningEntity;

public final class PruningMapper {

    public static PruningEntity map(final ResultSet resultSet) {
        var pruning = new PruningEntity();

        try {
            var status = StatusMapper.pruningMap(resultSet);
            pruning.setStatus(status);
            
            var tree = TreeMapper.map(resultSet);
            pruning.setTree(tree);
            
            var quadrille = QuadrilleMapper.pruningMap(resultSet);
            pruning.setQuadrille(quadrille);
            
            var type = TypeMapper.map(resultSet);
            pruning.setType(type);
            
            var pqr = PQRMapper.pruningMap(resultSet);
            pruning.setPqr(pqr);
            
            var programming = ProgrammingMapper.map(resultSet);
            pruning.setProgramming(programming);
     
            pruning.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("pruningId")));
            pruning.setPlannedDate(DateHelper.getDateHelper().toLocalDate(resultSet.getDate("pruningPlannedDate")));
            pruning.setExecutedDate(DateHelper.getDateHelper().toLocalDate(resultSet.getDate("pruningExecutedDate")));
            pruning.setPhotographicRecordPath(resultSet.getString("pruningPhotographicReportPath"));
            pruning.setObservations(resultSet.getString("pruningObservations"));

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

