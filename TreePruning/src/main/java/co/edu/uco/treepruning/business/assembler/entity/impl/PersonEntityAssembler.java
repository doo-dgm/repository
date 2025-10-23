package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.PersonDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.PersonDTO;
import co.edu.uco.treepruning.entity.PersonEntity;

import static co.edu.uco.treepruning.business.assembler.entity.impl.DocumentEntityAssembler.getDocumentEntityAssembler;

public class PersonEntityAssembler implements EntityAssembler<PersonEntity, PersonDomain> {

	private static final EntityAssembler<PersonEntity, PersonDomain> INSTANCE = new PersonEntityAssembler();

	private PersonEntityAssembler() {

	}

	public static EntityAssembler<PersonEntity, PersonDomain> getPersonEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public PersonEntity toEntity(final PersonDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new PersonDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var documentTypeEntityTmp= getDocumentEntityAssembler().toEntity(domainTmp.getDocument());

		return new PersonEntity(domainTmp.getId(), domainTmp.getFirstName(), domainTmp.getSecondName(),
				domainTmp.getLastName(), domainTmp.getSecondLastName(), documentTypeEntityTmp, 
				domainTmp.getDocumentNumber(), domainTmp.getBirthDate(), domainTmp.getAddress(), 
				domainTmp.getEmail(), domainTmp.isEmailConfirmed(), domainTmp.getMobilePhone(), 
				domainTmp.isMobilePhoneConfirmed(), domainTmp.getAge());
	}

	@Override
	public PersonDomain toDomain(final PersonEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new PersonEntity(UUIDHelper.getUUIDHelper().getDefault()));
		var documentTypeDomainTmp = getDocumentEntityAssembler().toDomain(entityTmp.getDocument());
		
		return new PersonDomain(entityTmp.getId(), entityTmp.getFirstName(), entityTmp.getSecondName(),
				entityTmp.getFirstLastName(), entityTmp.getSecondLastName(), documentTypeDomainTmp, 
				entityTmp.getDocumentNumber(), entityTmp.getBirthDate(), entityTmp.getAddress(), 
				entityTmp.getEmail(), entityTmp.isEmailConfirmed(), entityTmp.getPhone(), 
				entityTmp.isPhoneConfirmed(), entityTmp.getAge());
	}

	@Override
	public List<PersonEntity> toEntity(final List<PersonDomain> domainList) {

		var personEntityList = new ArrayList<PersonEntity>();

		for (var person :domainList) {
			personEntityList.add(toEntity(person));
		}

		return personEntityList;
	}
}

