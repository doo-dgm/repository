package co.edu.uco.treepruning.business.business.validator.pqr;

import co.edu.uco.treepruning.business.business.rule.pqr.PQRIsNotClosedRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidatePQRIsNotClosed implements Validator {

	private static final Validator INSTANCE = new ValidatePQRIsNotClosed();

	private ValidatePQRIsNotClosed() {
	}

	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		PQRIsNotClosedRule.executeRule(data);
		
	}

}
