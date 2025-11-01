package co.edu.uco.treepruning.business.business.rule.status;

import co.edu.uco.treepruning.business.business.rule.Rule;

public class StatusExistsByIdRule implements Rule {

	private static final Rule INSTANCE = new StatusExistsByIdRule();
	
	private StatusExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	@Override
	public void execute(final Object... data) {
		// TODO Auto-generated method stub
		
	}

}
