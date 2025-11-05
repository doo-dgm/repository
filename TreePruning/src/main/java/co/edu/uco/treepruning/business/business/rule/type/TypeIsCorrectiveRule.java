package co.edu.uco.treepruning.business.business.rule.type;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.rule.Rule;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
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
		
		var typeEntity = new TypeEntity();
		typeEntity.setName("Correctiva");
		
		var status = daoFactory.getTypeDAO().findByFilter(typeEntity);
		
		if (status.isEmpty()) {
			var userMessage = "No existe un tipo registrado como correctivo...";
			var technicalMessage = "No existe ningun tipo de poda con el nombre 'Correctiva' en la base de datos...";
			throw TreePruningException.create(userMessage, technicalMessage);
		}

		
	}

}
