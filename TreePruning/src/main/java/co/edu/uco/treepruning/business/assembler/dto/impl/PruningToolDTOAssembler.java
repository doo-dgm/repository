package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.PruningToolDomain;
import co.edu.uco.treepruning.dto.PruningToolDTO;

public class PruningToolDTOAssembler implements DTOAssembler<PruningToolDTO, PruningToolDomain> {

	private static final DTOAssembler<PruningToolDTO, PruningToolDomain> INSTANCE = new PruningToolDTOAssembler();
	
	private PruningToolDTOAssembler() {
		
	}
	
	public static DTOAssembler<PruningToolDTO, PruningToolDomain> getPruningToolDTOAssembler() {
		return INSTANCE;
	}
	
	
	@Override
	public PruningToolDTO toDTO(PruningToolDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruningToolDomain toDomain(PruningToolDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PruningToolDTO> toDTO(List<PruningToolDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
