package co.edu.uco.treepruning.business.business.rule.pqr;

import co.edu.uco.treepruning.business.business.rule.Rule;

public class PQRExistsByIdRule implements Rule {

	private static final Rule INSTANCE = new PQRExistsByIdRule();
	
	private PQRExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	
	@Override
	public void execute(final Object... data) {
				
	}

}
