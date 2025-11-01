package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.StatusDTO;

public class StatusDTOAssembler implements DTOAssembler<StatusDTO, StatusDomain> {

	private static final DTOAssembler<StatusDTO, StatusDomain> INSTANCE = new StatusDTOAssembler();
	
	private StatusDTOAssembler() {
		
	}
	
	public static DTOAssembler<StatusDTO, StatusDomain> getStatusDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public StatusDTO toDTO(StatusDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new StatusDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new StatusDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public StatusDomain toDomain(StatusDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new StatusDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new StatusDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<StatusDTO> toDTO(List<StatusDomain> domainList) {
		var statusDTOList = new ArrayList<StatusDTO>();
		
		for (var status : domainList) {
			statusDTOList.add(toDTO(status));
		}
		
		return statusDTOList;
	}

}
