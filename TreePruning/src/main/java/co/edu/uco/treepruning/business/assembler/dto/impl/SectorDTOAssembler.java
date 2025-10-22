package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.SectorDomain;
import co.edu.uco.treepruning.dto.SectorDTO;

public class SectorDTOAssembler implements DTOAssembler<SectorDTO, SectorDomain>{
	
	private static final DTOAssembler<SectorDTO, SectorDomain> INSTANCE = new SectorDTOAssembler();
	
	private SectorDTOAssembler() {
		
	}
	
	public static DTOAssembler<SectorDTO, SectorDomain> getSectorDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public SectorDTO toDTO(SectorDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SectorDomain toDomain(SectorDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SectorDTO> toDTO(List<SectorDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
