package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.QuadrilleDomain;

public interface QuadrilleBusiness {
	List<QuadrilleDomain> findAllQuadrilles();
	
	List<QuadrilleDomain> findQuadrillesByCriteria(QuadrilleDomain quadrilleCriteria);
	
	QuadrilleDomain getQuadrilleById(UUID id);
}
