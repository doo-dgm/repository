package co.edu.uco.treepruning.business.business.validator.type;

import co.edu.uco.treepruning.business.business.rule.type.TypeIsCorrectiveRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateTypeIsCorrective implements Validator {
	
	private static final Validator INSTANCE = new ValidateTypeIsCorrective();
	
	private ValidateTypeIsCorrective() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}
	
	@Override
	public void validate(final Object... data) {
		TypeIsCorrectiveRule.executeRule(data);
	}
}
