package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.AdministratorDTO;

public interface AdministratorFacade {

	List<AdministratorDTO> findAllAdministrators();

	List<AdministratorDTO> findAdministratorsByFilter(AdministratorDTO administratorFilters);

	AdministratorDTO findSpecificAdministrator(UUID id);

}
