package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.ProgrammingDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.ProgrammingEntity;

public class ProgrammingEntityAssembler implements EntityAssembler<ProgrammingEntity, ProgrammingDomain> {

    private static final EntityAssembler<ProgrammingEntity, ProgrammingDomain> INSTANCE = new ProgrammingEntityAssembler();

    private ProgrammingEntityAssembler() {
        super();
    }

    public static EntityAssembler<ProgrammingEntity, ProgrammingDomain> getProgrammingEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public ProgrammingEntity toEntity(final ProgrammingDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ProgrammingDomain(UUIDHelper.getUUIDHelper().getDefault()));

        return new ProgrammingEntity(
                domainTmp.getId(),
                domainTmp.getInitialDate(),
                domainTmp.getFrequencyMonths(),
                domainTmp.getAmount()
        );
    }

    @Override
    public ProgrammingDomain toDomain(final ProgrammingEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity,
                new ProgrammingEntity(UUIDHelper.getUUIDHelper().getDefault()));

        return new ProgrammingDomain(
                entityTmp.getId(),
                entityTmp.getInitialDate(),
                entityTmp.getFrequencyMonths(),
                entityTmp.getAmount()
        );
    }

    @Override
    public List<ProgrammingEntity> toEntity(final List<ProgrammingDomain> domainList) {
        var programmingEntityList = new ArrayList<ProgrammingEntity>();

        for (var programming : domainList) {
            programmingEntityList.add(toEntity(programming));
        }

        return programmingEntityList;
    }
}

