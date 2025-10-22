package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.CountryDTOAssembler.getCountryDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.StateDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.StateDTO;

public class StateDTOAssembler  implements DTOAssembler<StateDTO, StateDomain>{
	
	private static final DTOAssembler<StateDTO, StateDomain> INSTANCE = new StateDTOAssembler();
	
	private StateDTOAssembler() {
		
	}
	
	public static DTOAssembler<StateDTO, StateDomain> getStateDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public StateDTO toDTO(StateDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var countryDtoTmp = getCountryDTOAssembler().toDTO(domainTmp.getCountry());
		return new StateDTO(domainTmp.getId(), domainTmp.getName(), countryDtoTmp);
	}

	@Override
	public StateDomain toDomain(StateDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new StateDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var countryDomainTmp = getCountryDTOAssembler().toDomain(dtoTmp.getCountry());
		
		return new StateDomain(dtoTmp.getId(), countryDomainTmp, dtoTmp.getName());
	}

	@Override
	public List<StateDTO> toDTO(List<StateDomain> domainList) {
		var stateDTOList = new ArrayList<StateDTO>();
		
		for (var state : domainList) {
			stateDTOList.add(toDTO(state));
		}
		
		return stateDTOList;
	}

}
