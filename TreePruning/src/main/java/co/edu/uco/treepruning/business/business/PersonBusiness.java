package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.PersonDomain;

public interface PersonBusiness {
	void registerNewPersonInformation(PersonDomain personDomain);
	
	void dropPersonInformation(UUID id);
	
	void updatePersonInformation(UUID id, PersonDomain personDomain);
	
	List<PersonDomain> findAllPersons();
	
	List<PersonDomain> findPersonsByFilter(PersonDomain personFilters);
	
	PersonDomain findSpecificPerson(UUID id);
	
	void confirmMobileNumber(UUID id, int confirmationCode);
	
	void confirmEmail(UUID id, int confirmationCode);
	
	void sendMobileNumberConfirmation(UUID id);
	
	void sendEmailConfirmation(UUID id);
}
