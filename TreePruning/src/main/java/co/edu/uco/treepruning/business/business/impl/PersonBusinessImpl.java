package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.treepruning.business.assembler.entity.impl.PersonEntityAssembler.getPersonEntityAssembler;

import co.edu.uco.treepruning.business.business.PersonBusiness;
import co.edu.uco.treepruning.business.domain.PersonDomain;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public final class PersonBusinessImpl implements PersonBusiness {
	
	private DAOFactory daoFactory;
	
	public PersonBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void registerNewPersonInformation(final PersonDomain personDomain) {
		// TODO Auto-generated method stub
		
		var id = UUIDHelper.getUUIDHelper().generateNewUUID();
		var personEntity = getPersonEntityAssembler().toEntity(personDomain);
		personEntity.setId(id);
		
		daoFactory.getPersonDAO().create(personEntity);
	}

	@Override
	public void dropPersonInformation(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePersonInformation(final UUID id, PersonDomain personDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonDomain> findAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDomain> findPersonsByFilter(final PersonDomain personFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDomain findSpecificPerson(final UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmMobileNumber(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmEmail(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMobileNumberConfirmation(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailConfirmation(final UUID id) {
		// TODO Auto-generated method stub
		
	}
	


}
