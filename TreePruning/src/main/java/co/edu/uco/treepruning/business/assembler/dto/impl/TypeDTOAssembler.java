package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.TypeDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
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
		var domainTmp = ObjectHelper.getDefault(domain, new TypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new TypeDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public TypeDomain toDomain(TypeDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new TypeDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new TypeDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<TypeDTO> toDTO(List<TypeDomain> domainList) {
		var typeDTOList = new ArrayList<TypeDTO>();
		
		for (var type : domainList) {
			typeDTOList.add(toDTO(type));
		}
		return typeDTOList;
	}

}
