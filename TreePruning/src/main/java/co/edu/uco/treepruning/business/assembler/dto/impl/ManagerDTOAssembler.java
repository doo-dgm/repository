package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.ManagerDomain;
import co.edu.uco.treepruning.dto.ManagerDTO;

public class ManagerDTOAssembler implements DTOAssembler<ManagerDTO, ManagerDomain> {
	
	private static final DTOAssembler<ManagerDTO, ManagerDomain> INSTANCE = new ManagerDTOAssembler();
	
	private ManagerDTOAssembler() {

	}

	public static DTOAssembler<ManagerDTO, ManagerDomain> getManagerDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public ManagerDTO toDTO(ManagerDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagerDomain toDomain(ManagerDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManagerDTO> toDTO(List<ManagerDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
