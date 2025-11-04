package co.edu.uco.treepruning.business.business.validator.pruning;

import co.edu.uco.treepruning.business.business.rule.generics.StringLengthValueIsValidRule;
import co.edu.uco.treepruning.business.business.rule.generics.StringValueIsPresentRule;
import co.edu.uco.treepruning.business.business.validator.Validator;
import co.edu.uco.treepruning.business.domain.PruningDomain;

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
		
		validateDataLength(pruningDomainData);
		
	}
	
	private void validateEmptyData(final PruningDomain data) {
		StringValueIsPresentRule.executeRule();
	}
	
	private void validateDataLength(final PruningDomain data) {
		StringLengthValueIsValidRule.executeRule(data.getPhotographicRecordPath(), "ruta del registro fotografico", 1, 2000, true);
		StringLengthValueIsValidRule.executeRule(data.getObservations(), "observaciones", 1, 500, true);
	}

}
