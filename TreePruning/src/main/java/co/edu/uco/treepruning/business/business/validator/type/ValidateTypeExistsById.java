package co.edu.uco.treepruning.business.business.validator.type;

import co.edu.uco.treepruning.business.business.rule.type.TypeExistsByIdRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateTypeExistsById implements Validator {
	
	private static final Validator INSTANCE = new ValidateTypeExistsById();
	
	private ValidateTypeExistsById() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}
	
	@Override
	public void validate(Object... data) {
		TypeExistsByIdRule.executeRule(data);		
	}

}
