package co.edu.uco.treepruning.business.business.rule.status;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class StatusExistsByIdRule implements Rule {

	private static final Rule INSTANCE = new StatusExistsByIdRule();
	
	private StatusExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	@Override
	public void execute(final Object... data) {
		
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla de StatusExistsByIdRule.";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla de StatusExistsByIdRule.";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		var status = daoFactory.getStatusDAO().findById(id);
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(status.getId())) {
			var userMessage = "El estado deseado no existe...";
			var technicalMessage = "El estado con id[".concat(id.toString()).concat("] no existe...");
			throw new RuntimeException(userMessage + " " + technicalMessage);
		}
		
	}

}
