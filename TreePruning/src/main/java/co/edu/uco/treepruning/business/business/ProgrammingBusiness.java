package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.ProgrammingDomain;

public interface ProgrammingBusiness {
	List<ProgrammingDomain> findAllProgrammings();
	
	List<ProgrammingDomain> findProgrammingsByFilter(ProgrammingDomain programmingFilters);
	
	ProgrammingDomain findSpecificProgramming(UUID id);
}
