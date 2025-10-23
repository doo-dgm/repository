package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.PruningDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.PruningEntity;
import static co.edu.uco.treepruning.business.assembler.entity.impl.StatusEntityAssembler.getStatusEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.TreeEntityAssembler.getTreeEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.QuadrilleEntityAssembler.getQuadrilleEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.TypeEntityAssembler.getTypeEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.PQREntityAssembler.getPQREntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.ProgrammingEntityAssembler.getProgrammingEntityAssembler;


public class PruningEntityAssembler implements EntityAssembler<PruningEntity, PruningDomain> {

    private static final EntityAssembler<PruningEntity, PruningDomain> INSTANCE = new PruningEntityAssembler();

    private PruningEntityAssembler() {
        super();
    }

    public static EntityAssembler<PruningEntity, PruningDomain> getPruningEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public PruningEntity toEntity(final PruningDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain,new PruningDomain(UUIDHelper.getUUIDHelper().getDefault()));

        var statusEntityTmp = getStatusEntityAssembler().toEntity(domainTmp.getStatus());
        var treeEntityTmp = getTreeEntityAssembler().toEntity(domainTmp.getTree());
        var quadrilleEntityTmp = getQuadrilleEntityAssembler().toEntity(domainTmp.getQuadrille());
        var typeEntityTmp = getTypeEntityAssembler().toEntity(domainTmp.getType());
        var pqrEntityTmp = getPQREntityAssembler().toEntity(domainTmp.getPqr());
        var programmingEntityTmp = getProgrammingEntityAssembler().toEntity(domainTmp.getProgramming());

        return new PruningEntity(
                domainTmp.getId(),
                statusEntityTmp,
                domainTmp.getPlannedDate(),
                domainTmp.getExecutedDate(),
                treeEntityTmp,
                quadrilleEntityTmp,
                typeEntityTmp,
                pqrEntityTmp,
                programmingEntityTmp,
                domainTmp.getPhotographicRecordPath(),
                domainTmp.getObservations()
        );
    }

    @Override
    public PruningDomain toDomain(final PruningEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity,
                new PruningEntity(UUIDHelper.getUUIDHelper().getDefault()));

        var statusDomainTmp = getStatusEntityAssembler().toDomain(entityTmp.getStatus());
        var treeDomainTmp = getTreeEntityAssembler().toDomain(entityTmp.getTree());
        var quadrilleDomainTmp = getQuadrilleEntityAssembler().toDomain(entityTmp.getQuadrille());
        var typeDomainTmp = getTypeEntityAssembler().toDomain(entityTmp.getType());
        var pqrDomainTmp = getPQREntityAssembler().toDomain(entityTmp.getPqr());
        var programmingDomainTmp = getProgrammingEntityAssembler().toDomain(entityTmp.getProgramming());

        return new PruningDomain(
                entityTmp.getId(),
                statusDomainTmp,
                entityTmp.getPlannedDate(),
                entityTmp.getExecutedDate(),
                treeDomainTmp,
                quadrilleDomainTmp,
                typeDomainTmp,
                pqrDomainTmp,
                programmingDomainTmp,
                entityTmp.getPhotographicRecordPath(),
                entityTmp.getObservations()
        );
    }

    @Override
    public List<PruningEntity> toEntity(final List<PruningDomain> domainList) {
        var pruningEntityList = new ArrayList<PruningEntity>();

        for (var pruning : domainList) {
            pruningEntityList.add(toEntity(pruning));
        }

        return pruningEntityList;
    }
}

