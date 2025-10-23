package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.ManagerDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.ManagerEntity;

import static co.edu.uco.treepruning.business.assembler.entity.impl.PersonEntityAssembler.getPersonEntityAssembler;

public class ManagerEntityAssembler implements EntityAssembler<ManagerEntity, ManagerDomain> {

    private static final EntityAssembler<ManagerEntity, ManagerDomain> INSTANCE = new ManagerEntityAssembler();

    private ManagerEntityAssembler() {

    }

    public static EntityAssembler<ManagerEntity, ManagerDomain> getManagerEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public ManagerEntity toEntity(final ManagerDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ManagerDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var personEntityTmp = getPersonEntityAssembler().toEntity(domainTmp.getPerson());
        return new ManagerEntity(domainTmp.getId(), personEntityTmp);
    }

    @Override
    public ManagerDomain toDomain(final ManagerEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new ManagerEntity(UUIDHelper.getUUIDHelper().getDefault()));
        var personDomainTmp = getPersonEntityAssembler().toDomain(entityTmp.getPerson());
        return new ManagerDomain(entityTmp.getId(), personDomainTmp);
    }

    @Override
    public List<ManagerEntity> toEntity(final List<ManagerDomain> domainList) {
        var managerEntityList = new ArrayList<ManagerEntity>();

        for (var manager : ObjectHelper.getDefault(domainList, List.of())) {
            managerEntityList.add(toEntity(manager));
        }

        return managerEntityList;
    }
}

