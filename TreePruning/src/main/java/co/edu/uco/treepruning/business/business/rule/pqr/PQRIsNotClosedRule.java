package co.edu.uco.treepruning.business.business.rule.pqr;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class PQRIsNotClosedRule implements Rule {

	private static final Rule INSTANCE = new PQRIsNotClosedRule();
	
	private PQRIsNotClosedRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	
	@Override
	public void execute(final Object... data) {
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
		
		var pqr = daoFactory.getPQRDAO().findById(id);
		
		if (pqr.getStatus().getName().equals("Cerrado")) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_ALREADY_CLOSED.getTitle();
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_PQR_ALREADY_CLOSED.getContent(), id.toString());
			throw TreePruningException.create(userMessage, technicalMessage);
		}
	}

}