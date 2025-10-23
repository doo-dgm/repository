package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.PruningDTOAssembler.getPruningDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.ToolDTOAssembler.getToolDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.PruningToolDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.PruningToolDTO;

public class PruningToolDTOAssembler implements DTOAssembler<PruningToolDTO, PruningToolDomain> {

	private static final DTOAssembler<PruningToolDTO, PruningToolDomain> INSTANCE = new PruningToolDTOAssembler();
	
	private PruningToolDTOAssembler() {
		
	}
	
	public static DTOAssembler<PruningToolDTO, PruningToolDomain> getPruningToolDTOAssembler() {
		return INSTANCE;
	}
	
	
	@Override
	public PruningToolDTO toDTO(PruningToolDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new PruningToolDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var pruningDtoTmp = getPruningDTOAssembler().toDTO(domainTmp.getPruning());
		var toolDtoTmp = getToolDTOAssembler().toDTO(domainTmp.getTool());
		
		return new PruningToolDTO(domainTmp.getId(), pruningDtoTmp, toolDtoTmp);
	}

	@Override
	public PruningToolDomain toDomain(PruningToolDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new PruningToolDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var pruningDomainTmp = getPruningDTOAssembler().toDomain(dtoTmp.getPruning());
		var toolDomainTmp = getToolDTOAssembler().toDomain(dtoTmp.getTool());
		
		return new PruningToolDomain(dtoTmp.getId(), pruningDomainTmp, toolDomainTmp);
	}

	@Override
	public List<PruningToolDTO> toDTO(List<PruningToolDomain> domainList) {
		var pruningToolDTOList = new ArrayList<PruningToolDTO>();
		
		for (var pruningTool : domainList) {
			pruningToolDTOList.add(toDTO(pruningTool));
		}
		
		return pruningToolDTOList;
	}

}
