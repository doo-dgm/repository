package co.edu.uco.treepruning.business.assembler.entity.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.CountryDTOAssembler.getCountryDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.StateDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
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
		var domainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var countryEntityTmp = getCountryEntityAssembler().toEntity(domainTmp.getCountry());
		return new StateEntity(domainTmp.getId(), domainTmp.getName(), countryEntityTmp);
	}

	@Override
	public StateDomain toDomain(StateEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new StateDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var countryDomainTmp = getCountryEntityAssembler().toDomain(entityTmp.getCountry());
		
		return new StateDomain(entityTmp.getId(), countryDomainTmp, entityTmp.getName());
	}

	@Override
	public List<StateEntity> toEntity(List<StateDomain> domainList) {
		var stateEntityList = new ArrayList<StateEntity>();
		
		for (var state : domainList) {
			stateEntityList.add(toEntity(state));
		}
		
		return stateEntityList;
	}

}
