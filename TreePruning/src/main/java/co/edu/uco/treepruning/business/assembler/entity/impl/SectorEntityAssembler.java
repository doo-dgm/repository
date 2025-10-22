package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.SectorDomain;
import co.edu.uco.treepruning.entity.SectorEntity;

public class SectorEntityAssembler implements EntityAssembler<SectorEntity, SectorDomain> {
	
	private static final EntityAssembler<SectorEntity, SectorDomain> INSTANCE = new SectorEntityAssembler();
	
	private SectorEntityAssembler() {
		
	}
	
	public static EntityAssembler<SectorEntity, SectorDomain> getSectorEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public SectorEntity toEntity(SectorDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SectorDomain toDomain(SectorEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SectorEntity> toEntity(List<SectorDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
