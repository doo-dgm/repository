package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.MunicipalityDomain;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MunicipalityDomain toDomain(MunicipalityDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MunicipalityDTO> toDTO(List<MunicipalityDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}	

}
