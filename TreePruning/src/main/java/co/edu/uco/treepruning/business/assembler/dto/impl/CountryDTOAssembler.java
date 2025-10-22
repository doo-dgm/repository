package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.CountryDomain;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryDomain toDomain(CountryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryDTO> toDTO(List<CountryDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
