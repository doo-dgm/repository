package co.edu.uco.treepruning.business.business.impl;

import static co.edu.uco.treepruning.business.assembler.entity.impl.CountryEntityAssembler.getCountryEntityAssembler;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.business.CountryBusiness;
import co.edu.uco.treepruning.business.domain.CountryDomain;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class CountryBusinessImpl implements CountryBusiness {
	
	private DAOFactory daoFactory;
	
	public CountryBusinessImpl (final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public List<CountryDomain> exploreAllCoubntries() {
		var countryEntityList = daoFactory.getCountryDAO().findAll(); 
		
		return getCountryEntityAssembler().toDomain(countryEntityList);
	}

	
	@Override
	public List<CountryDomain> exploreCountries(final CountryDomain countryFilters) {
		var countryEntityList = daoFactory.getCountryDAO().findByFilter(getCountryEntityAssembler().toEntity(countryFilters));
		
		return getCountryEntityAssembler().toDomain(countryEntityList);
	}

	@Override
	public CountryDomain listCountry(final UUID id) {
		return getCountryEntityAssembler().toDomain(daoFactory.getCountryDAO().findById(id));
	}

	
}
