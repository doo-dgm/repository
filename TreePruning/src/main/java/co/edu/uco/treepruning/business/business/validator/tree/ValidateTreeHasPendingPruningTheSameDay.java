package co.edu.uco.treepruning.business.business.validator.tree;

import co.edu.uco.treepruning.business.business.rule.tree.TreeHasPendingPruningTheSameDayRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateTreeHasPendingPruningTheSameDay implements Validator {
	
	private static final Validator INSTANCE = new ValidateTreeHasPendingPruningTheSameDay();
	
	private ValidateTreeHasPendingPruningTheSameDay() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		TreeHasPendingPruningTheSameDayRule.executeRule(data);
	}
}
