package co.edu.uco.treepruning.business.facade;

import java.util.List;

import co.edu.uco.treepruning.dto.AdministratorDTO;

public interface AdministratorFacade {

	List<AdministratorDTO> findAllAdministrators();

}
