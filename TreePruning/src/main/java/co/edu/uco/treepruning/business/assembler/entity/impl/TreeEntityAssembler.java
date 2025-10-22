package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.TreeDomain;
import co.edu.uco.treepruning.entity.TreeEntity;

public class TreeEntityAssembler implements EntityAssembler<TreeEntity, TreeDomain> {
	
	private static final EntityAssembler<TreeEntity, TreeDomain> INSTANCE = new TreeEntityAssembler();
	
	private TreeEntityAssembler() {
		
	}
	
	public static EntityAssembler<TreeEntity, TreeDomain> getTreeEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public TreeEntity toEntity(TreeDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeDomain toDomain(TreeEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TreeEntity> toEntity(List<TreeDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
