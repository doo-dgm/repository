package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.ManagerDTOAssembler.getManagerDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.QuadrilleDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.QuadrilleDTO;

public class QuadrilleDTOAssembler implements DTOAssembler<QuadrilleDTO, QuadrilleDomain>{
	
	private static final DTOAssembler<QuadrilleDTO, QuadrilleDomain> INSTANCE = new QuadrilleDTOAssembler();
	
	private QuadrilleDTOAssembler() {
		
	}
	
	public static DTOAssembler<QuadrilleDTO, QuadrilleDomain> getQuadrilleDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public QuadrilleDTO toDTO(QuadrilleDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new QuadrilleDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var managerDtoTmp = getManagerDTOAssembler().toDTO(domainTmp.getManager());
		
		return new QuadrilleDTO(domainTmp.getId(), domainTmp.getName(), managerDtoTmp);
	}

	@Override
	public QuadrilleDomain toDomain(QuadrilleDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new QuadrilleDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var managerDomainTmp = getManagerDTOAssembler().toDomain(dtoTmp.getManager());
		
		return new QuadrilleDomain(dtoTmp.getId(), dtoTmp.getName(), managerDomainTmp);
	}

	@Override
	public List<QuadrilleDTO> toDTO(List<QuadrilleDomain> domainList) {
		var quadrilleDTOList = new ArrayList<QuadrilleDTO>();
		
		for (var quadrille : domainList) {
			quadrilleDTOList.add(toDTO(quadrille));
		}
		
		return quadrilleDTOList;
	}

}
