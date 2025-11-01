package co.edu.uco.treepruning.business.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.ProgrammingBusiness;
import co.edu.uco.treepruning.business.domain.ProgrammingDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

import static co.edu.uco.treepruning.business.assembler.entity.impl.ProgrammingEntityAssembler.getProgrammingEntityAssembler;

public class ProgrammingBusinessImpl implements ProgrammingBusiness{
	
	private DAOFactory daoFactory;
	
	public ProgrammingBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<ProgrammingDomain> findAllProgrammings() {
		var programmingEntityList = daoFactory.getProgrammingDAO().findAll();
		var programmingDomainList = new ArrayList<ProgrammingDomain>();
		
		for (var programmingEntity : programmingEntityList) {
			programmingDomainList.add(getProgrammingEntityAssembler().toDomain(programmingEntity));
		}
		return programmingDomainList;
	}

	@Override
	public List<ProgrammingDomain> findProgrammingsByFilter(final ProgrammingDomain programmingFilters) {
		var programmingEntity = getProgrammingEntityAssembler().toEntity(programmingFilters);
		var programmingEntityList = daoFactory.getProgrammingDAO().findByFilter(programmingEntity);
		var programmingDomainList = new ArrayList<ProgrammingDomain>();
		
		for (var programming : programmingEntityList) {
			programmingDomainList.add(getProgrammingEntityAssembler().toDomain(programming));
		}
		return programmingDomainList;
	}

	@Override
	public ProgrammingDomain findSpecificProgramming(final UUID id) {
		var programmingEntity = daoFactory.getProgrammingDAO().findById(id);
		
		return getProgrammingEntityAssembler().toDomain(programmingEntity);
	}

}
