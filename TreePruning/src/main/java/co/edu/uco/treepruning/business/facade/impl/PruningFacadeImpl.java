package co.edu.uco.treepruning.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.assembler.dto.impl.PruningDTOAssembler;
import co.edu.uco.treepruning.business.business.impl.PruningBusinessImpl;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.business.facade.PruningFacade;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.dto.PruningDTO;

public final class PruningFacadeImpl implements PruningFacade {
	
	private DAOFactory daoFactory;
	
	public PruningFacadeImpl() {
		this.daoFactory = DAOFactory.getFactory();
	}

	@Override
	public void schedulePruning(PruningDTO pruningDTO) {
		var daoFactory = DAOFactory.getFactory();
		var business = new PruningBusinessImpl(daoFactory);
		
		try {
			
			daoFactory.initTransaction();
			
			var domain = PruningDTOAssembler.getPruningDTOAssembler().toDomain(pruningDTO);
			business.schedulePruning(domain);
			
			daoFactory.commitTransaction();
		} catch(final TreePruningException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch(final Exception exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void cancelPruning(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reschedulePruning(UUID id, PruningDTO pruningDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completePruning(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PruningDTO> findAllPrunings() {
		var daoFactory = DAOFactory.getFactory();
		var business = new PruningBusinessImpl(daoFactory);
		
		try {
			var domainList = business.findAllPrunings();
			var dtoList = PruningDTOAssembler.getPruningDTOAssembler().toDTO(domainList);
			
			return dtoList;
			
		} catch(final TreePruningException exception) {
			throw exception;
		} catch(final Exception exception) {
			throw exception;
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<PruningDTO> findPruningsByFilter(PruningDTO pruningFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruningDTO findSpecificPruning(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}



}
