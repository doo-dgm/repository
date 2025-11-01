package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.PQRBusiness;
import co.edu.uco.treepruning.business.domain.PQRDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class PQRBusinessImpl implements PQRBusiness{
	
	private DAOFactory daoFactory;
	
	public PQRBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<PQRDomain> findAllPQRs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PQRDomain> findPQRsByFilter(PQRDomain pqrFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PQRDomain findSpecificPQR(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
