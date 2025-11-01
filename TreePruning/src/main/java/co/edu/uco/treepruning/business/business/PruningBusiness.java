package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.business.domain.StatusDomain;

public interface PruningBusiness {
	
	void schedulePruning(PruningDomain pruningDomain);
	
	void cancelPruning(UUID id, final StatusDomain status);
	
	void reschedulePruning(UUID id, PruningDomain pruningDomain);
	
	void completePruning(UUID id, StatusDomain status);
	
	List<PruningDomain> findAllPrunings();
	
	List<PruningDomain> findPruningsByFilter(PruningDomain pruningFilters);
	
	PruningDomain findSpecificPruning(UUID id);
	
}
