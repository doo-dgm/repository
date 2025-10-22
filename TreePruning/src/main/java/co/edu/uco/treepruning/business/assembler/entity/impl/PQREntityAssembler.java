package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.PQRDomain;
import co.edu.uco.treepruning.entity.PQREntity;

public class PQREntityAssembler implements EntityAssembler<PQREntity, PQRDomain> {
	
	private static final EntityAssembler<PQREntity, PQRDomain> INSTANCE = new PQREntityAssembler();
	
	private PQREntityAssembler() {
		
	}
	
	public static EntityAssembler<PQREntity, PQRDomain> getPQREntityAssembler() {
		return INSTANCE;
	}

	@Override
	public PQREntity toEntity(PQRDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PQRDomain toDomain(PQREntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PQREntity> toEntity(List<PQRDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
