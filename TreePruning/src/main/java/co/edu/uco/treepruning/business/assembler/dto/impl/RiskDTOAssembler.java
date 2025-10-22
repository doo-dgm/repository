package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.RiskDomain;
import co.edu.uco.treepruning.dto.RiskDTO;

public class RiskDTOAssembler implements DTOAssembler<RiskDTO, RiskDomain>{
	
	private static final DTOAssembler<RiskDTO, RiskDomain> INSTANCE = new RiskDTOAssembler();
	
	private RiskDTOAssembler() {
		
	}
	
	public static DTOAssembler<RiskDTO, RiskDomain> getRiskDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public RiskDTO toDTO(RiskDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiskDomain toDomain(RiskDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskDTO> toDTO(List<RiskDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
