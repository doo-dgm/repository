package co.edu.uco.treepruning.business.business.validator.pruning;

import co.edu.uco.treepruning.business.business.rule.generics.DateValueIsEmptyDate;
import co.edu.uco.treepruning.business.business.rule.generics.IdValueIsNotDefaultValueRule;
import co.edu.uco.treepruning.business.business.rule.generics.StringLengthValueIsValidRule;
import co.edu.uco.treepruning.business.business.validator.Validator;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class ValidateDataPreventivePruningConsistencyForRegisterNewInformation implements Validator {
private static final Validator INSTANCE = new ValidateDataPreventivePruningConsistencyForRegisterNewInformation();
	
	private ValidateDataPreventivePruningConsistencyForRegisterNewInformation() {
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
		
	}
	
	private void validateEmptyData(final PruningDomain data, final DAOFactory daoFactory) {
		DateValueIsEmptyDate.executeRule(data.getPlannedDate(), "fecha planificada");
		IdValueIsNotDefaultValueRule.executeRule(data.getTree().getId(), "arbol");
		IdValueIsNotDefaultValueRule.executeRule(data.getStatus().getId(), "estado");
		IdValueIsNotDefaultValueRule.executeRule(data.getType().getId(), "tipo de poda");
	}
	
	private void validateDataLength(final PruningDomain data) {
		if (!TextHelper.isEmptyWithTrim(data.getPhotographicRecordPath())) {
			StringLengthValueIsValidRule.executeRule(data.getPhotographicRecordPath(), "ruta del registro fotografico", 1, 2000, true);
		}
		
		if (!TextHelper.isEmptyWithTrim(data.getObservations())) {
			StringLengthValueIsValidRule.executeRule(data.getObservations(), "observaciones", 1, 500, true);
		}
		
	}
}
