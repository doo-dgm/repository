package co.edu.uco.treepruning.business.business.rule.tree;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class TreeExistsByIdRule implements Rule{

	private static final Rule INSTANCE = new TreeExistsByIdRule();
	
	private TreeExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	@Override
	public void execute(final Object... data) {
		
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla de TreeExistsByIdRule.";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "Se requerian dos parametros y llegó una cantidad menor a esta ejecutar la regla de TreeExistsByIdRule";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory)  data[1];
		
		var tree = daoFactory.getTreeDAO().findById(id);
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(tree.getId())) {
			var userMessage = "El arbol deseado no existe...";
			var technicalMessage = "El arbol con id[".concat(id.toString()).concat("] no existe...");
			throw TreePruningException.create(userMessage, technicalMessage);
		}		
		
	}

}
