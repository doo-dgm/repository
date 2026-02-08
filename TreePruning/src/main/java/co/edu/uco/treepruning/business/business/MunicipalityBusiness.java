package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.MunicipalityDomain;

public interface MunicipalityBusiness {
	List<MunicipalityDomain> findAllMunicipalities();
	
	MunicipalityDomain checkMunicipalityById(UUID id);
}
