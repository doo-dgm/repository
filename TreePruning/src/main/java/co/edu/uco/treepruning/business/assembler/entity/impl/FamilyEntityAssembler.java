package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.FamilyDomain;
import co.edu.uco.treepruning.entity.FamilyEntity;

public class FamilyEntityAssembler implements EntityAssembler<FamilyEntity, FamilyDomain> {
	
	private static final EntityAssembler<FamilyEntity, FamilyDomain> INSTANCE = new FamilyEntityAssembler();
	
	private FamilyEntityAssembler() {
		
	}
	
	public static EntityAssembler<FamilyEntity, FamilyDomain> getFamilyEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public FamilyEntity toEntity(FamilyDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamilyDomain toDomain(FamilyEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FamilyEntity> toEntity(List<FamilyDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}



}
