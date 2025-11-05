package co.edu.uco.treepruning.business.business.rule.generics;

import java.time.LocalDate;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;

public class DateFormatValueIsValidRule implements Rule {
	
	private static final DateFormatValueIsValidRule INSTANCE = new DateFormatValueIsValidRule();
	
	private DateFormatValueIsValidRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla de DateFormatValueIsValidRule.";
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "Se requerian dos parametros y llegó una cantidad menor a esta ejecutar la regla de DateFormatValueIsValidRule";
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		var dateData = (LocalDate) data[0];
		var dataName = (String) data[1];
		
		if (DateHelper.getDateHelper().isDefaultDate(dateData)) {
			var userMessage = "El dato [".concat(dataName).concat("] tiene un formato invalido para llevar a cabo la operacion deseada.");
			var technicalMessage = "La regla DateFormatValueIsValidRule falló porque el dato [".concat(dataName).concat("] requerido para llevar a cabo la operacion tiene un formato invalido.");
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
	}

}
