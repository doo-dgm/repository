package co.edu.uco.treepruning.business.business.rule.generics;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;

public class IdValueIsNotDefaultValueRule implements Rule {
	 
	private static final IdValueIsNotDefaultValueRule INSTANCE = new IdValueIsNotDefaultValueRule();
	
	private IdValueIsNotDefaultValueRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_ID_VALUE_IS_NOT_DEFAULT_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ID_VALUE_IS_NOT_DEFAULT_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage, 	technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_ID_VALUE_IS_NOT_DEFAULT_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ID_VALUE_IS_NOT_DEFAULT_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage, 	technicalMessage);
		}
		
		var id = (UUID) data[0];
		var name = (String) data[1];
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(id)) {
			var userMessage = String.format(MessagesEnum.USER_ERROR_ID_VALUE_IS_DEFAULT.getTitle(), name);
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_ID_VALUE_IS_DEFAULT.getContent(), name);
			throw TreePruningException.create(userMessage, 	technicalMessage);
		}
		
	}

}