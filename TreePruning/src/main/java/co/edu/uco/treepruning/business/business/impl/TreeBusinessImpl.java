package co.edu.uco.treepruning.business.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.TreeBusiness;
import co.edu.uco.treepruning.business.domain.TreeDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

import static co.edu.uco.treepruning.business.assembler.entity.impl.TreeEntityAssembler.getTreeEntityAssembler;

public class TreeBusinessImpl implements TreeBusiness{
	
	private DAOFactory daoFactory;
	
	public TreeBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TreeDomain> findAllTrees() {
		var treeEntityList = daoFactory.getTreeDAO().findAll();
		var statusDomainList = new ArrayList<TreeDomain>();
		
		for (var treeEntity : treeEntityList) {
			statusDomainList.add(getTreeEntityAssembler().toDomain(treeEntity));
		}
		return statusDomainList;
	}

	@Override
	public List<TreeDomain> findTreesByFilter(final TreeDomain treeFilters) {
		var treeEntity = getTreeEntityAssembler().toEntity(treeFilters);
		var treeEntityList = daoFactory.getTreeDAO().findByFilter(treeEntity);
		var treeDomainList = new ArrayList<TreeDomain>();
		
		for (var tree : treeEntityList) {
			treeDomainList.add(getTreeEntityAssembler().toDomain(tree));
		}
		
		return treeDomainList;
	}

	@Override
	public TreeDomain findSpecificTree(final UUID id) {
		var treeEntity = daoFactory.getTreeDAO().findById(id);
		
		return getTreeEntityAssembler().toDomain(treeEntity);
	}

}
