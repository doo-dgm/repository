package co.edu.uco.treepruning.business.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.StatusBusiness;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.entity.StatusEntity;

import static co.edu.uco.treepruning.business.assembler.entity.impl.StatusEntityAssembler.getStatusEntityAssembler;

public class StatusBusinessImpl implements StatusBusiness{
	
	private DAOFactory daoFactory;
	
	public StatusBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<StatusDomain> listAllStatuses() {
		var statusEntityList = daoFactory.getStatusDAO().findAll();
		var statusDomainList = new ArrayList<StatusDomain>();
		
		for (var statusEntity : statusEntityList) {
			statusDomainList.add(getStatusEntityAssembler().toDomain(statusEntity));
		}
		return statusDomainList;
	}

	@Override
	public List<StatusDomain> listStatusesByCriteria(final StatusDomain statusCriteria) {
		
		var statusEntity = getStatusEntityAssembler().toEntity(statusCriteria);
		var statusEntityList = daoFactory.getStatusDAO().findByFilter(statusEntity);
		var statusDomainList = new ArrayList<StatusDomain>();
		
		for (var status : statusEntityList) {
			statusDomainList.add(getStatusEntityAssembler().toDomain(status));
		}
		
		return statusDomainList;
	}

	@Override
	public StatusDomain getStatusById(final UUID id) {
		var statusEntity = daoFactory.getStatusDAO().findById(id);
		
		return getStatusEntityAssembler().toDomain(statusEntity);
	}

}
