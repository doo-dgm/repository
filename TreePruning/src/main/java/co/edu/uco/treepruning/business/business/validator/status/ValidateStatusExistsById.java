package co.edu.uco.treepruning.business.business.validator.status;

import co.edu.uco.treepruning.business.business.rule.status.StatusExistsByIdRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateStatusExistsById implements Validator {
	
	private static final Validator INSTANCE = new ValidateStatusExistsById();
	
	private ValidateStatusExistsById() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		StatusExistsByIdRule.executeRule(data);
		
	}

}
