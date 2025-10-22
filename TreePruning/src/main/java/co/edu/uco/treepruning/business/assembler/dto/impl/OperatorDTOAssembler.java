package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.OperatorDomain;
import co.edu.uco.treepruning.dto.OperatorDTO;

public class OperatorDTOAssembler implements DTOAssembler<OperatorDTO, OperatorDomain> {
	
	private static final DTOAssembler<OperatorDTO, OperatorDomain> INSTANCE = new OperatorDTOAssembler();
	
	private OperatorDTOAssembler() {
		
	}
	
	public static DTOAssembler<OperatorDTO, OperatorDomain> getOperatorAssembler() {
		return INSTANCE;
	}
	
	@Override
	public OperatorDTO toDTO(OperatorDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperatorDomain toDomain(OperatorDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OperatorDTO> toDTO(List<OperatorDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
