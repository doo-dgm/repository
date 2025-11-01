package co.edu.uco.treepruning.business.business.validator.pruning;

import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidatePruningExistsById implements Validator {
	
	private static final Validator INSTANCE = new ValidatePruningExistsById();
	
	private ValidatePruningExistsById() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}
	@Override
	public void validate(final Object... data) {
		// TODO Auto-generated method stub
		
	}

}
