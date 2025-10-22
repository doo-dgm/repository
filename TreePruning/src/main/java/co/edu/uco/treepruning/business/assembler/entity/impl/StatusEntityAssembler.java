package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.entity.StatusEntity;

public class StatusEntityAssembler implements EntityAssembler<StatusEntity, StatusDomain> {
	
	private static final EntityAssembler<StatusEntity, StatusDomain> INSTANCE = new StatusEntityAssembler();
	
	private StatusEntityAssembler() {
		
	}
	
	public static EntityAssembler<StatusEntity, StatusDomain> getStatusEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public StatusEntity toEntity(StatusDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDomain toDomain(StatusEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatusEntity> toEntity(List<StatusDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
