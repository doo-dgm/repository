package co.edu.uco.treepruning.business.business.rule.quadrille;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class QuadrilleExistsByIdRule implements Rule {
	
	private static final Rule INSTANCE = new QuadrilleExistsByIdRule();
	
	private QuadrilleExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla de QuadrilleExistsByIdRule.";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "Se requerian dos parametros y llegó una cantidad menor a esta ejecutar la regla de QuadrilleExistsByIdRule";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(id)) {
			var userMessage = "El identificador del cuadrilla no puede ser vacio...";
			var technicalMessage = "Se esta tratando de validar la existencia de un estado con un identificador vacio.";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var daoFactory = (DAOFactory) data [1];
		
		var quadrille = daoFactory.getQuadrilleDAO().findById(id);
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(quadrille.getId())) {
				var userMessage = "La cuadrilla deseada no existe...";
				var technicalMessage = "La cuadrilla con id[".concat(id.toString()).concat("] no existe...");
				throw TreePruningException.create(userMessage, technicalMessage);
		}
		
	}

}
