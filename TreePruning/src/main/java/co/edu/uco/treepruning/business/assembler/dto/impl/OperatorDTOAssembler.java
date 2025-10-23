package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.PersonDTOAssembler.getPersonDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.QuadrilleDTOAssembler.getQuadrilleDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.OperatorDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.OperatorDTO;

public class OperatorDTOAssembler implements DTOAssembler<OperatorDTO, OperatorDomain> {
	
	private static final DTOAssembler<OperatorDTO, OperatorDomain> INSTANCE = new OperatorDTOAssembler();
	
	private OperatorDTOAssembler() {
		
	}
	
	public static DTOAssembler<OperatorDTO, OperatorDomain> getOperatorAssembler() {
		return INSTANCE;
	}
	
	@Override
	public OperatorDTO toDTO(OperatorDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new OperatorDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var personDtoTmp = getPersonDTOAssembler().toDTO(domainTmp.getPerson());
		var quadrilleDtoTmp = getQuadrilleDTOAssembler().toDTO(domainTmp.getQuadrille());
		
		return new OperatorDTO(domainTmp.getId(), personDtoTmp, quadrilleDtoTmp);
	}

	@Override
	public OperatorDomain toDomain(OperatorDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new OperatorDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var personDomainTmp = getPersonDTOAssembler().toDomain(dtoTmp.getPerson());
		var quadrilleDomainTmp = getQuadrilleDTOAssembler().toDomain(dtoTmp.getQuadrille());
		
		return new OperatorDomain(dtoTmp.getId(), personDomainTmp, quadrilleDomainTmp);
	}

	@Override
	public List<OperatorDTO> toDTO(List<OperatorDomain> domainList) {
		var operatorDTOList = new ArrayList<OperatorDTO>();
		
		for (var operator : domainList) {
			operatorDTOList.add(toDTO(operator));
		}
		
		return operatorDTOList;
	}

}
