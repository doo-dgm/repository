package co.edu.uco.treepruning.business.business.rule.generics;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;

public class StringValueIsPresentRule implements Rule {
	
	private static final StringValueIsPresentRule INSTANCE = new StringValueIsPresentRule();
	
	private StringValueIsPresentRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Los datos para validar la presencia de un valor en una cadena de texto no pueden ser nulos";
			var technicalMessage = "Se ha recibido un arreglo de datos nulo para validar la presencia de un valor en una cadena de texto";
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		if (data.length < 3 ) {
			var userMessage = "Se requieren tres parametros para validar la presencia de un valor en una cadena de texto";
			var technicalMessage = "Se han recibido ".concat(String.valueOf(data.length)).concat(" parametros para validar la presencia de un valor en una cadena de texto, se esperaban tres");
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		boolean mustApplyTrim = (boolean) data[2];
		
		if ((mustApplyTrim)
				? TextHelper.isEmptyWithTrim(stringData)
						: TextHelper.isEmpty(stringData)) {
			var userMessage = "El dato [".concat(dataName).concat("] es requerido para llevar a cabo la operacion deseada.");
			var technicalMessage = "La regla StringValueIsPresentRule falló porque el dato [".concat(dataName).concat("] requerido para llevar a cabo la operacion esta vacio");
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
	}

}
