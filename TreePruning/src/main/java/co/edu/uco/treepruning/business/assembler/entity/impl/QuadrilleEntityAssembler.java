package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.QuadrilleDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.QuadrilleEntity;
import static co.edu.uco.treepruning.business.assembler.entity.impl.ManagerEntityAssembler.getManagerEntityAssembler;

public class QuadrilleEntityAssembler implements EntityAssembler<QuadrilleEntity, QuadrilleDomain> {

    private static final EntityAssembler<QuadrilleEntity, QuadrilleDomain> INSTANCE = new QuadrilleEntityAssembler();

    private QuadrilleEntityAssembler() {
        super();
    }

    public static EntityAssembler<QuadrilleEntity, QuadrilleDomain> getQuadrilleEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public QuadrilleEntity toEntity(final QuadrilleDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new QuadrilleDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var managerEntityTmp = getManagerEntityAssembler().toEntity(domainTmp.getManager());

        return new QuadrilleEntity(
                domainTmp.getId(),
                domainTmp.getName(),        
                managerEntityTmp
        );
    }

    @Override
    public QuadrilleDomain toDomain(final QuadrilleEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new QuadrilleEntity(UUIDHelper.getUUIDHelper().getDefault()));
        var managerDomainTmp = getManagerEntityAssembler().toDomain(entityTmp.getManager());

        return new QuadrilleDomain(
                entityTmp.getId(),
                entityTmp.getQuadrilleName(), 
                managerDomainTmp
        );
    }

    @Override
    public List<QuadrilleEntity> toEntity(final List<QuadrilleDomain> domainList) {
        var quadrilleEntityList = new ArrayList<QuadrilleEntity>();

        for (var quadrille : domainList) {
            quadrilleEntityList.add(toEntity(quadrille));
        }

        return quadrilleEntityList;
    }
}

