package co.edu.uco.treepruning.business.business.rule.quadrille;


import co.edu.uco.treepruning.business.business.rule.Rule;
public class QuadrilleExistsByIdRule implements Rule {
	
	private static final Rule INSTANCE = new QuadrilleExistsByIdRule();
	
	private QuadrilleExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
	}

}