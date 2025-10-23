package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.MunicipalityDTOAssembler.getMunicipalityDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.SectorDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.SectorDTO;

public class SectorDTOAssembler implements DTOAssembler<SectorDTO, SectorDomain>{
	
	private static final DTOAssembler<SectorDTO, SectorDomain> INSTANCE = new SectorDTOAssembler();
	
	private SectorDTOAssembler() {
		
	}
	
	public static DTOAssembler<SectorDTO, SectorDomain> getSectorDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public SectorDTO toDTO(SectorDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new SectorDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var municipalityDtoTmp = getMunicipalityDTOAssembler().toDTO(domainTmp.getMunicipality());
		return new SectorDTO(domainTmp.getId(), domainTmp.getName(), municipalityDtoTmp);
	}

	@Override
	public SectorDomain toDomain(SectorDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new SectorDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var municipalityDomainTmp = getMunicipalityDTOAssembler().toDomain(dtoTmp.getMunicipality());
		return new SectorDomain(dtoTmp.getId(), dtoTmp.getName(), municipalityDomainTmp);
	}

	@Override
	public List<SectorDTO> toDTO(List<SectorDomain> domainList) {
		var sectorDTOList = new ArrayList<SectorDTO>();
		
		for (var sector : domainList ) {
			sectorDTOList.add(toDTO(sector));
		}
		return sectorDTOList;
	}

}
