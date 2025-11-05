package co.edu.uco.treepruning.business.business.validator.pqr;

import co.edu.uco.treepruning.business.business.rule.pqr.PQRExistsByIdRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidatePQRExistsById implements Validator {
	
	private static final Validator INSTANCE = new ValidatePQRExistsById();
	
	private ValidatePQRExistsById() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		PQRExistsByIdRule.executeRule(data);
		
	}
	
}
