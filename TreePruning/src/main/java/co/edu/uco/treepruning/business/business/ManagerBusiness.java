package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.ManagerDomain;

public interface ManagerBusiness {
	void addManager(ManagerDomain managerDomain);
	
	List<ManagerDomain> listManagers(ManagerDomain managerFilters);
	
	ManagerDomain reviewManagerDetails(UUID managerId);
	
	void updateManagerInformation(UUID id, ManagerDomain managerDomain);
	
	void removeManager(UUID managerId);
}
