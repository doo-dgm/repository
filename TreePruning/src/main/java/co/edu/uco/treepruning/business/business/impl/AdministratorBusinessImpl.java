package co.edu.uco.treepruning.business.business.impl;

import java.util.UUID;

import co.edu.uco.treepruning.business.business.AdministratorBusiness;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class AdministratorBusinessImpl implements AdministratorBusiness {
	
	private DAOFactory daoFactory;
	
	public AdministratorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public void findAllAdministrator() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAdministratorByFilter(AdministratorBusiness administratorFilters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findSpecificAdministrator(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
