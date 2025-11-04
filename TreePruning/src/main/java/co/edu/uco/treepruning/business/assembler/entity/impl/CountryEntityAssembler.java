package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.CountryDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.CountryEntity;

public class CountryEntityAssembler implements EntityAssembler<CountryEntity, CountryDomain> {
	
	private static final EntityAssembler<CountryEntity, CountryDomain> INSTANCE = new CountryEntityAssembler();
	
	private CountryEntityAssembler() {
		
	}
	
	public static EntityAssembler<CountryEntity, CountryDomain> getCountryEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public CountryEntity toEntity(CountryDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new CountryEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public CountryDomain toDomain(CountryEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new CountryEntity(UUIDHelper.getUUIDHelper().getDefault()));
		return new CountryDomain(entityTmp.getId(), entityTmp.getName());
	}

	@Override
	public List<CountryEntity> toEntity(List<CountryDomain> domainList) {
		var countryEntityList = new ArrayList<CountryEntity>();
		
		for (var country : domainList) {
			countryEntityList.add(toEntity(country));
		}
		
		return countryEntityList;
	}
	
	@Override
	public List<CountryDomain> toDomain(List<CountryEntity> entityList) {
		var countryDomainList = new ArrayList<CountryDomain>();
		
		for (var country : entityList) {
			countryDomainList.add(toDomain(country));
		}
		
		return countryDomainList;
	}

}
