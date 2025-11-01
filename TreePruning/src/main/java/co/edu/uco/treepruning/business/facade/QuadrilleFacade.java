package co.edu.uco.treepruning.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.dto.QuadrilleDTO;

public interface QuadrilleFacade {

	List<QuadrilleDTO> findAllQuadrilles();

	List<QuadrilleDTO> findQuadrillesByFilter(QuadrilleDTO quadrilleFilters);

	QuadrilleDTO findSpecificQuadrille(UUID id);

}
