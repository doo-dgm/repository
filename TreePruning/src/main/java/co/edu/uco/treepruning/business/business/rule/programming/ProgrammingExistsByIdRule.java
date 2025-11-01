package co.edu.uco.treepruning.business.business.rule.programming;

import co.edu.uco.treepruning.business.business.rule.Rule;

public class ProgrammingExistsByIdRule implements Rule {

	private static final Rule INSTANCE = new ProgrammingExistsByIdRule();
	
	private ProgrammingExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	@Override
	public void execute(final Object... data) {
		// TODO Auto-generated method stub
		
	}

}
