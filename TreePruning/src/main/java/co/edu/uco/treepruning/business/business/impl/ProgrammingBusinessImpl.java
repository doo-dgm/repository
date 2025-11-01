package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.ProgrammingBusiness;
import co.edu.uco.treepruning.business.domain.ProgrammingDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class ProgrammingBusinessImpl implements ProgrammingBusiness{
	
	private DAOFactory daoFactory;
	
	public ProgrammingBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<ProgrammingDomain> findAllProgrammings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProgrammingDomain> findProgrammingsByFilter(ProgrammingDomain programmingFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProgrammingDomain findSpecificProgramming(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
