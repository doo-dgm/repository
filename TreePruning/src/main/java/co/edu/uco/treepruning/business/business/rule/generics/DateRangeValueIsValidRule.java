package co.edu.uco.treepruning.business.business.rule.generics;

import java.time.LocalDate;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;

public class DateRangeValueIsValidRule implements Rule{
	
	private static final Rule INSTANCE = new DateRangeValueIsValidRule();
	
	private DateRangeValueIsValidRule() {
	}
	
	public static void executeRule(final Object... data ) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla de DateRangeValueIsValidRule.";
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "Se requerian tres parametros y llegó una cantidad menor a esta ejecutar la regla de DateRangeValueIsValidRule";
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		var date = (LocalDate) data[0];
		var dataName = (String) data[1];
		
		if (!DateHelper.getDateHelper().isLocalDateAfterOrEquals(date)) {
			var userMessage = "El dato [".concat(dataName).concat("] debe ser una fecha posterior o igual a la fecha actual para llevar a cabo la operacion deseada.");
			var technicalMessage = "La regla DateRangeValueIsValidRule falló porque el dato [".concat(dataName).concat("] requerido para llevar a cabo la operacion no es una fecha posterior o igual a la fecha actual.");
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
	}
	
}
