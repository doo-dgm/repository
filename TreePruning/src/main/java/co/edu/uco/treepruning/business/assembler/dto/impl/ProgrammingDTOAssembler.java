package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.ProgrammingDomain;
import co.edu.uco.treepruning.dto.ProgrammingDTO;

public class ProgrammingDTOAssembler implements DTOAssembler<ProgrammingDTO, ProgrammingDomain> {

	private static final DTOAssembler<ProgrammingDTO, ProgrammingDomain> INSTANCE = new ProgrammingDTOAssembler();
	
	private ProgrammingDTOAssembler() {
		
	}
	
	public static DTOAssembler<ProgrammingDTO, ProgrammingDomain> getProgrammingDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public ProgrammingDTO toDTO(ProgrammingDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProgrammingDomain toDomain(ProgrammingDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProgrammingDTO> toDTO(List<ProgrammingDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
