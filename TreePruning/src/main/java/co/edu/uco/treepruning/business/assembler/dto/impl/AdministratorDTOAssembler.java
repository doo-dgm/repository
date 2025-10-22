package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.AdministratorDomain;
import co.edu.uco.treepruning.dto.AdministratorDTO;

public class AdministratorDTOAssembler implements DTOAssembler<AdministratorDTO, AdministratorDomain> {
	
	private static final DTOAssembler<AdministratorDTO, AdministratorDomain> INSTANCE = new AdministratorDTOAssembler();
	
	private AdministratorDTOAssembler() {
		
	}
	
	public static DTOAssembler<AdministratorDTO, AdministratorDomain> getAdministratorDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public AdministratorDTO toDTO(AdministratorDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdministratorDomain toDomain(AdministratorDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdministratorDTO> toDTO(List<AdministratorDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
