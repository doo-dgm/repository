package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.StatusDomain;

public interface StatusBusiness {
	List<StatusDomain> listAllStatuses();
	
	List<StatusDomain> listStatusesByCriteria(StatusDomain statusCriteria);
	
	StatusDomain getStatusById(UUID id);
}
