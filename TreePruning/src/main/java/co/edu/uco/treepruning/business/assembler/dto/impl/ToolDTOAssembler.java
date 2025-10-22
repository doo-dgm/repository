package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.ToolDomain;
import co.edu.uco.treepruning.dto.ToolDTO;

public class ToolDTOAssembler implements DTOAssembler<ToolDTO, ToolDomain> {
	
	private static final DTOAssembler<ToolDTO, ToolDomain> INSTANCE = new ToolDTOAssembler();
	
	private ToolDTOAssembler() {
		
	}
	
	public static DTOAssembler<ToolDTO, ToolDomain> getToolDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public ToolDTO toDTO(ToolDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToolDomain toDomain(ToolDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ToolDTO> toDTO(List<ToolDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
