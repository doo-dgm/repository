package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.ManagerDomain;
import co.edu.uco.treepruning.entity.ManagerEntity;

public class ManagerEntityAssembler implements EntityAssembler<ManagerEntity, ManagerDomain> {
	
	private static final EntityAssembler<ManagerEntity, ManagerDomain> INSTANCE = new ManagerEntityAssembler();
	
	private ManagerEntityAssembler() {
		
	}
	
	public static EntityAssembler<ManagerEntity, ManagerDomain> getManagerEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public ManagerEntity toEntity(ManagerDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagerDomain toDomain(ManagerEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManagerEntity> toEntity(List<ManagerDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
