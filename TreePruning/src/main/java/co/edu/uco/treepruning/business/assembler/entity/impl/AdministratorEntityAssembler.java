package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.AdministratorDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.AdministratorEntity;

public class AdministratorEntityAssembler implements EntityAssembler<AdministratorEntity, AdministratorDomain> {
	
	private static final EntityAssembler<AdministratorEntity, AdministratorDomain> INSTANCE = new AdministratorEntityAssembler();
	
	private AdministratorEntityAssembler() {
		
	}
	
	public static EntityAssembler<AdministratorEntity, AdministratorDomain> getAdministratorEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public AdministratorEntity toEntity(final AdministratorDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new AdministratorDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new AdministratorEntity(domainTmp.getId(), domainTmp.getUsername(), domainTmp.getEmail(), domainTmp.isEmailConfirmed(), domainTmp.getMobilePhone(), domainTmp.isMobilePhoneConfirmed());
	}

	@Override
	public AdministratorDomain toDomain(final AdministratorEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new AdministratorEntity(UUIDHelper.getUUIDHelper().getDefault()));
		return new AdministratorDomain(entityTmp.getId(), entityTmp.getUsername(), entityTmp.getEmail(), entityTmp.isEmailConfirmed(), entityTmp.getMobilePhone(), entityTmp.isMobilePhoneConfirmed());
	}

	@Override
	public List<AdministratorEntity> toEntity(final List<AdministratorDomain> domainList) {
		List<AdministratorEntity> administratorEntityList = new ArrayList<AdministratorEntity>();
		
		for (var administrator : domainList) {
			administratorEntityList.add(toEntity(administrator));
		}
		
		return administratorEntityList;
	
	}

}
