package co.edu.uco.treepruning.business.business.rule.type;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class TypeExistsByIdRule implements Rule {

	private static final TypeExistsByIdRule INSTANCE = new TypeExistsByIdRule();

	private TypeExistsByIdRule() {
	}

	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {

		if (ObjectHelper.isNull(data)) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(userMessage, technicalMessage);
		}

		if (data.length < 2) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(id)) {
			var userMessage = "El tipo especificado no existe...";
			var technicalMessage = "El tipo con id[".concat(id.toString()).concat("] no existe...");
			throw new RuntimeException(userMessage + " " + technicalMessage);
		}
	}

}
