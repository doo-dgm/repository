package co.edu.uco.treepruning.business.assembler.entity.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.StateDTOAssembler.getStateDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.MunicipalityDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.MunicipalityEntity;

public class MunicipalityEntityAssembler implements EntityAssembler<MunicipalityEntity, MunicipalityDomain> {
	
	private static final EntityAssembler<MunicipalityEntity, MunicipalityDomain> INSTANCE = new MunicipalityEntityAssembler();
	
	private MunicipalityEntityAssembler() {
		
	}
	
	public static EntityAssembler<MunicipalityEntity, MunicipalityDomain> getMunicipalityEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public MunicipalityEntity toEntity(MunicipalityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new MunicipalityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var stateEntityTmp = getStateEntityAssembler().toEntity(domainTmp.getState());
		return new MunicipalityEntity(domainTmp.getId(), domainTmp.getName(), stateEntityTmp);
	}

	@Override
	public MunicipalityDomain toDomain(MunicipalityEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new Municipalityentity(UUIDHelper.getUUIDHelper().getDefault()));
		var stateDomainTmp = getStateEntityAssembler().toDomain(entityTmp.getState());
		return new MunicipalityDomain(entityTmp.getId(), entityTmp.getName(), stateDomainTmp);
	}

	@Override
	public List<MunicipalityEntity> toEntity(List<MunicipalityDomain> domainList) {
		var municipalityEntityList = new ArrayList<MunicipalityEntity>();
		
		for (var municipality : domainList) {
			municipalityEntityList.add(toEntity(municipality));
		}
		
		return municipalityEntityList;
	}

}
