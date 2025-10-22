package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.TypeDomain;
import co.edu.uco.treepruning.entity.TypeEntity;

public class TypeEntityAssembler implements EntityAssembler<TypeEntity, TypeDomain> {
	
	private static final EntityAssembler<TypeEntity, TypeDomain> INSTANCE = new TypeEntityAssembler();
	
	private TypeEntityAssembler() {
		
	}
	
	public static EntityAssembler<TypeEntity, TypeDomain> getTypeEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public TypeEntity toEntity(TypeDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDomain toDomain(TypeEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeEntity> toEntity(List<TypeDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
