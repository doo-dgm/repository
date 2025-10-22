package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.ProgrammingDomain;
import co.edu.uco.treepruning.entity.ProgrammingEntity;

public class ProgrammingEntityAssembler implements EntityAssembler<ProgrammingEntity, ProgrammingDomain>{
	
	private static final EntityAssembler<ProgrammingEntity, ProgrammingDomain> INSTANCE = new ProgrammingEntityAssembler();
	
	private ProgrammingEntityAssembler() {
		
	}
	
	public static EntityAssembler<ProgrammingEntity, ProgrammingDomain> getProgrammingEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public ProgrammingEntity toEntity(ProgrammingDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProgrammingDomain toDomain(ProgrammingEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProgrammingEntity> toEntity(List<ProgrammingDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
