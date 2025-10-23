package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.PersonDTOAssembler.getPersonDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.ManagerDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.ManagerDTO;

public class ManagerDTOAssembler implements DTOAssembler<ManagerDTO, ManagerDomain> {
	
	private static final DTOAssembler<ManagerDTO, ManagerDomain> INSTANCE = new ManagerDTOAssembler();
	
	private ManagerDTOAssembler() {

	}

	public static DTOAssembler<ManagerDTO, ManagerDomain> getManagerDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public ManagerDTO toDTO(ManagerDomain domain) {
		var domaintTmp = ObjectHelper.getDefault(domain, new ManagerDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var personDtoTmp = getPersonDTOAssembler().toDTO(domaintTmp.getPerson());
		
		return new ManagerDTO(domaintTmp.getId(), personDtoTmp);
	}

	@Override
	public ManagerDomain toDomain(ManagerDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new ManagerDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var personDomainTmp = getPersonDTOAssembler().toDomain(dtoTmp.getPerson());
		
		return new ManagerDomain(dtoTmp.getId(), personDomainTmp);
	}

	@Override
	public List<ManagerDTO> toDTO(List<ManagerDomain> domainList) {
		var managerDTOList = new ArrayList<ManagerDTO>();
		
		for (var manager : domainList) {
			managerDTOList.add(toDTO(manager));
		}
		
		return managerDTOList;
	}

}
