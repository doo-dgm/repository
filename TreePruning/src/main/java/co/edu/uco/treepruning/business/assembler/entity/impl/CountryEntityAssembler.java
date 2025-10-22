package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.CountryDomain;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryDomain toDomain(CountryEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> toEntity(List<CountryDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
