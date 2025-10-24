package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.PruningDTO;

public interface PruningFacade {
void schedulePruning(PruningDTO pruningDTO);
	
	void cancelPruning(UUID id);
	
	void reschedulePruning(UUID id, PruningDTO pruningDTO);
	
	void completePruning(UUID id);
	
	List<PruningDTO> findAllPrunings();
	
	List<PruningDTO> findPruningsByFilter(PruningDTO pruningFilters);
	
	PruningDTO findSpecificPruning(UUID id);
}
