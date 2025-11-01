package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.QuadrilleBusiness;
import co.edu.uco.treepruning.business.domain.QuadrilleDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class QuadrilleBusinessImpl implements QuadrilleBusiness{
	
	private DAOFactory daoFactory;
	
	public QuadrilleBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<QuadrilleDomain> findAllQuadrilles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuadrilleDomain> findQuadrillesByCriteria(QuadrilleDomain criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuadrilleDomain getQuadrilleById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
