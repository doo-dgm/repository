package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.PQRDomain;

public interface PQRBusiness {
	List<PQRDomain> findAllPQRs();
	
	List<PQRDomain> findPQRsByFilter(PQRDomain pqrFilters);
	
	PQRDomain findSpecificPQR(UUID id);
}
