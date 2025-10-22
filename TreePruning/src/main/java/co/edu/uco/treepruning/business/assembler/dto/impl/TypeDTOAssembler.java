package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.TypeDomain;
import co.edu.uco.treepruning.dto.TypeDTO;

public class TypeDTOAssembler implements DTOAssembler<TypeDTO, TypeDomain> {
	
	private static final DTOAssembler<TypeDTO, TypeDomain> INSTANCE = new TypeDTOAssembler();
	
	private TypeDTOAssembler() {
		
	}
	
	public static DTOAssembler<TypeDTO, TypeDomain> getInstance() {
		return INSTANCE;
	}

	@Override
	public TypeDTO toDTO(TypeDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDomain toDomain(TypeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeDTO> toDTO(List<TypeDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
