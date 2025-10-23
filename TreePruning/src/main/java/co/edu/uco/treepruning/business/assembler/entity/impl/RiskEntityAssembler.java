package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.RiskDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.RiskEntity;

public class RiskEntityAssembler implements EntityAssembler<RiskEntity, RiskDomain> {

    private static final EntityAssembler<RiskEntity, RiskDomain> INSTANCE = new RiskEntityAssembler();

    private RiskEntityAssembler() {
        super();
    }

    public static EntityAssembler<RiskEntity, RiskDomain> getRiskEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public RiskEntity toEntity(final RiskDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new RiskDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new RiskEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public RiskDomain toDomain(final RiskEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new RiskEntity(UUIDHelper.getUUIDHelper().getDefault()));
        return new RiskDomain(entityTmp.getId(), entityTmp.getName());
    }

    @Override
    public List<RiskEntity> toEntity(final List<RiskDomain> domainList) {
        var riskEntityList = new ArrayList<RiskEntity>();

        for (var risk : domainList) {
            riskEntityList.add(toEntity(risk));
        }

        return riskEntityList;
    }
}
