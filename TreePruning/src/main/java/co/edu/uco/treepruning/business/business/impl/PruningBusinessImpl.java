package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.treepruning.business.assembler.entity.impl.PruningEntityAssembler.getPruningEntityAssembler;

import co.edu.uco.treepruning.business.business.PruningBusiness;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class PruningBusinessImpl implements PruningBusiness {
	
	private DAOFactory daoFactory;
	
	public PruningBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void schedulePruning(final PruningDomain pruningDomain) {
		// TODO Auto-generated method stub
		
		var id = UUIDHelper.getUUIDHelper().generateNewUUID();
		var pruningEntity = getPruningEntityAssembler().toEntity(pruningDomain);
		pruningEntity.setId(id);
		
		daoFactory.getPruningDAO().create(pruningEntity);
	}

	@Override
	public void cancelPruning(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reschedulePruning(final UUID id, PruningDomain pruningDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completePruning(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PruningDomain> findAllPrunings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PruningDomain> findPruningsByFilter(final PruningDomain pruningFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruningDomain findSpecificPruning(final UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
