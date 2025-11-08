package co.edu.uco.treepruning.business.business.validator.status;

import co.edu.uco.treepruning.business.business.rule.status.StatusIsNotClosedRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateStatusIsNotClosed implements Validator {
	
	private static final Validator INSTANCE = new ValidateStatusIsNotClosed();
	
	private ValidateStatusIsNotClosed() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		StatusIsNotClosedRule.executeRule(data);
	}

}
