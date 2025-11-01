package co.edu.uco.treepruning.business.business.validator.programming;

import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateProgrammingExistsById implements Validator{
	
	private static final Validator INSTANCE = new ValidateProgrammingExistsById();
	
	private ValidateProgrammingExistsById() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		// TODO Auto-generated method stub
		
	}

}
