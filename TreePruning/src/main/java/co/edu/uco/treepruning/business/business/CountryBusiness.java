package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.CountryDomain;

public interface CountryBusiness {
	List<CountryDomain> exploreAllCoubntries();
	List<CountryDomain> exploreCountries(CountryDomain countryFilters);
	CountryDomain listCountry(UUID id);
}
