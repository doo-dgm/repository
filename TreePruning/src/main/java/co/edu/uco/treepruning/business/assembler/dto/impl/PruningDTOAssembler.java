package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.dto.PruningDTO;

public class PruningDTOAssembler implements DTOAssembler<PruningDTO, PruningDomain> {

	private static final DTOAssembler<PruningDTO, PruningDomain> INSTANCE = new PruningDTOAssembler();
	
	private PruningDTOAssembler() {
		
	}
	
	public static DTOAssembler<PruningDTO, PruningDomain> getPruningDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public PruningDTO toDTO(PruningDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruningDomain toDomain(PruningDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PruningDTO> toDTO(List<PruningDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
