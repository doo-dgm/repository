package co.edu.uco.treepruning.business.business.rule.tree;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
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
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla de TreeHasPendingPruningTheSameDayRule.";
			throw TreePruningException.create(userMessage, technicalMessage);
			
		}
		
		if (data.length < 3) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "Se requerian dos parametros y llegó una cantidad menor a esta ejecutar la regla de TreeHasPendingPruningTheSameDayRule";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var treeId = (UUID) data[0];
		var plannedDate = (LocalDate) data[1];
		var daoFactory = (DAOFactory) data[2];
		
		var pruningEntity = new PruningEntity();
		
		
		pruningEntity.setTree(new TreeEntity(treeId));
		pruningEntity.setPlannedDate(plannedDate);
		
		var pruning = daoFactory.getPruningDAO().findByFilter(pruningEntity);
		
		if (pruning.isEmpty()) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
	}

}
