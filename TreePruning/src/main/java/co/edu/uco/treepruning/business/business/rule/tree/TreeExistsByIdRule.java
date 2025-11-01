package co.edu.uco.treepruning.business.business.rule.tree;

import co.edu.uco.treepruning.business.business.rule.Rule;

public class TreeExistsByIdRule implements Rule{

	private static final Rule INSTANCE = new TreeExistsByIdRule();
	
	private TreeExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	@Override
	public void execute(final Object... data) {
		// TODO Auto-generated method stub
		
	}

}
