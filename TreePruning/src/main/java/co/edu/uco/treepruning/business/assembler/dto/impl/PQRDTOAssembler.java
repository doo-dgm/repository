package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.StatusDTOAssembler.getStatusDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.RiskDTOAssembler.getRiskDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.SectorDTOAssembler.getSectorDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.PersonDTOAssembler.getPersonDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.PQRDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.PQRDTO;

public class PQRDTOAssembler implements DTOAssembler<PQRDTO, PQRDomain> {

	private static final PQRDTOAssembler INSTANCE = new PQRDTOAssembler();
	
	private PQRDTOAssembler() {
		
	}
	
	public static PQRDTOAssembler getPQRDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public PQRDTO toDTO(PQRDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new PQRDomain(UUIDHelper.getUUIDHelper().getDefault()));
		
		var statusDtoTmp = getStatusDTOAssembler().toDTO(domainTmp.getStatus());
		var riskDtoTmp = getRiskDTOAssembler().toDTO(domainTmp.getRisk());
		var sectorDtoTmp = getSectorDTOAssembler().toDTO(domainTmp.getSector());
		var personDtoTmp = getPersonDTOAssembler().toDTO(domainTmp.getPerson());
		
		return new PQRDTO(
				domainTmp.getId(),
				domainTmp.getDate(),
				statusDtoTmp,
				riskDtoTmp,
				sectorDtoTmp,
				personDtoTmp,
				domainTmp.getPhotographicRecordPath()
				);
	}

	@Override
	public PQRDomain toDomain(PQRDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new PQRDTO(UUIDHelper.getUUIDHelper().getDefault()));
		
		var statusDomainTmp = getStatusDTOAssembler().toDomain(dtoTmp.getStatus());
		var riskDomainTmp = getRiskDTOAssembler().toDomain(dtoTmp.getRisk());
		var sectorDomainTmp = getSectorDTOAssembler().toDomain(dtoTmp.getSector());
		var personDomainTmp = getPersonDTOAssembler().toDomain(dtoTmp.getPerson());
		
		
		return new PQRDomain(
				dtoTmp.getId(),
				dtoTmp.getDate(),
				statusDomainTmp,
				riskDomainTmp,
				sectorDomainTmp,
				personDomainTmp,
				dtoTmp.getPhotographicRecordPath()
				);
	}

	@Override
	public List<PQRDTO> toDTO(List<PQRDomain> domainList) {
		var pqrDTOList = new ArrayList<PQRDTO>();
		
		for (var pqr : domainList) {
			pqrDTOList.add(toDTO(pqr));
		}
		
		return pqrDTOList;
	}

}
