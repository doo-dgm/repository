package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.PruningToolDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.PruningToolEntity;
import static co.edu.uco.treepruning.business.assembler.entity.impl.PruningEntityAssembler.getPruningEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.ToolEntityAssembler.getToolEntityAssembler;

public class PruningToolEntityAssembler implements EntityAssembler<PruningToolEntity, PruningToolDomain> {

    private static final EntityAssembler<PruningToolEntity, PruningToolDomain> INSTANCE = new PruningToolEntityAssembler();

    private PruningToolEntityAssembler() {
        super();
    }

    public static EntityAssembler<PruningToolEntity, PruningToolDomain> getPruningToolEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public PruningToolEntity toEntity(final PruningToolDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new PruningToolDomain(UUIDHelper.getUUIDHelper().getDefault()));

        var pruningEntityTmp = getPruningEntityAssembler().toEntity(domainTmp.getPruning());
        var toolEntityTmp = getToolEntityAssembler().toEntity(domainTmp.getTool());

        return new PruningToolEntity(
                domainTmp.getId(),
                pruningEntityTmp,
                toolEntityTmp
        );
    }

    @Override
    public PruningToolDomain toDomain(final PruningToolEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new PruningToolEntity(UUIDHelper.getUUIDHelper().getDefault()));

        var pruningDomainTmp = getPruningEntityAssembler().toDomain(entityTmp.getPruning());
        var toolDomainTmp = getToolEntityAssembler().toDomain(entityTmp.getTool());

        return new PruningToolDomain(
                entityTmp.getId(),
                pruningDomainTmp,
                toolDomainTmp
        );
    }

    @Override
    public List<PruningToolEntity> toEntity(final List<PruningToolDomain> domainList) {
        var pruningToolEntityList = new ArrayList<PruningToolEntity>();

        for (var pruningTool : domainList) {
            pruningToolEntityList.add(toEntity(pruningTool));
        }

        return pruningToolEntityList;
    }
}

