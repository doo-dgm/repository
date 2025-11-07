package co.edu.uco.treepruning.business.business.rule.pqr;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class PQRExistsByIdRule implements Rule {

	private static final Rule INSTANCE = new PQRExistsByIdRule();
	
	private PQRExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	
	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(id)) {
			var userMessage = "El identificador de la PQR no puede ser vacio...";
			var technicalMessage = "Se esta tratando de validar la existencia de una PQR con un identificador vacio.";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var daoFactory = (DAOFactory) data[1];
		
		var pqr = daoFactory.getPQRDAO().findById(id);
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(pqr.getId())) {
			var userMessage = "La PQR especificada no existe...";
			var technicalMessage = "La PQR con id[".concat(id.toString()).concat("] no existe...");
			throw new RuntimeException(userMessage + " " + technicalMessage);
		}
	}

}
