package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.PersonDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.PersonEntity;

public class PersonEntityAssembler implements EntityAssembler<PersonEntity, PersonDomain> {

	private static final EntityAssembler<PersonEntity, PersonDomain> INSTANCE = new PersonEntityAssembler();

	private PersonEntityAssembler() {

	}

	public static EntityAssembler<PersonEntity, PersonDomain> getPersonEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public PersonEntity toEntity(final PersonDomain domain) {

		var domainTmp = ObjectHelper.getDefault(domain,
				new PersonDomain(UUIDHelper.getUUIDHelper().getDefault()));

		return new PersonEntity(
				domainTmp.getId(),
				domainTmp.getFirstName(),
				domainTmp.getSecondName(),
				domainTmp.getLastName(),
				domainTmp.getSecondLastName(),
				domainTmp.getDocument(),
				domainTmp.getDocumentNumber(),
				domainTmp.getBirthDate(),
				domainTmp.getAddress(),
				domainTmp.getEmail(),
				domainTmp.isEmailConfirmed(),
				domainTmp.getMobilePhone(),
				domainTmp.isMobilePhoneConfirmed(),
				domainTmp.getAge()
		);
	}

	@Override
	public PersonDomain toDomain(final PersonEntity entity) {

		var entityTmp = ObjectHelper.getDefault(entity,
				new PersonEntity(UUIDHelper.getUUIDHelper().getDefault()));

		return new PersonDomain(
				entityTmp.getId(),
				entityTmp.getNombreUno(),
				entityTmp.getNombreDos(),
				entityTmp.getApellidoUno(),
				entityTmp.getApellidoDos(),
				entityTmp.getDocumento(),
				entityTmp.getNumeroDocumento(),
				entityTmp.getFechaNacimiento(),
				entityTmp.getDireccion(),
				entityTmp.getEmail(),
				entityTmp.isCorreoConfirmado(),
				entityTmp.getTelefono(),
				entityTmp.isTelefonoConfirmado(),
				entityTmp.getEdad()
		);
	}

	@Override
	public List<PersonEntity> toEntity(final List<PersonDomain> domainList) {

		var personEntityList = new ArrayList<PersonEntity>();

		for (var person : ObjectHelper.getDefault(domainList, List.of())) {
			personEntityList.add(toEntity(person));
		}

		return personEntityList;
	}
}

