package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.OperatorDomain;
import co.edu.uco.treepruning.entity.OperatorEntity;

public class OperatorEntityAssembler implements EntityAssembler<OperatorEntity, OperatorDomain> {
	
	private static final EntityAssembler<OperatorEntity, OperatorDomain> INSTANCE = new OperatorEntityAssembler();
	
	private OperatorEntityAssembler() {
		
	}
	
	public static EntityAssembler<OperatorEntity, OperatorDomain> getOperatorEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public OperatorEntity toEntity(OperatorDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperatorDomain toDomain(OperatorEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OperatorEntity> toEntity(List<OperatorDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
