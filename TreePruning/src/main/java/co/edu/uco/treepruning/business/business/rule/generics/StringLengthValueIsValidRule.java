package co.edu.uco.treepruning.business.business.rule.generics;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;

public class StringLengthValueIsValidRule implements Rule {
	
	private static final Rule INSTANCE = new StringLengthValueIsValidRule();
	
	private StringLengthValueIsValidRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_STRING_LENGTH_RULE_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STRING_LENGTH_RULE_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		if (data.length < 5) {
			var userMessage = MessagesEnum.USER_ERROR_STRING_LENGTH_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STRING_LENGTH_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		var minLength = (Integer) data[2];
		var maxLength = (Integer) data[3];
		var mustApplyTrim = (boolean) data[4];
		
		if (TextHelper.lenthIsValid(stringData, minLength, maxLength, mustApplyTrim)) {
			var userMessage = String.format(MessagesEnum.USER_ERROR_STRING_LENGTH_INVALID_LENGTH.getTitle(), dataName, String.valueOf(minLength), String.valueOf(maxLength));
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_STRING_LENGTH_INVALID_LENGTH.getContent(), dataName, String.valueOf(minLength), String.valueOf(maxLength));
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
	}

}