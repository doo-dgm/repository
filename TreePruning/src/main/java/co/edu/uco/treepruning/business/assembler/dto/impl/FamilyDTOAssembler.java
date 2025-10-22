package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.FamilyDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
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
		var domainTmp = ObjectHelper.getDefault(domain, new FamilyDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new FamilyDTO(domainTmp.getId(), domainTmp.getScientificName(), domainTmp.getCommonName());
	}

	@Override
	public FamilyDomain toDomain(FamilyDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new FamilyDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new FamilyDomain(dtoTmp.getId(), dtoTmp.getScientificName(), dtoTmp.getCommonName());
	}

	@Override
	public List<FamilyDTO> toDTO(List<FamilyDomain> domainList) {
		var familyDTOList = new ArrayList<FamilyDTO>();
		
		for (var family : domainList) {
			familyDTOList.add(toDTO(family));
		}
		
		return familyDTOList;
	}

}
