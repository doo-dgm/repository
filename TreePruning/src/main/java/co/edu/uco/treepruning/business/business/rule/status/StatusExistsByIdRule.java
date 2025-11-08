package co.edu.uco.treepruning.business.business.rule.status;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class StatusExistsByIdRule implements Rule {

	private static final Rule INSTANCE = new StatusExistsByIdRule();
	
	private StatusExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}
	
	@Override
	public void execute(final Object... data) {
		
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_STATUS_EXISTS_BY_ID_DATA_IS_NULL.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATUS_EXISTS_BY_ID_DATA_IS_NULL.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_STATUS_EXISTS_BY_ID_INSUFFICIENT_PARAMETERS.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATUS_EXISTS_BY_ID_INSUFFICIENT_PARAMETERS.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(id)) {
			var userMessage = MessagesEnum.USER_ERROR_STATUS_ID_IS_EMPTY.getTitle();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATUS_ID_IS_EMPTY.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var daoFactory = (DAOFactory) data[1];
		
		var status = daoFactory.getStatusDAO().findById(id);

		if (UUIDHelper.getUUIDHelper().isDefaultUUID(status.getId())) {
			var userMessage = MessagesEnum.USER_ERROR_STATUS_NOT_FOUND_BY_ID.getTitle();
			var technicalMessage = String.format(MessagesEnum.TECHNICAL_ERROR_STATUS_NOT_FOUND_BY_ID.getContent(), id.toString());
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
	}

}