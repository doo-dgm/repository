package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.ToolDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.ToolDTO;

public class ToolDTOAssembler implements DTOAssembler<ToolDTO, ToolDomain> {
	
	private static final DTOAssembler<ToolDTO, ToolDomain> INSTANCE = new ToolDTOAssembler();
	
	private ToolDTOAssembler() {
		
	}
	
	public static DTOAssembler<ToolDTO, ToolDomain> getToolDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public ToolDTO toDTO(ToolDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new ToolDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new ToolDTO(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription());
	}

	@Override
	public ToolDomain toDomain(ToolDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new ToolDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new ToolDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getDescription());
	}

	@Override
	public List<ToolDTO> toDTO(List<ToolDomain> domainList) {
		var toolDTOList = new ArrayList<ToolDTO>();
		
		for (var tool : domainList) {
			toolDTOList.add(toDTO(tool));
		}
		return toolDTOList;
	}

}
