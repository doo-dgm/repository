package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.FamilyDomain;
import co.edu.uco.treepruning.dto.FamilyDTO;

public class FamilyDTOAssembler implements DTOAssembler<FamilyDTO, FamilyDomain> {
	
	private static final DTOAssembler<FamilyDTO, FamilyDomain> INSTANCE = new FamilyDTOAssembler();
	
	private FamilyDTOAssembler() {
		
	}
	
	public static DTOAssembler<FamilyDTO, FamilyDomain> getFamilyDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public FamilyDTO toDTO(FamilyDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamilyDomain toDomain(FamilyDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FamilyDTO> toDTO(List<FamilyDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
