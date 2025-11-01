package co.edu.uco.treepruning.business.business.rule.pruning;

import co.edu.uco.treepruning.business.business.rule.Rule;

public class PruningExistsByIdRule implements Rule {
	
	private static final Rule INSTANCE = new PruningExistsByIdRule();
	
	private PruningExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		// TODO Auto-generated method stub
		
	}

}
