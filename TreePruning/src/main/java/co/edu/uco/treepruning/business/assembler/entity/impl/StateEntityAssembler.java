package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.StateDomain;
import co.edu.uco.treepruning.entity.StateEntity;

public class StateEntityAssembler implements EntityAssembler<StateEntity, StateDomain> {
	
	private static final EntityAssembler<StateEntity, StateDomain> INSTANCE = new StateEntityAssembler();
	
	private StateEntityAssembler() {
		
	}
	
	public static EntityAssembler<StateEntity, StateDomain> getStateEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public StateEntity toEntity(StateDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateDomain toDomain(StateEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> toEntity(List<StateDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
