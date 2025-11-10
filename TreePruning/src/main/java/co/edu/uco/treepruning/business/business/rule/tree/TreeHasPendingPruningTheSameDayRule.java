package co.edu.uco.treepruning.business.business.rule.tree;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.entity.PruningEntity;
import co.edu.uco.treepruning.entity.TreeEntity;

public class TreeHasPendingPruningTheSameDayRule implements Rule {
	
	private static final Rule INSTANCE = new TreeHasPendingPruningTheSameDayRule();
	
	private TreeHasPendingPruningTheSameDayRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_HAS_PENDING_PRUNING_THE_SAME_DAY_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_HAS_PENDING_PRUNING_THE_SAME_DAY_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
			
		}
		
		if (data.length < 3) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_HAS_PENDING_PRUNING_THE_SAME_DAY_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_HAS_PENDING_PRUNING_THE_SAME_DAY_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var treeId = (UUID) data[0];
		var plannedDate = (LocalDate) data[1];
		var daoFactory = (DAOFactory) data[2];
		
		var pruningEntity = new PruningEntity();
		
		pruningEntity.setTree(new TreeEntity(treeId));
		pruningEntity.setPlannedDate(plannedDate);
		
		var pruning = daoFactory.getPruningDAO().findByFilter(pruningEntity);

		if (!pruning.isEmpty()) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_HAS_PENDING_PRUNING_THE_SAME_DAY_FOUND.getTitle();
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_TREE_HAS_PENDING_PRUNING_THE_SAME_DAY_FOUND.getContent(), treeId.toString(), plannedDate.toString());
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
	}

}