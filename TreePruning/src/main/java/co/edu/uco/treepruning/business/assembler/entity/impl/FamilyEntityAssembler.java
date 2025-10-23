package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.FamilyDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
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
		var domainTmp = ObjectHelper.getDefault(domain, new FamilyDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new FamilyEntity(domainTmp.getId(), domainTmp.getScientificName(), domainTmp.getCommonName());
	}

	@Override
	public FamilyDomain toDomain(FamilyEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new FamilyEntity(UUIDHelper.getUUIDHelper().getDefault()));
		return new FamilyDomain(entityTmp.getId(), entityTmp.getScientificName(), entityTmp.getCommonName());
	}

	@Override
	public List<FamilyEntity> toEntity(List<FamilyDomain> domainList) {
		var familyEntityList = new ArrayList<FamilyEntity>();
		
		for (var family : domainList) {
			familyEntityList.add(toEntity(family));
		}
		
		return familyEntityList;
	}



}
