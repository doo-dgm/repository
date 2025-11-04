package co.edu.uco.treepruning.business.business.validator.quadrille;

import co.edu.uco.treepruning.business.business.rule.quadrille.QuadrilleExistsByIdRule;
import co.edu.uco.treepruning.business.business.validator.Validator;

public class ValidateQuadrilleExistsById implements Validator{
	
	private static final Validator INSTANCE = new ValidateQuadrilleExistsById();
	
	private ValidateQuadrilleExistsById() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		QuadrilleExistsByIdRule.executeRule(data);
		
	}

}
