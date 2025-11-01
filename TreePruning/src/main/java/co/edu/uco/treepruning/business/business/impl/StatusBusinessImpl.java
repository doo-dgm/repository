package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.StatusBusiness;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class StatusBusinessImpl implements StatusBusiness{
	
	private DAOFactory daoFactory;
	
	public StatusBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<StatusDomain> listAllStatuses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatusDomain> listStatusesByCriteria(StatusDomain criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDomain getStatusById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
