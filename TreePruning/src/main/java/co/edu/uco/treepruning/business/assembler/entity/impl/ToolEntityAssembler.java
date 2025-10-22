package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.ToolDomain;
import co.edu.uco.treepruning.entity.ToolEntity;

public class ToolEntityAssembler implements EntityAssembler<ToolEntity, ToolDomain> {
	
	private static final EntityAssembler<ToolEntity, ToolDomain> INSTANCE = new ToolEntityAssembler();
	
	private ToolEntityAssembler() {
		
	}
	
	public static EntityAssembler<ToolEntity, ToolDomain> getToolEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public ToolEntity toEntity(ToolDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToolDomain toDomain(ToolEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ToolEntity> toEntity(List<ToolDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
