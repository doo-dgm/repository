package co.edu.uco.treepruning.business.business.rule.status;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;

public class StatusIsNotClosedRule implements Rule {
	
	private static final StatusIsNotClosedRule INSTANCE = new StatusIsNotClosedRule();
	
	private StatusIsNotClosedRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_IS_NOT_CLOSED_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_IS_NOT_CLOSED_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_IS_NOT_CLOSED_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_IS_NOT_CLOSED_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		var status = daoFactory.getStatusDAO().findById(id);
		
		if (status.getName().equals("Cerrado")) {
			var userMessage = MessagesEnum.USER_ERROR_STATUS_IS_CLOSED.getTitle();
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_STATUS_IS_CLOSED.getContent(), id.toString());
			throw TreePruningException.create(userMessage, technicalMessage);
		}
	}

}