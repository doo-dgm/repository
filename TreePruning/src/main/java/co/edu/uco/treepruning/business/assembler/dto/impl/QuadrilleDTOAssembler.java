package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.QuadrilleDomain;
import co.edu.uco.treepruning.dto.QuadrilleDTO;

public class QuadrilleDTOAssembler implements DTOAssembler<QuadrilleDTO, QuadrilleDomain>{
	
	private static final DTOAssembler<QuadrilleDTO, QuadrilleDomain> INSTANCE = new QuadrilleDTOAssembler();
	
	private QuadrilleDTOAssembler() {
		
	}
	
	public static DTOAssembler<QuadrilleDTO, QuadrilleDomain> getQuadrilleDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public QuadrilleDTO toDTO(QuadrilleDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuadrilleDomain toDomain(QuadrilleDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuadrilleDTO> toDTO(List<QuadrilleDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
