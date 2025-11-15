package co.edu.uco.treepruning.business.business.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.treepruning.business.assembler.entity.impl.PruningEntityAssembler.getPruningEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.StatusEntityAssembler.getStatusEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.QuadrilleEntityAssembler.getQuadrilleEntityAssembler;

import co.edu.uco.treepruning.business.business.PruningBusiness;
import co.edu.uco.treepruning.business.business.validator.generics.ValidateDateRange;
import co.edu.uco.treepruning.business.business.validator.pqr.ValidatePQRExistsById;
import co.edu.uco.treepruning.business.business.validator.pqr.ValidatePQRIsNotClosed;
import co.edu.uco.treepruning.business.business.validator.pruning.ValidateDataCorrectivePruningConsistencyForRegisterNewInformation;
import co.edu.uco.treepruning.business.business.validator.status.ValidateStatusExistsById;
import co.edu.uco.treepruning.business.business.validator.status.ValidateStatusIsNotClosed;
import co.edu.uco.treepruning.business.business.validator.tree.ValidateTreeExistsById;
import co.edu.uco.treepruning.business.business.validator.tree.ValidateTreeHasPendingPruningTheSameDay;
import co.edu.uco.treepruning.business.business.validator.type.ValidateTypeExistsById;
import co.edu.uco.treepruning.business.business.validator.type.ValidateTypeIsCorrective;
import co.edu.uco.treepruning.business.business.validator.type.ValidateTypeIsPreventive;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.entity.PruningEntity; 

public class PruningBusinessImpl implements PruningBusiness {
	
	private DAOFactory daoFactory;
	
	public PruningBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void schedulePreventivePruning(final PruningDomain pruningDomain) {
		try {
			ValidateDataCorrectivePruningConsistencyForRegisterNewInformation.executeValidation(pruningDomain, daoFactory);
			ValidateTreeExistsById.executeValidation(pruningDomain.getTree().getId(), daoFactory);
			ValidateStatusExistsById.executeValidation(pruningDomain.getStatus().getId(), daoFactory);
			ValidateStatusIsNotClosed.executeValidation(pruningDomain.getStatus().getId(), daoFactory);
			ValidateTypeExistsById.executeValidation(pruningDomain.getType().getId(), daoFactory);
			ValidateTypeIsPreventive.executeValidation(pruningDomain.getType().getId(), daoFactory);
			ValidateTreeHasPendingPruningTheSameDay.executeValidation(pruningDomain.getTree().getId(), pruningDomain.getPlannedDate(), daoFactory);
			ValidateDateRange.executeValidation(pruningDomain.getPlannedDate(), "fecha planificada");
			
			
			var date = pruningDomain.getPlannedDate();
			var tree = daoFactory.getTreeDAO().findById(pruningDomain.getTree().getId());
			var programing = daoFactory.getProgrammingDAO().findById(tree.getProgramming().getId());
			var frequencyMonths = programing.getFrequencyMonths();
			
			var pruningFilter = new PruningDomain();
			pruningFilter.setTree(pruningDomain.getTree());
			
			var pruningsInActualPeriod = daoFactory.getPruningDAO().findByFilter(getPruningEntityAssembler().toEntity(pruningFilter));
			pruningFilter.setStatus(pruningDomain.getStatus());
			pruningFilter.setType(pruningDomain.getType());
			pruningFilter.setTree(pruningDomain.getTree());
			pruningFilter.setObservations(pruningDomain.getObservations());
			pruningFilter.setPlannedDate(pruningDomain.getPlannedDate());
			
			if (!pruningsInActualPeriod.isEmpty()) {
				pruningFilter.setPlannedDate(pruningsInActualPeriod.getLast().getPlannedDate());
				date = pruningsInActualPeriod.getLast().getPlannedDate().plusMonths(frequencyMonths);
			}
			
			var pruningEntity = new PruningEntity();
			pruningEntity = getPruningEntityAssembler().toEntity(pruningFilter);

			while (DateHelper.getDateHelper().isLocalDateBefore(date)) {			
				pruningEntity.setPlannedDate(date);
				pruningEntity.setId(generateId());
				
				daoFactory.getPruningDAO().create(pruningEntity);
				
				date = date.plusMonths(frequencyMonths);
				
			}
			
		} catch (final TreePruningException exception) {
			var userMessage = exception.getUserMessage();
			var technicalMessage = exception.getTechnicalMessage();
			exception.printStackTrace();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void scheduleCorrectivePruning(final PruningDomain pruningDomain) {
		
		try {
			ValidateDataCorrectivePruningConsistencyForRegisterNewInformation.executeValidation(pruningDomain, daoFactory);
			ValidateTreeExistsById.executeValidation(pruningDomain.getTree().getId(), daoFactory);
			ValidateStatusExistsById.executeValidation(pruningDomain.getStatus().getId(), daoFactory);
			ValidateStatusIsNotClosed.executeValidation(pruningDomain.getStatus().getId(), daoFactory);
			ValidateTypeExistsById.executeValidation(pruningDomain.getType().getId(), daoFactory);
			ValidateTypeIsCorrective.executeValidation(pruningDomain.getType().getId(), daoFactory);
			ValidatePQRExistsById.executeValidation(pruningDomain.getPqr().getId(), daoFactory);
			ValidatePQRIsNotClosed.executeValidation(pruningDomain.getPqr().getId(), daoFactory);
			ValidateTreeHasPendingPruningTheSameDay.executeValidation(pruningDomain.getTree().getId(), pruningDomain.getPlannedDate(), daoFactory);
			ValidateDateRange.executeValidation(pruningDomain.getPlannedDate(), "fecha planificada");
			
			var pruningDomainValues = new PruningDomain();
			
			pruningDomainValues.setTree(pruningDomain.getTree());
			pruningDomainValues.setPlannedDate(pruningDomain.getPlannedDate());
			pruningDomainValues.setStatus(pruningDomain.getStatus());
			pruningDomainValues.setType(pruningDomain.getType());
			pruningDomainValues.setPqr(pruningDomain.getPqr());
			pruningDomainValues.setObservations(pruningDomain.getObservations());
			
			var pruningEntity = getPruningEntityAssembler().toEntity(pruningDomainValues);
			
			pruningEntity.setId(generateId());
			
			daoFactory.getPruningDAO().create(pruningEntity);
		} catch (final TreePruningException exception) {
			var userMessage = exception.getUserMessage();
			var technicalMessage = exception.getTechnicalMessage();
			exception.printStackTrace();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
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
	public void cancelPruning(final PruningDomain pruningDomain) {
		try {
			
			var pruningEntity = daoFactory.getPruningDAO().findById(pruningDomain.getId());
			
			pruningEntity.setExecutedDate(pruningDomain.getExecutedDate());
			pruningEntity.setStatus(getStatusEntityAssembler().toEntity(pruningDomain.getStatus()));
			pruningEntity.setQuadrille(getQuadrilleEntityAssembler().toEntity(pruningDomain.getQuadrille()));
			pruningEntity.setObservations(pruningDomain.getObservations());
			
			
			daoFactory.getPruningDAO().update(pruningEntity);
		} catch (final TreePruningException exception) {
			var userMessage = exception.getUserMessage();
			var technicalMessage = exception.getTechnicalMessage();
			exception.printStackTrace();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void reschedulePruning(final UUID id, final PruningDomain pruningDomain) {
		var existingEntity = daoFactory.getPruningDAO().findById(id);
		daoFactory.getPruningDAO().update(existingEntity);
		
	}

	@Override
	public void completePruning(final PruningDomain pruningDomain) {
		try {
			var pruningEntity = daoFactory.getPruningDAO().findById(pruningDomain.getId());
			System.out.println(pruningEntity.getId());
			
			pruningEntity.setExecutedDate(pruningDomain.getExecutedDate());
			pruningEntity.setStatus(getStatusEntityAssembler().toEntity(pruningDomain.getStatus()));
			pruningEntity.setQuadrille(getQuadrilleEntityAssembler().toEntity(pruningDomain.getQuadrille()));
			pruningEntity.setObservations(pruningDomain.getObservations());
				
			daoFactory.getPruningDAO().update(pruningEntity);
		} catch (final TreePruningException exception) {
			var userMessage = exception.getUserMessage();
			var technicalMessage = exception.getTechnicalMessage();
			exception.printStackTrace();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
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

}
