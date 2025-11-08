package co.edu.uco.treepruning.business.business.rule.type;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.entity.TypeEntity;

public class TypeIsCorrectiveRule implements Rule {
	
	private static final TypeIsCorrectiveRule INSTANCE = new TypeIsCorrectiveRule();
	
	private TypeIsCorrectiveRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_RULE_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_RULE_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 1) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_RULE_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_RULE_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}

		var daoFactory = (DAOFactory) data[1];
		
		var typeEntity = new TypeEntity();
		typeEntity.setName("Correctiva");
		
		var status = daoFactory.getTypeDAO().findByFilter(typeEntity);
		
		if (status.isEmpty()) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_NOT_FOUND_CORRECTIVE.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_NOT_FOUND_CORRECTIVE.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}

		
	}

}