package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.RiskDomain;
import co.edu.uco.treepruning.entity.RiskEntity;

public class RiskEntityAssembler implements EntityAssembler<RiskEntity, RiskDomain> {
	
	private static final EntityAssembler<RiskEntity, RiskDomain> INSTANCE = new RiskEntityAssembler();
	
	private RiskEntityAssembler() {
		
	}
	
	public static EntityAssembler<RiskEntity, RiskDomain> getRiskEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public RiskEntity toEntity(RiskDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiskDomain toDomain(RiskEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskEntity> toEntity(List<RiskDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
