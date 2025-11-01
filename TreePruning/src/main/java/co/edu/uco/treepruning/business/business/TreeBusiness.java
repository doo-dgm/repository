package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.TreeDomain;

public interface TreeBusiness {
	List<TreeDomain> findAllTrees();
	
	List<TreeDomain> findTreesByFilter(TreeDomain treeFilters);
	
	TreeDomain findSpecificTree(UUID id);
}
