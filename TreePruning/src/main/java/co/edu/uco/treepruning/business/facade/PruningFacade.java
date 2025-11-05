package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.PruningDTO;
import co.edu.uco.treepruning.dto.StatusDTO;

public interface PruningFacade {
void scheduleCorrectivePruning(PruningDTO pruningDTO);
	
	void cancelPruning(UUID id, StatusDTO status);
	
	void reschedulePruning(UUID id, PruningDTO pruningDTO);
	
	void completePruning(UUID id, StatusDTO status);
	
	List<PruningDTO> findAllPrunings();
	
	List<PruningDTO> findPruningsByFilter(PruningDTO pruningFilters);
	
	PruningDTO findSpecificPruning(UUID id);
}
