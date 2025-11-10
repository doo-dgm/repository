package co.edu.uco.treepruning.business.business.validator.generics;

import co.edu.uco.treepruning.business.business.rule.generics.DateRangeValueIsValidRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateDateRange implements Validator {
	
	private static final Validator INSTANCE = new ValidateDateRange();
	
	private ValidateDateRange() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		DateRangeValueIsValidRule.executeRule(data);	
	}
}
