package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.ToolDomain;

public interface ToolBusiness {
	void incorporateTool(ToolDomain toolDomain);
	
	List<ToolDomain> listAvailableTools(ToolDomain toolFilters); 
	
	ToolDomain viewToolDetails(UUID toolId);
	
	void registerNewTool(UUID id, ToolDomain toolDomain);
	
	void removeTool(UUID toolId);
}
