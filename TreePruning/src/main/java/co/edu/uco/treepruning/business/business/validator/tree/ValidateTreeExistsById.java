package co.edu.uco.treepruning.business.business.validator.tree;

import co.edu.uco.treepruning.business.business.rule.tree.TreeExistsByIdRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateTreeExistsById implements Validator {
	
	private static final Validator INSTANCE = new ValidateTreeExistsById();
	
	private ValidateTreeExistsById() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(Object... data) {
		TreeExistsByIdRule.executeRule(data);
		
	}

}
