package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.PQRDTOAssembler.getPQRDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.ProgrammingDTOAssembler.getProgrammingDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.QuadrilleDTOAssembler.getQuadrilleDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.StatusDTOAssembler.getStatusDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.TreeDTOAssembler.getTreeDTOAssembler;
import static co.edu.uco.treepruning.business.assembler.dto.impl.TypeDTOAssembler.getTypeDTOAssembler;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.PruningDTO;

public class PruningDTOAssembler implements DTOAssembler<PruningDTO, PruningDomain> {

	private static final DTOAssembler<PruningDTO, PruningDomain> INSTANCE = new PruningDTOAssembler();
	
	private PruningDTOAssembler() {
		
	}
	
	public static DTOAssembler<PruningDTO, PruningDomain> getPruningDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public PruningDTO toDTO(PruningDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new PruningDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var statusDtoTmp = getStatusDTOAssembler().toDTO(domainTmp.getStatus());
		var treeDtoTmp = getTreeDTOAssembler().toDTO(domainTmp.getTree());
		var quadrilleDtoTmp = getQuadrilleDTOAssembler().toDTO(domainTmp.getQuadrille());
		var typeDtoTmp = getTypeDTOAssembler().toDTO(domainTmp.getType());
		var pqrDtoTmp = getPQRDTOAssembler().toDTO(domainTmp.getPqr());
		var ProgrammingDtoTmp = getProgrammingDTOAssembler().toDTO(domainTmp.getProgramming());	
		
		return new PruningDTO(
				domainTmp.getId(),
				statusDtoTmp,
				domainTmp.getPlannedDate(),
				domainTmp.getExecutedDate(),
				treeDtoTmp,
				quadrilleDtoTmp,
				typeDtoTmp,
				pqrDtoTmp,
				ProgrammingDtoTmp,
				domainTmp.getPhotographicRecordPath(),
				domainTmp.getObservations()
				
				);
	}

	@Override
	public PruningDomain toDomain(PruningDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new PruningDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var statusDomainTmp = getStatusDTOAssembler().toDomain(dtoTmp.getStatus());
		var treeDomainTmp = getTreeDTOAssembler().toDomain(dtoTmp.getTree());
		var quadrilleDomainTmp = getQuadrilleDTOAssembler().toDomain(dtoTmp.getQuadrille());
		var typeDomainTmp = getTypeDTOAssembler().toDomain(dtoTmp.getType());
		var pqrDomainTmp = getPQRDTOAssembler().toDomain(dtoTmp.getPqr());
		var programmingDomainTmp = getProgrammingDTOAssembler().toDomain(dtoTmp.getProgramming());
		
		return new PruningDomain(
				dtoTmp.getId(),
				statusDomainTmp,
				dtoTmp.getPlannedDate(),
				dtoTmp.getExecutedDate(),
				treeDomainTmp,
				quadrilleDomainTmp,
				typeDomainTmp,
				pqrDomainTmp,
				programmingDomainTmp,
				dtoTmp.getPhotographicRecordPath(),
				dtoTmp.getObservations()
				);
		}
	

	@Override
	public List<PruningDTO> toDTO(List<PruningDomain> domainList) {
		var pruningDTOList = new java.util.ArrayList<PruningDTO>();
		
		for (var pruning : domainList) {
			pruningDTOList.add(toDTO(pruning));
		}
		
		return pruningDTOList;
	}
	
	

}
