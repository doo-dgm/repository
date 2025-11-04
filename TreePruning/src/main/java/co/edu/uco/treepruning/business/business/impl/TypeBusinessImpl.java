package co.edu.uco.treepruning.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.TypeBusiness;
import co.edu.uco.treepruning.business.domain.TypeDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

import static co.edu.uco.treepruning.business.assembler.entity.impl.TypeEntityAssembler.getTypeEntityAssembler;

public class TypeBusinessImpl implements TypeBusiness {
	private DAOFactory daoFactory;
	
	public TypeBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public List<TypeDomain> listAllTypes() {
		return getTypeEntityAssembler().toDomain(daoFactory.getTypeDAO().findAll());
	}

	@Override
	public List<TypeDomain> listTypesByCriteria(final TypeDomain typeCriteria) {
		var typeEntity = getTypeEntityAssembler().toEntity(typeCriteria);
		return getTypeEntityAssembler().toDomain(daoFactory.getTypeDAO().findByFilter(typeEntity));
	}

	@Override
	public TypeDomain getTypeById(final UUID id) {
		var typeEntity = daoFactory.getTypeDAO().findById(id);
		return getTypeEntityAssembler().toDomain(typeEntity);
	}
}
