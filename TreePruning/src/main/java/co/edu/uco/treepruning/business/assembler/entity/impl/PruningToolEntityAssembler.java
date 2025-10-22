package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.PruningToolDomain;
import co.edu.uco.treepruning.entity.PruningToolEntity;

public class PruningToolEntityAssembler implements EntityAssembler<PruningToolEntity, PruningToolDomain> {
	
	private static final EntityAssembler<PruningToolEntity, PruningToolDomain> INSTANCE = new PruningToolEntityAssembler();
	
	private PruningToolEntityAssembler() {
		
	}
	
	public static EntityAssembler<PruningToolEntity, PruningToolDomain> getPruningToolEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public PruningToolEntity toEntity(PruningToolDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruningToolDomain toDomain(PruningToolEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PruningToolEntity> toEntity(List<PruningToolDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}



}
