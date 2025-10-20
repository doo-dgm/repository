package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.PersonDomain;
import co.edu.uco.treepruning.dto.PersonDTO;

public final class PersonDTOAssembler implements DTOAssembler<PersonDTO, PersonDomain>{
	
	private static final DTOAssembler<PersonDTO, PersonDomain> INSTANCE = new PersonDTOAssembler();
	
	private PersonDTOAssembler() {
		
	}
	
	public static DTOAssembler<PersonDTO, PersonDomain> getPersonDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public PersonDTO toDTO(PersonDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDomain toDomain(PersonDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDTO> toDTO(List<PersonDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
