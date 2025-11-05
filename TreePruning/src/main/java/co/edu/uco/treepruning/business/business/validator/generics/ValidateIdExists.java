package co.edu.uco.treepruning.business.business.validator.generics;

import co.edu.uco.treepruning.business.business.rule.generics.IdValueIsNotDefaultValueRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateIdExists implements Validator {
	
	private static final Validator INSTANCE = new ValidateIdExists();
	
	private ValidateIdExists() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		IdValueIsNotDefaultValueRule.executeRule(data);
		
	}

}
