package co.edu.uco.treepruning.business.business.rule.type;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class TypeIsPreventiveRule implements Rule {

	private static final TypeIsPreventiveRule INSTANCE = new TypeIsPreventiveRule();

	private TypeIsPreventiveRule() {
	}

	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_PREVENTIVE_RULE_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_PREVENTIVE_RULE_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_PREVENTIVE_RULE_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_PREVENTIVE_RULE_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		var type = daoFactory.getTypeDAO().findById(id);
		
		if (ObjectHelper.isNull(type)) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_NOT_FOUND_PREVENTIVE.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_NOT_FOUND_PREVENTIVE.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (!"Preventiva".equals(type.getName())) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_IS_NOT_PREVENTIVE.getTitle();
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_TYPE_IS_NOT_PREVENTIVE.getContent(), id, type.getName());
			throw TreePruningException.create(userMessage, technicalMessage);
		}
	}

}