package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.CountryDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.CountryDTO;

public class CountryDTOAssembler implements DTOAssembler<CountryDTO, CountryDomain> {

	private static final DTOAssembler<CountryDTO, CountryDomain> INSTANCE = new CountryDTOAssembler();
	
	private CountryDTOAssembler() {
		
	}
	
	public static DTOAssembler<CountryDTO, CountryDomain> getCountryDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public CountryDTO toDTO(CountryDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new CountryDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public CountryDomain toDomain(CountryDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CountryDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new CountryDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<CountryDTO> toDTO(List<CountryDomain> domainList) {
		var countryDTOList = new ArrayList<CountryDTO>();
		
		for (var country : domainList) {
			countryDTOList.add(toDTO(country));
		}
		
		return countryDTOList;
	}

}
