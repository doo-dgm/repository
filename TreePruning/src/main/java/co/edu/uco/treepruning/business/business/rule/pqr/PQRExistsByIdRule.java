package co.edu.uco.treepruning.business.business.rule.pqr;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class PQRExistsByIdRule implements Rule {

	private static final Rule INSTANCE = new PQRExistsByIdRule();
	
	private PQRExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	
	@Override
	public void execute(final Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_EXISTS_BY_ID_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_EXISTS_BY_ID_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_EXISTS_BY_ID_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_EXISTS_BY_ID_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(id)) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_ID_IS_EMPTY.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_ID_IS_EMPTY.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var daoFactory = (DAOFactory) data[1];
		
		var pqr = daoFactory.getPQRDAO().findById(id);
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(pqr.getId())) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_NOT_FOUND_BY_ID.getTitle();
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_PQR_NOT_FOUND_BY_ID.getContent(), id.toString());
			throw TreePruningException.create(userMessage, technicalMessage);
		}
	}

}