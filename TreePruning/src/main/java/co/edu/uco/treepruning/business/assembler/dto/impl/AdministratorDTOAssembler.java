package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.AdministratorDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.AdministratorDTO;

public class AdministratorDTOAssembler implements DTOAssembler<AdministratorDTO, AdministratorDomain> {
	
	private static final DTOAssembler<AdministratorDTO, AdministratorDomain> INSTANCE = new AdministratorDTOAssembler();
	
	private AdministratorDTOAssembler() {
		
	}
	
	public static DTOAssembler<AdministratorDTO, AdministratorDomain> getAdministratorDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public AdministratorDTO toDTO(final AdministratorDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new AdministratorDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new AdministratorDTO(domainTmp.getId(), domainTmp.getUsername(), domainTmp.getEmail(), domainTmp.isEmailConfirmed(), domainTmp.getMobilePhone(), domainTmp.isMobilePhoneConfirmed());
	}

	@Override
	public AdministratorDomain toDomain(final AdministratorDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new AdministratorDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new AdministratorDomain(dtoTmp.getId(), dtoTmp.getUsername(), dtoTmp.getEmail(), dtoTmp.isEmailConfirmed(), dtoTmp.getMobilePhone(), dtoTmp.isMobilePhoneConfirmed());
	}

	@Override
	public List<AdministratorDTO> toDTO(final List<AdministratorDomain> domainList) {
		var administratorDTOList = new ArrayList<AdministratorDTO>();
		
		for (var administrator : domainList) {
			administratorDTOList.add(toDTO(administrator));
		}
		
		return administratorDTOList;
	}

}
