package co.edu.uco.treepruning.business.business;

import java.util.UUID;

public interface AdministratorBusiness {
	void findAllAdministrators();
	
	void findAdministratorByFilter(AdministratorBusiness administratorFilters);
	
	void findSpecificAdministrator(UUID id);
}
