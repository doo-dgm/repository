package co.edu.uco.treepruning.business.assembler.dto.impl;

import static co.edu.uco.treepruning.business.assembler.dto.impl.DocumentDTOAssembler.getDocumentDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.PersonDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
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
		var domainTmp = ObjectHelper.getDefault(domain, new PersonDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var documentTypeDtoTmp = getDocumentDTOAssembler().toDTO(domainTmp.getDocument());

		return new PersonDTO(domainTmp.getId(), domainTmp.getFirstName(), domainTmp.getSecondName(),
				domainTmp.getLastName(), domainTmp.getSecondLastName(), documentTypeDtoTmp, 
				domainTmp.getDocumentNumber(), domainTmp.getBirthDate(), domainTmp.getAddress(), 
				domainTmp.getEmail(), domainTmp.isEmailConfirmed(), domainTmp.getMobilePhone(), 
				domainTmp.isMobilePhoneConfirmed(), domainTmp.getAge());
	}

	@Override
	public PersonDomain toDomain(PersonDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new PersonDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var documentTypeDomainTmp = getDocumentDTOAssembler().toDomain(dtoTmp.getDocument());
		
		return new PersonDomain(dtoTmp.getId(), dtoTmp.getFirstName(), dtoTmp.getSecondName(),
				dtoTmp.getFirstLastName(), dtoTmp.getSecondLastName(), documentTypeDomainTmp, 
				dtoTmp.getDocumentNumber(), dtoTmp.getBirthDate(), dtoTmp.getAddress(), 
				dtoTmp.getEmail(), dtoTmp.isEmailConfirmed(), dtoTmp.getPhone(), 
				dtoTmp.isPhoneConfirmed(), dtoTmp.getAge());
	}

	@Override
	public List<PersonDTO> toDTO(List<PersonDomain> domainList) {
		var personDTOList = new ArrayList<PersonDTO>();
		
		for (var person : domainList) {
			personDTOList.add(toDTO(person));
		}
		
		return personDTOList;
	}

}
