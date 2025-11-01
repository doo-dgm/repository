package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.ProgrammingDTO;

public interface ProgrammingFacade {

	List<ProgrammingDTO> findAllProgrammings();

	List<ProgrammingDTO> findProgrammingsByFilter(ProgrammingDTO programmingFilters);

	ProgrammingDTO findSpecificProgramming(UUID id);

}
