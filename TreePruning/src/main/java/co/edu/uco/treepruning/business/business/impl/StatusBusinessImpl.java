package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.StatusBusiness;
import co.edu.uco.treepruning.business.business.validator.generics.ValidateIdExists;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

import static co.edu.uco.treepruning.business.assembler.entity.impl.StatusEntityAssembler.getStatusEntityAssembler;

public class StatusBusinessImpl implements StatusBusiness{
	
	private DAOFactory daoFactory;
	
	public StatusBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<StatusDomain> listAllStatuses() {
		return getStatusEntityAssembler().toDomain(daoFactory.getStatusDAO().findAll());
	}

	@Override
	public List<StatusDomain> listStatusesByCriteria(final StatusDomain statusCriteria) {
		var statusEntity = getStatusEntityAssembler().toEntity(statusCriteria);
		return getStatusEntityAssembler().toDomain(daoFactory.getStatusDAO().findByFilter(statusEntity));
	}

	@Override
	public StatusDomain getStatusById(final UUID id) {
		try {
			ValidateIdExists.executeValidation(id, "estado");
			
			var statusEntity = daoFactory.getStatusDAO().findById(id);
			return getStatusEntityAssembler().toDomain(statusEntity);
		} catch (final TreePruningException exception) {
			var userMessage = exception.getUserMessage();
			var technicalMessage = exception.getTechnicalMessage();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

}
