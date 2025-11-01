package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.TreeDTO;

public interface TreeFacade {

	List<TreeDTO> findAllTrees();

	List<TreeDTO> findTreesByFilter(TreeDTO treeFilters);

	TreeDTO findSpecificTree(UUID id);

}
