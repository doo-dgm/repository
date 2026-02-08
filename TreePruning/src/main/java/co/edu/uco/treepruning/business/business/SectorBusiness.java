package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.SectorDomain;

public interface SectorBusiness {
	void addSector(UUID id, SectorDomain sectorDomain);
	
	void updateSector(UUID id, SectorDomain sectorDomain);
	
	void removeSector(UUID id);
	
	List<SectorDomain> reviewSectors();
	
	SectorDomain examineSpecificSector(UUID id);
}
