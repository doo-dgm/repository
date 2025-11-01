package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.StatusDTO;

public interface StatusFacade {

	List<StatusDTO> findAllStatuses();

	List<StatusDTO> findStatusesByFilter(StatusDTO statusFilters);

	StatusDTO findSpecificStatus(UUID id);

}
