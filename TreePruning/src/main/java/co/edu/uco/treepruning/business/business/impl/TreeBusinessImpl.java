package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.TreeBusiness;
import co.edu.uco.treepruning.business.domain.TreeDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class TreeBusinessImpl implements TreeBusiness{
	
	private DAOFactory daoFactory;
	
	public TreeBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TreeDomain> findAllTrees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TreeDomain> findTreesByFilter(TreeDomain treeFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeDomain findSpecificTree(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
