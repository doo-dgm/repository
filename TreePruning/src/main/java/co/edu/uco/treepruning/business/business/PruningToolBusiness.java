package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.PruningToolDomain;

public interface PruningToolBusiness {
	void addPruningTool(PruningToolDomain pruningToolDomain);
	
	void updatePruningTool(UUID id, PruningToolDomain pruningToolDomain);

	List<PruningToolDomain> examineAllTools();
	
	PruningToolDomain findSpecifictool(UUID id);
	
	void removePruningTool(UUID id);
}
