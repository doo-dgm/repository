package co.edu.uco.treepruning.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.assembler.dto.impl.TypeDTOAssembler;
import co.edu.uco.treepruning.business.business.impl.TypeBusinessImpl;
import co.edu.uco.treepruning.business.domain.TypeDomain;
import co.edu.uco.treepruning.business.facade.TypeFacade;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.dto.TypeDTO;

public class TypeFacadeImpl implements TypeFacade{

	@Override
	public List<TypeDTO> listAllTypes() {
		var daoFactory = DAOFactory.getFactory();
		var business = new TypeBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			List<TypeDomain> domainList = business.listAllTypes();
			return TypeDTOAssembler.getTypeDTOAssembler().toDTO(domainList);
		} catch (TreePruningException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<TypeDTO> listTypesByCriteria(final TypeDTO typeCriteria) {
		var daoFactory = DAOFactory.getFactory();
		var business = new TypeBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			var filterDomain = TypeDTOAssembler.getTypeDTOAssembler().toDomain(typeCriteria);
			List<TypeDomain> domainList = business.listTypesByCriteria(filterDomain);
			return TypeDTOAssembler.getTypeDTOAssembler().toDTO(domainList);
		} catch (final TreePruningException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public TypeDTO getTypeById(final UUID id) {
		var daoFactory = DAOFactory.getFactory();
		var business = new TypeBusinessImpl(daoFactory);
		try {
			daoFactory.initTransaction();
			TypeDomain domain = business.getTypeById(id);
			return TypeDTOAssembler.getTypeDTOAssembler().toDTO(domain);
		} catch (final TreePruningException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

}
