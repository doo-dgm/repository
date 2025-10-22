package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.MunicipalityDomain;
import co.edu.uco.treepruning.entity.MunicipalityEntity;

public class MunicipalityEntityAssembler implements EntityAssembler<MunicipalityEntity, MunicipalityDomain> {
	
	private static final EntityAssembler<MunicipalityEntity, MunicipalityDomain> INSTANCE = new MunicipalityEntityAssembler();
	
	private MunicipalityEntityAssembler() {
		
	}
	
	public static EntityAssembler<MunicipalityEntity, MunicipalityDomain> getMunicipalityEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public MunicipalityEntity toEntity(MunicipalityDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MunicipalityDomain toDomain(MunicipalityEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MunicipalityEntity> toEntity(List<MunicipalityDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
