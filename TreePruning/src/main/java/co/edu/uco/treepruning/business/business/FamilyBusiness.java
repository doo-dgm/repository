package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.FamilyDomain;

public interface FamilyBusiness {
	void incorporateFamily(FamilyDomain familyDomain);
	
	List<FamilyDomain> visualizeFamilies(FamilyDomain familyFilters);
	
	FamilyDomain examineFamilyDetails(UUID id);
	
	void updateFamilyInformation(UUID id, FamilyDomain familyDomain);
	
	void removeFamily(UUID id);
}
