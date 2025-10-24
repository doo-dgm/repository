package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.PruningDomain;

public interface PruningBusiness {
	
	void schedulePruning(PruningDomain pruningDomain);
	
	void cancelPruning(UUID id);
	
	void reschedulePruning(UUID id, PruningDomain pruningDomain);
	
	void completePruning(UUID id);
	
	List<PruningDomain> findAllPrunings();
	
	List<PruningDomain> findPruningsByFilter(PruningDomain pruningFilters);
	
	PruningDomain findSpecificPruning(UUID id);
	
}
