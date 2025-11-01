package co.edu.uco.treepruning.business.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.QuadrilleBusiness;
import co.edu.uco.treepruning.business.domain.QuadrilleDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

import static co.edu.uco.treepruning.business.assembler.entity.impl.QuadrilleEntityAssembler.getQuadrilleEntityAssembler;

public class QuadrilleBusinessImpl implements QuadrilleBusiness{
	
	private DAOFactory daoFactory;
	
	public QuadrilleBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<QuadrilleDomain> findAllQuadrilles() {
		var quadrilleEntityList = daoFactory.getQuadrilleDAO().findAll();
		var quadrilleDomainList = new ArrayList<QuadrilleDomain>();
		
		for (var quadrilleEntity : quadrilleEntityList) {
			quadrilleDomainList.add(getQuadrilleEntityAssembler().toDomain(quadrilleEntity));
		}
		return quadrilleDomainList;
	}

	@Override
	public List<QuadrilleDomain> findQuadrillesByCriteria(final QuadrilleDomain quadrilleFilters) {
		var quadrilleEntity = getQuadrilleEntityAssembler().toEntity(quadrilleFilters);
		var quadrilleEntityList = daoFactory.getQuadrilleDAO().findByFilter(quadrilleEntity);
		var quadrilleDomainList = new ArrayList<QuadrilleDomain>();
		
		for (var quadrille : quadrilleEntityList) {
			quadrilleDomainList.add(getQuadrilleEntityAssembler().toDomain(quadrille));
		}
		
		return quadrilleDomainList;
	}

	@Override
	public QuadrilleDomain getQuadrilleById(final UUID id) {
		var quadrilleEntity = daoFactory.getQuadrilleDAO().findById(id);
		return getQuadrilleEntityAssembler().toDomain(quadrilleEntity);
	}

	
}
