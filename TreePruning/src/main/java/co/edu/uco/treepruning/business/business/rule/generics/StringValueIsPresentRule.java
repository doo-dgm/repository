package co.edu.uco.treepruning.business.business.rule.generics;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;

public class StringValueIsPresentRule implements Rule {
	
	private static final StringValueIsPresentRule INSTANCE = new StringValueIsPresentRule();
	
	private StringValueIsPresentRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_STRING_VALUE_IS_PRESENT_DATA_IS_NULL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STRING_VALUE_IS_PRESENT_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 3 ) {
			var userMessage = MessagesEnum.USER_ERROR_STRING_VALUE_IS_PRESENT_INSUFFICIENT_PARAMETERS.getContent().formatted(String.valueOf(data.length));
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STRING_VALUE_IS_PRESENT_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		boolean mustApplyTrim = (boolean) data[2];
		
		if ((mustApplyTrim)
				? TextHelper.isEmptyWithTrim(stringData)
					: TextHelper.isEmpty(stringData)) {
			var userMessage = MessagesEnum.USER_ERROR_STRING_VALUE_IS_PRESENT.getContent().formatted(dataName);
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STRING_VALUE_IS_PRESENT.getContent().formatted(dataName);
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
	}

}