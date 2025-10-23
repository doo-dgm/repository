package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.PQRDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.PQREntity;
import static co.edu.uco.treepruning.business.assembler.entity.impl.PersonEntityAssembler.getPersonEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.RiskEntityAssembler.getRiskEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.SectorEntityAssembler.getSectorEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.StatusEntityAssembler.getStatusEntityAssembler;

public class PQREntityAssembler implements EntityAssembler<PQREntity, PQRDomain> {

    private static final EntityAssembler<PQREntity, PQRDomain> INSTANCE = new PQREntityAssembler();

    private PQREntityAssembler() {
        super();
    }

    public static EntityAssembler<PQREntity, PQRDomain> getPQREntityAssembler() {
        return INSTANCE;
    }

    @Override
    public PQREntity toEntity(final PQRDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new PQRDomain(UUIDHelper.getUUIDHelper().getDefault()));

        var statusEntityTmp = getStatusEntityAssembler().toEntity(domainTmp.getStatus());
        var riskEntityTmp = getRiskEntityAssembler().toEntity(domainTmp.getRisk());
        var sectorEntityTmp = getSectorEntityAssembler().toEntity(domainTmp.getSector());
        var personEntityTmp = getPersonEntityAssembler().toEntity(domainTmp.getPerson());

        return new PQREntity(
                domainTmp.getId(),
                domainTmp.getDate(),
                statusEntityTmp,
                riskEntityTmp,
                sectorEntityTmp,
                personEntityTmp,
                domainTmp.getPhotographicRecordPath() 
        );
    }

    @Override
    public PQRDomain toDomain(final PQREntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new PQREntity(UUIDHelper.getUUIDHelper().getDefault()));

        var statusDomainTmp = getStatusEntityAssembler().toDomain(entityTmp.getStatus());
        var riskDomainTmp = getRiskEntityAssembler().toDomain(entityTmp.getRisk());
        var sectorDomainTmp = getSectorEntityAssembler().toDomain(entityTmp.getSector());
        var personDomainTmp = getPersonEntityAssembler().toDomain(entityTmp.getPerson());

        return new PQRDomain(
                entityTmp.getId(),
                entityTmp.getDate(),
                statusDomainTmp,
                riskDomainTmp,
                sectorDomainTmp,
                personDomainTmp,
                entityTmp.getPhotographicRecordPath() 
        );
    }

    @Override
    public List<PQREntity> toEntity(final List<PQRDomain> domainList) {
        var pqrEntityList = new ArrayList<PQREntity>();

        for (var pqr : domainList) {
            pqrEntityList.add(toEntity(pqr));
        }

        return pqrEntityList;
    }
}

