package co.edu.uco.treepruning.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.assembler.dto.impl.PersonDTOAssembler;
import co.edu.uco.treepruning.business.business.impl.PersonBusinessImpl;
import co.edu.uco.treepruning.business.facade.PersonFacade;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.dto.PersonDTO;

public class PersonFacadeImpl implements PersonFacade{
	
	private DAOFactory daoFactory;
	
	public PersonFacadeImpl() {
		this.daoFactory = DAOFactory.getFactory();
	}

	@Override
	public void registerNewPersonInformation(PersonDTO personDTO) {
		var daoFactory = DAOFactory.getFactory();
		var business = new PersonBusinessImpl(daoFactory);
		
		try {
			
			daoFactory.initTransaction();
			
			var domain = PersonDTOAssembler.getPersonDTOAssembler().toDomain(personDTO);
			business.registerNewPersonInformation(domain);
			
			daoFactory.commitTransaction();
		} catch(final TreePruningException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch(final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = "Se ha presentado un problema inesperado al registrar la información del nuevo usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema.";
			var technicalMessage = "Se ha presentado un problema inesperado al registrar la información del nuevo usuario. Por favor revise el log de errores para mayor detalle del problema.";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
			
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void dropUserInformation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInformation(UUID id, PersonDTO userDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonDTO> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDTO> findUsersByFilter(PersonDTO userFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDTO findSpecificUser(UUID id) {
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
	public void sendMobileNumberConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
