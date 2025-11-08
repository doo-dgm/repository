package co.edu.uco.treepruning.business.business.validator.pruning;

import co.edu.uco.treepruning.business.business.rule.generics.DateRangeValueIsValidRule;
import co.edu.uco.treepruning.business.business.rule.generics.DateValueIsEmptyDate;
import co.edu.uco.treepruning.business.business.rule.generics.IdValueIsNotDefaultValueRule;
import co.edu.uco.treepruning.business.business.rule.generics.StringLengthValueIsValidRule;
import co.edu.uco.treepruning.business.business.validator.Validator;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class ValidateDataPruningConsistencyForRegisterNewInformation implements Validator {
	
	private static final Validator INSTANCE = new ValidateDataPruningConsistencyForRegisterNewInformation();
	
	private ValidateDataPruningConsistencyForRegisterNewInformation() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		var pruningDomainData = (PruningDomain) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		validateEmptyData(pruningDomainData, daoFactory);
		
		validateDataLength(pruningDomainData);
		
		validateDateFormat(pruningDomainData);
		
	}
	
	private void validateEmptyData(final PruningDomain data, final DAOFactory daoFactory) {
		System.out.println(data.getPlannedDate());
		DateValueIsEmptyDate.executeRule(data.getPlannedDate(), "fecha planificada");
		IdValueIsNotDefaultValueRule.executeRule(data.getTree().getId(), "identificador del arbol");
		IdValueIsNotDefaultValueRule.executeRule(data.getStatus().getId(), "identificador del estado");
		IdValueIsNotDefaultValueRule.executeRule(data.getType().getId(), "identificador del tipo de poda");
		IdValueIsNotDefaultValueRule.executeRule(data.getPqr().getId(), "identificador de la PQR");
	}
	
	private void validateDataLength(final PruningDomain data) {
		if (!TextHelper.isEmptyWithTrim(data.getPhotographicRecordPath())) {
			StringLengthValueIsValidRule.executeRule(data.getPhotographicRecordPath(), "ruta del registro fotografico", 1, 2000, true);
		}
		
		if (!TextHelper.isEmptyWithTrim(data.getObservations())) {
			StringLengthValueIsValidRule.executeRule(data.getObservations(), "observaciones", 1, 500, true);
		}
		
	}
	
	private void validateDateFormat(final PruningDomain data) {
		DateRangeValueIsValidRule.executeRule(data.getPlannedDate(), "fecha planificada");
	}

}
