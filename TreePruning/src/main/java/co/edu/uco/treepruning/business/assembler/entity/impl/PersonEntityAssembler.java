package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.PersonDomain;
import co.edu.uco.treepruning.entity.PersonEntity;

public final class PersonEntityAssembler implements EntityAssembler<PersonEntity, PersonDomain> {
	
	private static final EntityAssembler<PersonEntity, PersonDomain> INSTANCE = new PersonEntityAssembler();
	
	private PersonEntityAssembler() {
		
	}
	
	public static EntityAssembler<PersonEntity, PersonDomain> getPersonEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public PersonEntity toEntity(PersonDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDomain toDomain(PersonEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonEntity> toEntity(List<PersonDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
