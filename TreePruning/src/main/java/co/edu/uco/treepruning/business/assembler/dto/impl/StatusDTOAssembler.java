package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.dto.StatusDTO;

public class StatusDTOAssembler implements DTOAssembler<StatusDTO, StatusDomain> {

	private static final DTOAssembler<StatusDTO, StatusDomain> INSTANCE = new StatusDTOAssembler();
	
	private StatusDTOAssembler() {
		
	}
	
	public static DTOAssembler<StatusDTO, StatusDomain> getStatusDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public StatusDTO toDTO(StatusDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDomain toDomain(StatusDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatusDTO> toDTO(List<StatusDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
