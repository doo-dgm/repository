package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.TypeDomain;

public interface TypeBusiness {
	List<TypeDomain> listAllTypes();
	
	List<TypeDomain> listTypesByCriteria(TypeDomain typeCriteria);
	
	TypeDomain getTypeById(UUID id);
}
