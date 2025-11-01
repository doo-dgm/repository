package co.edu.uco.treepruning.business.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.PQRBusiness;
import co.edu.uco.treepruning.business.domain.PQRDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

import static co.edu.uco.treepruning.business.assembler.entity.impl.PQREntityAssembler.getPQREntityAssembler;

public class PQRBusinessImpl implements PQRBusiness{
	
	private DAOFactory daoFactory;
	
	public PQRBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<PQRDomain> findAllPQRs() {
		var pqrEntityList = daoFactory.getPQRDAO().findAll();
		var pqrDomainList = new ArrayList<PQRDomain>();
		
		for (var pqrEntity : pqrEntityList) {
			pqrDomainList.add(getPQREntityAssembler().toDomain(pqrEntity));
			
		}
		return pqrDomainList;
	}

	@Override
	public List<PQRDomain> findPQRsByFilter(final PQRDomain pqrFilters) {
		var quadrilleEntity = getPQREntityAssembler().toEntity(pqrFilters);
		var pqrEntityList = daoFactory.getPQRDAO().findByFilter(quadrilleEntity);
		var pqrDomainList = new ArrayList<PQRDomain>();
		
		for (var pqr : pqrEntityList) {
			pqrDomainList.add(getPQREntityAssembler().toDomain(pqr));
		}
		return pqrDomainList;
	}

	@Override
	public PQRDomain findSpecificPQR(final UUID id) {
		var pqrEntity = daoFactory.getPQRDAO().findById(id);
		
		return getPQREntityAssembler().toDomain(pqrEntity);
	}

}
