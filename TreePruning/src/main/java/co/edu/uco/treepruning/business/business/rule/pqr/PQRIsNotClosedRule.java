package co.edu.uco.treepruning.business.business.rule.pqr;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class PQRIsNotClosedRule implements Rule {

	private static final Rule INSTANCE = new PQRIsNotClosedRule();
	
	private PQRIsNotClosedRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	
	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Los datos para validar que la PQR no este cerrada son obligatorios...";
			var technicalMessage = "Se esta tratando de validar que una PQR no este cerrada con datos nulos.";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = "Los datos para validar que la PQR no este cerrada son obligatorios...";
			var technicalMessage = "Se esta tratando de validar que una PQR no este cerrada sin todos los datos necesarios.";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		var pqr = daoFactory.getPQRDAO().findById(id);
		
		if (pqr.getStatus().getName().equals("Cerrado")) {
			
			var userMessage = "La PQR especificada ya se encuentra cerrada...";
			var technicalMessage = "La PQR con id[".concat(id.toString()).concat("] se encuentra en estado cerrado.");
			throw TreePruningException.create(userMessage, technicalMessage);
		}
	}

}
