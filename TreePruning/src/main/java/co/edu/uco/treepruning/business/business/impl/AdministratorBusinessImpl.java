package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.AdministratorBusiness;
import co.edu.uco.treepruning.business.domain.AdministratorDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class AdministratorBusinessImpl implements AdministratorBusiness {
	
	private DAOFactory daoFactory;
	
	public AdministratorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public List<AdministratorDomain> findAllAdministrators() {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public List<AdministratorDomain> findAdministratorsByFilter(AdministratorDomain administratorFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdministratorDomain findSpecificAdministrator(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
