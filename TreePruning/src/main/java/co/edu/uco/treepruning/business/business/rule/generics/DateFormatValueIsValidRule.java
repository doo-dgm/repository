package co.edu.uco.treepruning.business.business.rule.generics;

import co.edu.uco.treepruning.business.business.rule.Rule;

public class DateFormatValueIsValidRule implements Rule {
	
	private static final DateFormatValueIsValidRule INSTANCE = new DateFormatValueIsValidRule();
	
	private DateFormatValueIsValidRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(Object... data) {
		// TODO Auto-generated method stub
		
	}

}
