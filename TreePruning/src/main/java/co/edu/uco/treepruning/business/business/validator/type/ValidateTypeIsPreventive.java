package co.edu.uco.treepruning.business.business.validator.type;

import co.edu.uco.treepruning.business.business.rule.type.TypeIsPreventiveRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateTypeIsPreventive implements Validator {
	
	private static final Validator INSTANCE = new ValidateTypeIsPreventive();
	
	private ValidateTypeIsPreventive() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}
	
	@Override
	public void validate(final Object... data) {
		TypeIsPreventiveRule.executeRule(data);	}

}
