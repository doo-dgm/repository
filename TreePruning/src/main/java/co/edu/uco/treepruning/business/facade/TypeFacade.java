package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.TypeDTO;

public interface TypeFacade {
	List<TypeDTO> listAllTypes();
	
	List<TypeDTO> listTypesByCriteria(TypeDTO typeCriteria);
	
	TypeDTO getTypeById(UUID id);
}
