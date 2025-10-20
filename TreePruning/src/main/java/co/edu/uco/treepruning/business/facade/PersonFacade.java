package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.PersonDTO;

public interface PersonFacade {
	void registerNewPersonInformation(PersonDTO personDTO);
	
	void dropUserInformation(UUID id);
	
	void updateUserInformation(UUID id, PersonDTO userDto);
	
	List<PersonDTO> findAllUsers();
	
	List<PersonDTO> findUsersByFilter(PersonDTO userFilters);
	
	PersonDTO findSpecificUser(UUID id);
	
	void confirmMobileNumber(UUID id, int confirmationCode);
	
	void confirmEmail(UUID id, int confirmationCode);
	
	void sendMobileNumberConfirmation(UUID id);
	
	void sendEmailConfirmation(UUID id);
}
