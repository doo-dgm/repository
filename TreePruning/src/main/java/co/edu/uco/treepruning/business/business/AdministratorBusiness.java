package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.AdministratorDomain;

public interface AdministratorBusiness {
	List<AdministratorDomain> findAllAdministrators();
	
	List<AdministratorDomain> findAdministratorsByFilter(AdministratorBusiness administratorFilters);
	
	AdministratorDomain findSpecificAdministrator(UUID id);
}
