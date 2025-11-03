package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.QuadrilleEntity;

public final class QuadrilleMapper {

    public static QuadrilleEntity map(final ResultSet resultSet) {
        var quadrille = new QuadrilleEntity();

        try {
  
            var manager = ManagerMapper.map(resultSet);
            quadrille.setManager(manager);
            
            quadrille.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("quadrilleId")));
            quadrille.setQuadrilleName(resultSet.getString("quadrilleName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_QUADRILLE_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_QUADRILLE_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_QUADRILLE_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_QUADRILLE_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return quadrille;
    }
    
    public static QuadrilleEntity pruningMap(final ResultSet resultSet) {
        var quadrille = new QuadrilleEntity();

        try {
  
            var manager = ManagerMapper.pruningMap(resultSet);
            quadrille.setManager(manager);
            
            quadrille.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("quadrilleId")));
            quadrille.setQuadrilleName(resultSet.getString("quadrilleName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_QUADRILLE_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_QUADRILLE_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_QUADRILLE_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_QUADRILLE_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return quadrille;
    
    }
    
    public static QuadrilleEntity operatorMap(final ResultSet resultSet) {
        var quadrille = new QuadrilleEntity();

        try {
  
            var manager = ManagerMapper.operatorMap(resultSet);
            quadrille.setManager(manager);
            
            quadrille.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("quadrilleId")));
            quadrille.setQuadrilleName(resultSet.getString("quadrilleName"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_QUADRILLE_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_QUADRILLE_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_QUADRILLE_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_QUADRILLE_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return quadrille;
    }
}
