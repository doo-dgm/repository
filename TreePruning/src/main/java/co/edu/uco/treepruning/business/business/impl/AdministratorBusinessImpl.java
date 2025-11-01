package co.edu.uco.treepruning.business.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.AdministratorBusiness;
import co.edu.uco.treepruning.business.domain.AdministratorDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

import static co.edu.uco.treepruning.business.assembler.entity.impl.AdministratorEntityAssembler.getAdministratorEntityAssembler;

public class AdministratorBusinessImpl implements AdministratorBusiness {
	
	private DAOFactory daoFactory;
	
	public AdministratorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public List<AdministratorDomain> findAllAdministrators() {
		var administratorEntityList = daoFactory.getAdministratorDAO().findAll();
		var administratorDomainList = new ArrayList<AdministratorDomain>();
		
		for (var administratorEntity : administratorEntityList) {
			administratorDomainList.add(getAdministratorEntityAssembler().toDomain(administratorEntity));
		}
		
		return administratorDomainList;
		
	}

	@Override
	public List<AdministratorDomain> findAdministratorsByFilter(final AdministratorDomain administratorFilters) {
		var administratorEntity = getAdministratorEntityAssembler().toEntity(administratorFilters);
		var administratorEntityList = daoFactory.getAdministratorDAO().findByFilter(administratorEntity);
		var administratorDomainList = new ArrayList<AdministratorDomain>();
		
		for (var administrator : administratorEntityList) {
			administratorDomainList.add(getAdministratorEntityAssembler().toDomain(administrator));
		}
		return administratorDomainList;
	}

	@Override
	public AdministratorDomain findSpecificAdministrator(final UUID id) {
		var administratorEntity = daoFactory.getAdministratorDAO().findById(id);
		return getAdministratorEntityAssembler().toDomain(administratorEntity);
	}

}
