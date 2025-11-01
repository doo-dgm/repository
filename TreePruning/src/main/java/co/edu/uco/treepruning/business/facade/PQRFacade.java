package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.PQRDTO;

public interface PQRFacade {

	List<PQRDTO> findAllPQRS();

	List<PQRDTO> findPQRSByFilter(PQRDTO pqrFilters);

	PQRDTO findSpecificPQR(UUID id);

}
