package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.PruningDTO;

public interface PruningFacade {
	void schedulePreventivePruning(PruningDTO pruningDTO);
	
	void scheduleCorrectivePruning(PruningDTO pruningDTO);
	
	void cancelPruning(PruningDTO pruningDTO);
	
	void reschedulePruning(UUID id, PruningDTO pruningDTO);
	
	void completePruning(PruningDTO pruningDTO);
	
	List<PruningDTO> findAllPrunings();
	
	List<PruningDTO> findPruningsByFilter(PruningDTO pruningFilters);
}
