package co.edu.uco.treepruning.business.business.rule.generics;

import java.time.LocalDate;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;

public class DateFormatValueIsValidRule implements Rule {
	
	private static final DateFormatValueIsValidRule INSTANCE = new DateFormatValueIsValidRule();
	
	private DateFormatValueIsValidRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_DATE_FORMAT_RULE_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DATE_FORMAT_RULE_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_DATE_FORMAT_RULE_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DATE_FORMAT_RULE_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		var dateData = (LocalDate) data[0];
		var dataName = (String) data[1];
		
		if (DateHelper.getDateHelper().isDefaultDate(dateData)) {
			var userMessage = String.format(MessagesEnum.USER_ERROR_DATE_FORMAT_INVALID_VALUE.getTitle(), dataName);
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_DATE_FORMAT_INVALID_VALUE.getContent(), dataName);
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
	}

}