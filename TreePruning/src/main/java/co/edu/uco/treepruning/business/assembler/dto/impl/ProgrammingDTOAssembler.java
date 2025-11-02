package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.ProgrammingDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.ProgrammingDTO;

public class ProgrammingDTOAssembler implements DTOAssembler<ProgrammingDTO, ProgrammingDomain> {

	private static final DTOAssembler<ProgrammingDTO, ProgrammingDomain> INSTANCE = new ProgrammingDTOAssembler();
	
	private ProgrammingDTOAssembler() {
		
	}
	
	public static DTOAssembler<ProgrammingDTO, ProgrammingDomain> getProgrammingDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public ProgrammingDTO toDTO(ProgrammingDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new ProgrammingDomain(UUIDHelper.getUUIDHelper().getDefault()));
		
		return new ProgrammingDTO(domainTmp.getId(), domainTmp.getInitialDate(), domainTmp.getFrequencyMonths(), domainTmp.getAmount());
	}

	@Override
	public ProgrammingDomain toDomain(ProgrammingDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new ProgrammingDTO(UUIDHelper.getUUIDHelper().getDefault()));
		
		return new ProgrammingDomain(dtoTmp.getId(), dtoTmp.getInitialDate(), dtoTmp.getFrequencyMonths(), dtoTmp.getAmount());
	}

	@Override
	public List<ProgrammingDTO> toDTO(List<ProgrammingDomain> domainList) {
		var programmingDTOList = new ArrayList<ProgrammingDTO>();
		
		for (var programming : domainList) {
			programmingDTOList.add(toDTO(programming));
		}
		
		return programmingDTOList;
	}

}
