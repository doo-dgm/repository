package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.entity.PruningEntity;

public class PruningEntityAssembler implements EntityAssembler<PruningEntity, PruningDomain> {
	
	private static final EntityAssembler<PruningEntity, PruningDomain> INSTANCE = new PruningEntityAssembler();
	
	private PruningEntityAssembler() {
		
	}
	
	public static EntityAssembler<PruningEntity, PruningDomain> getPruningEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public PruningEntity toEntity(PruningDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruningDomain toDomain(PruningEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PruningEntity> toEntity(List<PruningDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
