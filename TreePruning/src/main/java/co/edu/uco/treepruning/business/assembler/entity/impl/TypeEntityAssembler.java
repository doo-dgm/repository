package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.TypeDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.TypeEntity;

public class TypeEntityAssembler implements EntityAssembler<TypeEntity, TypeDomain> {

    private static final EntityAssembler<TypeEntity, TypeDomain> INSTANCE = new TypeEntityAssembler();

    private TypeEntityAssembler() {
        super();
    }

    public static EntityAssembler<TypeEntity, TypeDomain> getTypeEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public TypeEntity toEntity(final TypeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new TypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new TypeEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public TypeDomain toDomain(final TypeEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new TypeEntity(UUIDHelper.getUUIDHelper().getDefault()));
        return new TypeDomain(entityTmp.getId(), entityTmp.getName());
    }

    @Override
    public List<TypeEntity> toEntity(final List<TypeDomain> domainList) {
        var typeEntityList = new ArrayList<TypeEntity>();

        for (var type : domainList) {
            typeEntityList.add(toEntity(type));
        }

        return typeEntityList;
    }
}
