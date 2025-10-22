package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.TreeEntity;

public final class TreeMapper {


    public static TreeEntity map(final ResultSet resultSet) {
        var tree = new TreeEntity();

        try {
            tree.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            tree.setLatitude(resultSet.getDouble("latitud"));
            tree.setLongitude(resultSet.getDouble("longitud"));
            tree.setScientificName(FamilyMapper.map(resultSet));
            tree.setSector(SectorMapper.map(resultSet));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_TREE_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_TREE_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return tree;
    }
}

