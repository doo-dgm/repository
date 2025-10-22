package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.StateDTOAssembler.getStateDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.MunicipalityDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.MunicipalityDTO;

public class MunicipalityDTOAssembler implements DTOAssembler<MunicipalityDTO, MunicipalityDomain>{
	
	private static final DTOAssembler<MunicipalityDTO, MunicipalityDomain> INSTANCE = new MunicipalityDTOAssembler();
	
	private MunicipalityDTOAssembler() {
		
	}
	
	public static DTOAssembler<MunicipalityDTO, MunicipalityDomain> getInstance() {
		return INSTANCE;
	}

	@Override
	public MunicipalityDTO toDTO(MunicipalityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new MunicipalityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var stateDtoTmp = getStateDTOAssembler().toDTO(domainTmp.getState());
		return new MunicipalityDTO(domainTmp.getId(), domainTmp.getName(), stateDtoTmp);
	}

	@Override
	public MunicipalityDomain toDomain(MunicipalityDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new MunicipalityDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var stateDomainTmp = getStateDTOAssembler().toDomain(dtoTmp.getState());
		return new MunicipalityDomain(dtoTmp.getId(), dtoTmp.getName(), stateDomainTmp);
	}

	@Override
	public List<MunicipalityDTO> toDTO(List<MunicipalityDomain> domainList) {
		var municipalityDTOList = new ArrayList<MunicipalityDTO>();
		
		for (var municipality : domainList) {
			municipalityDTOList.add(toDTO(municipality));
		}
		
		return municipalityDTOList;
	}	

}
