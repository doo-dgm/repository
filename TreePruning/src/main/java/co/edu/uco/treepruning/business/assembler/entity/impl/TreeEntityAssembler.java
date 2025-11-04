package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.TreeDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.TreeEntity;

import static co.edu.uco.treepruning.business.assembler.entity.impl.FamilyEntityAssembler.getFamilyEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.SectorEntityAssembler.getSectorEntityAssembler;

public class TreeEntityAssembler implements EntityAssembler<TreeEntity, TreeDomain> {

    private static final EntityAssembler<TreeEntity, TreeDomain> INSTANCE = new TreeEntityAssembler();
    
    private TreeEntityAssembler() {
        super();
    }
    
    public static EntityAssembler<TreeEntity, TreeDomain> getTreeEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public TreeEntity toEntity(TreeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new TreeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        
        var familyTmp = getFamilyEntityAssembler().toEntity(domainTmp.getFamily());
        var sectorEntityTmp = getSectorEntityAssembler().toEntity(domainTmp.getSector());

        return new TreeEntity(domainTmp.getId(), domainTmp.getLongitude(),
                domainTmp.getLatitude(), familyTmp, sectorEntityTmp);
    }

    @Override
    public TreeDomain toDomain(TreeEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new TreeEntity(UUIDHelper.getUUIDHelper().getDefault()));
        
        var scientificNameDomainTmp = getFamilyEntityAssembler().toDomain(entityTmp.getFamily());
        var sectorDomainTmp = getSectorEntityAssembler().toDomain(entityTmp.getSector());

        return new TreeDomain(entityTmp.getId(), entityTmp.getLongitude(),
                entityTmp.getLatitude(), scientificNameDomainTmp, sectorDomainTmp);
    }

    @Override
    public List<TreeEntity> toEntity(List<TreeDomain> domainList) {
        var treeEntityList = new ArrayList<TreeEntity>();

        for (var tree : domainList) {
            treeEntityList.add(toEntity(tree));
        }

        return treeEntityList;
    }
    
    @Override
    public List<TreeDomain> toDomain(List<TreeEntity> entityList) {
		var treeDomainList = new ArrayList<TreeDomain>();

		for (var tree : entityList) {
			treeDomainList.add(toDomain(tree));
		}

		return treeDomainList;
	}
}

