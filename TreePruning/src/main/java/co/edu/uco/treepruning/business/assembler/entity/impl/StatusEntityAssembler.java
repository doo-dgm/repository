package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.StatusEntity;

public class StatusEntityAssembler implements EntityAssembler<StatusEntity, StatusDomain> {

    private static final EntityAssembler<StatusEntity, StatusDomain> INSTANCE = new StatusEntityAssembler();

    private StatusEntityAssembler() {
        super();
    }

    public static EntityAssembler<StatusEntity, StatusDomain> getStatusEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public StatusEntity toEntity(final StatusDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new StatusDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new StatusEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public StatusDomain toDomain(final StatusEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new StatusEntity(UUIDHelper.getUUIDHelper().getDefault()));
        return new StatusDomain(entityTmp.getId(), entityTmp.getName());
    }

    @Override
    public List<StatusEntity> toEntity(final List<StatusDomain> domainList) {
        var statusEntityList = new ArrayList<StatusEntity>();

        for (var status : domainList) {
            statusEntityList.add(toEntity(status));
        }

        return statusEntityList;
    }
    
    @Override
    public List<StatusDomain> toDomain(final List<StatusEntity> entityList) {
		var statusDomainList = new ArrayList<StatusDomain>();

		for (var status : entityList) {
			statusDomainList.add(toDomain(status));
		}

		return statusDomainList;
	}
}

