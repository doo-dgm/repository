package co.edu.uco.treepruning.business.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.treepruning.business.assembler.entity.impl.PruningEntityAssembler.getPruningEntityAssembler;

import co.edu.uco.treepruning.business.business.PruningBusiness;
import co.edu.uco.treepruning.business.business.validator.pqr.ValidatePQRExistsById;
import co.edu.uco.treepruning.business.business.validator.pqr.ValidatePQRIsNotClosed;
import co.edu.uco.treepruning.business.business.validator.pruning.ValidateDataPruningConsistencyForRegisterNewInformation;
import co.edu.uco.treepruning.business.business.validator.quadrille.ValidateQuadrilleExistsById;
import co.edu.uco.treepruning.business.business.validator.status.ValidateStatusExistsById;
import co.edu.uco.treepruning.business.business.validator.tree.ValidateTreeExistsById;
import co.edu.uco.treepruning.business.business.validator.type.ValidateTypeExistsById;
import co.edu.uco.treepruning.business.business.validator.type.ValidateTypeIsCorrective;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class PruningBusinessImpl implements PruningBusiness {
	
	private DAOFactory daoFactory;
	
	public PruningBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void scheduleCorrectivePruning(final PruningDomain pruningDomain) {
		
		try {
			ValidateDataPruningConsistencyForRegisterNewInformation.executeValidation(pruningDomain);
			
			ValidateStatusExistsById.executeValidation(pruningDomain.getStatus().getId(), daoFactory);
			
			ValidateTreeExistsById.executeValidation(pruningDomain.getTree().getId(), daoFactory);
			
			ValidateQuadrilleExistsById.executeValidation(pruningDomain.getQuadrille().getId(), daoFactory);
			
			ValidateTypeExistsById.executeValidation(pruningDomain.getType().getId(), daoFactory);
			ValidateTypeIsCorrective.executeValidation(pruningDomain.getType().getId(), daoFactory);
			
			ValidatePQRExistsById.executeValidation(pruningDomain.getPqr().getId(), daoFactory);
			ValidatePQRIsNotClosed.executeValidation(pruningDomain.getPqr().getId(), daoFactory);
			
			var pruningEntity = getPruningEntityAssembler().toEntity(pruningDomain);
			
			pruningEntity.setId(generateId());
			
			daoFactory.getPruningDAO().create(pruningEntity);
		} catch (final TreePruningException exception) {
			var userMessage = exception.getUserMessage();
			var technicalMessage = exception.getTechnicalMessage();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			// Manejo de excepciones si es necesario
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}
	
	private UUID generateId() {
		var id = UUIDHelper.getUUIDHelper().generateNewUUID();
		var pruningEntity = daoFactory.getPruningDAO().findById(id);
		while (!UUIDHelper.getUUIDHelper().isDefaultUUID(pruningEntity.getId())) {
			id = UUIDHelper.getUUIDHelper().generateNewUUID();
			pruningEntity = daoFactory.getPruningDAO().findById(id);
		}
		return id;
	}

	@Override
	public void cancelPruning(final UUID id, final StatusDomain status) {
		var pruningDomain = findSpecificPruning(id);
		pruningDomain.setStatus(status);
		daoFactory.getPruningDAO().update(getPruningEntityAssembler().toEntity(pruningDomain));
		
	}

	@Override
	public void reschedulePruning(final UUID id, final PruningDomain pruningDomain) {
		var existingEntity = daoFactory.getPruningDAO().findById(id);
		daoFactory.getPruningDAO().update(existingEntity);
		
	}

	@Override
	public void completePruning(final UUID id, final StatusDomain status) {
		var pruningDomain = findSpecificPruning(id);
		pruningDomain.setStatus(status);
		daoFactory.getPruningDAO().update(getPruningEntityAssembler().toEntity(pruningDomain));
	}

	@Override
	public List<PruningDomain> findAllPrunings() {
		var pruningEntityList = daoFactory.getPruningDAO().findAll();
		var pruningDomainList = new ArrayList<PruningDomain>();
		
		for (var pruningEntity : pruningEntityList) {
			pruningDomainList.add(getPruningEntityAssembler().toDomain(pruningEntity));
		}

		return pruningDomainList;
	}

	@Override
	public List<PruningDomain> findPruningsByFilter(final PruningDomain pruningFilters) {
		var pruningEntity = getPruningEntityAssembler().toEntity(pruningFilters);
		var pruningEntityList = daoFactory.getPruningDAO().findByFilter(pruningEntity);
		var pruningDomainList = new ArrayList<PruningDomain>();
		
		for (var pruning : pruningEntityList) {
			pruningDomainList.add(getPruningEntityAssembler().toDomain(pruning));
		}
		return pruningDomainList;
	}

	@Override
	public PruningDomain findSpecificPruning(final UUID id) {
		var pruningEntity = daoFactory.getPruningDAO().findById(id);
		return getPruningEntityAssembler().toDomain(pruningEntity);
	}

}
