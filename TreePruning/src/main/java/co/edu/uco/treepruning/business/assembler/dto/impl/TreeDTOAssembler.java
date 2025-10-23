package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import static co.edu.uco.treepruning.business.assembler.dto.impl.FamilyDTOAssembler.getFamilyDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.SectorDTOAssembler.getSectorDTOAssembler;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.TreeDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.TreeDTO;

public class TreeDTOAssembler implements DTOAssembler<TreeDTO, TreeDomain> {
	
	private static final DTOAssembler<TreeDTO, TreeDomain> INSTANCE = new TreeDTOAssembler();
	
	private TreeDTOAssembler() {
		
	}
	
	public static DTOAssembler<TreeDTO, TreeDomain> getTreeDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public TreeDTO toDTO(TreeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new TreeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var familyDtoTmp = getFamilyDTOAssembler().toDTO(domainTmp.getFamily());
		var sectorTmp =getSectorDTOAssembler().toDTO(domainTmp.getSector());
		return new TreeDTO(domainTmp.getId(), domainTmp.getLongitude(), domainTmp.getLatitude(), familyDtoTmp, sectorTmp);
	}

	@Override
	public TreeDomain toDomain(TreeDTO dto) {
		var dtoTmp =ObjectHelper.getDefault(dto, new TreeDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var familyDomainTmp = getFamilyDTOAssembler().toDomain(dtoTmp.getFamily());
		var sectorDomainTmp = getSectorDTOAssembler().toDomain(dtoTmp.getSector());
		return new TreeDomain(dtoTmp.getId(), dtoTmp.getLongitude(), dtoTmp.getLatitude(), familyDomainTmp, sectorDomainTmp);
	}

	@Override
	public List<TreeDTO> toDTO(List<TreeDomain> domainList) {
		var treeDTOList = new ArrayList<TreeDTO>();
		
		for (var tree : domainList) {
			treeDTOList.add(toDTO(tree));
		}
		
		return treeDTOList;
	}

}
