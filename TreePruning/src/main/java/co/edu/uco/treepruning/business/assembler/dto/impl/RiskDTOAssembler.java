package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.RiskDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
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
		var domainTmp = ObjectHelper.getDefault(domain, new RiskDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new RiskDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public RiskDomain toDomain(RiskDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new RiskDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new RiskDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<RiskDTO> toDTO(List<RiskDomain> domainList) {
		var riskDTOList = new ArrayList<RiskDTO>();
		
		for (var risk : domainList) {
			riskDTOList.add(toDTO(risk));
		}
		
		return riskDTOList;
	}

}
