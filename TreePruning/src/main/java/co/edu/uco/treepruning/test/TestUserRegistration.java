package co.edu.uco.treepruning.test;

import co.edu.uco.treepruning.business.facade.impl.PersonFacadeImpl;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.CountryDTO;
import co.edu.uco.treepruning.dto.DocumentDTO;
import co.edu.uco.treepruning.dto.MunicipalityDTO;
import co.edu.uco.treepruning.dto.PersonDTO;
import co.edu.uco.treepruning.dto.StateDTO;

public class TestUserRegistration {
	public static void main(String[] args) {
		try {
			var idType = new DocumentDTO();
			idType.setId(UUIDHelper.getUUIDHelper().getFromString("86ef14dd-4160-4cd5-9339-56366ecfb14a"));
			//idType.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			idType.setName("Cédula de ciudadanía");
			
			var country = new CountryDTO();
			country.setId(UUIDHelper.getUUIDHelper().getFromString("86ef14dd-4160-4cd5-9339-56366ecfb1bd"));
			//country.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			country.setName("Colombia");
			
			var state = new StateDTO();
			state.setId(UUIDHelper.getUUIDHelper().getFromString("86ef14dd-4160-4cd5-9339-56366ecfb1bc"));
			//state.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			state.setName("Cundinamarca");
			state.setCountry(country);
			
			var city = new MunicipalityDTO();
			city.setId(UUIDHelper.getUUIDHelper().getFromString("86ef14dd-4160-4cd5-9339-56366ecfb1b5"));
			//city.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			city.setName("Bogotá");
			city.setState(state);
			
			var user = new PersonDTO();
			//user.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			user.setDocumentNumber("111111111");
			user.setFirstName("Juan");
			user.setSecondName("Carlos");
			user.setFirstLastName("Pérez");
			user.setSecondLastName("Gómez");
			user.setEmail("danilo");
			user.setPhone("3001234567");
			user.setDocument(idType);
			user.setEmailConfirmed(false);
			user.setPhoneConfirmed(false);
						
			// Colocar todos los parametros, menos el id
			
			var facade = new PersonFacadeImpl();
			facade.registerNewPersonInformation(user);
			
			System.out.println("Gane el semestre");
		} catch (TreePruningException e) {
			System.err.println(e.getUserMessage());
			System.err.println(e.getTechnicalMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
