package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.PruningDomain;

public interface PruningBusiness {
	
	void schedulePreventivePruning(PruningDomain pruningDomain);
	
	void scheduleCorrectivePruning(PruningDomain pruningDomain);
	
	void cancelPruning(PruningDomain pruningDomain);
	
	void reschedulePruning(UUID id, PruningDomain pruningDomain);
	
	void completePruning(PruningDomain pruningDomain);
	
	List<PruningDomain> findAllPrunings();
	
	List<PruningDomain> findPruningsByFilter(PruningDomain pruningFilters);
	
}
