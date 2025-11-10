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
        	var family = FamilyMapper.map(resultSet);
        	tree.setFamily(family);
        	
        	var sector = SectorMapper.treeMap(resultSet);
        	tree.setSector(sector);
        	
            var programming = ProgrammingMapper.map(resultSet);
            tree.setProgramming(programming);
        	
            tree.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("treeId")));
            tree.setLongitude(resultSet.getString("treeLongitude"));
            tree.setLatitude(resultSet.getString("treeLatitude"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_TREE_MAPPER.getTitle();
            var technicalMessage = String.format("%s - %s", MessagesEnum.TECHNICAL_ERROR_TREE_MAPPER.getContent(), exception.getMessage());
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_TREE_MAPPER_UNEXPECTED.getTitle();
            var technicalMessage = String.format("%s - %s", MessagesEnum.TECHNICAL_ERROR_TREE_MAPPER_UNEXPECTED.getContent(), exception.toString());
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return tree;
    }
}