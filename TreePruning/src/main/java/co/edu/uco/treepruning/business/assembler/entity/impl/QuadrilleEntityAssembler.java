package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.QuadrilleDomain;
import co.edu.uco.treepruning.entity.QuadrilleEntity;

public class QuadrilleEntityAssembler implements EntityAssembler<QuadrilleEntity, QuadrilleDomain> {
	
	private static final EntityAssembler<QuadrilleEntity, QuadrilleDomain> INSTANCE = new QuadrilleEntityAssembler();
	
	private QuadrilleEntityAssembler() {
		
	}
	
	public static EntityAssembler<QuadrilleEntity, QuadrilleDomain> getQuadrilleEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public QuadrilleEntity toEntity(QuadrilleDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuadrilleDomain toDomain(QuadrilleEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuadrilleEntity> toEntity(List<QuadrilleDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
