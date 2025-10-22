package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.AdministratorDomain;
import co.edu.uco.treepruning.entity.AdministratorEntity;

public class AdministratorEntityAssembler implements EntityAssembler<AdministratorEntity, AdministratorDomain> {
	
	private static final EntityAssembler<AdministratorEntity, AdministratorDomain> INSTANCE = new AdministratorEntityAssembler();
	
	private AdministratorEntityAssembler() {
		
	}
	
	public static EntityAssembler<AdministratorEntity, AdministratorDomain> getAdministratorEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public AdministratorEntity toEntity(AdministratorDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdministratorDomain toDomain(AdministratorEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdministratorEntity> toEntity(List<AdministratorDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
