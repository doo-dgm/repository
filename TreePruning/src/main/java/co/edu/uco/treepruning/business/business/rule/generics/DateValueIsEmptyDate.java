package co.edu.uco.treepruning.business.business.rule.generics;

import java.time.LocalDate;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;

public class DateValueIsEmptyDate implements Rule {
	
	private static final DateValueIsEmptyDate INSTANCE = new DateValueIsEmptyDate();
	
	private DateValueIsEmptyDate() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_DATE_VALUE_IS_EMPTY_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DATE_VALUE_IS_EMPTY_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_DATE_VALUE_IS_EMPTY_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DATE_VALUE_IS_EMPTY_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
		var dateData = (LocalDate) data[0];
		var dataName = (String) data[1];
		
		if (DateHelper.getDateHelper().isDefaultDate(dateData)) {
			var userMessage = String.format(MessagesEnum.USER_ERROR_DATE_VALUE_IS_EMPTY.getTitle(), dataName);
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_DATE_VALUE_IS_EMPTY.getContent(), dataName);
			throw TreePruningException.create(userMessage,	technicalMessage);
		}
		
	}

}