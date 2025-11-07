package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.ToolDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.ToolEntity;

public class ToolEntityAssembler implements EntityAssembler<ToolEntity, ToolDomain> {
    
    private static final EntityAssembler<ToolEntity, ToolDomain> INSTANCE = new ToolEntityAssembler();
    
    private ToolEntityAssembler() {
        super();
    }
    
    public static EntityAssembler<ToolEntity, ToolDomain> getToolEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public ToolEntity toEntity(final ToolDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ToolDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new ToolEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription());
    }

    @Override
    public ToolDomain toDomain(final ToolEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new ToolEntity(UUIDHelper.getUUIDHelper().getDefault()));
        return new ToolDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getDescription());
    }

    @Override
    public List<ToolEntity> toEntity(final List<ToolDomain> domainList) {
        var toolEntityList = new ArrayList<ToolEntity>();
        
        for (var tool : domainList) {
            toolEntityList.add(toEntity(tool));
        }
        
        return toolEntityList;
    }
    
    @Override
    public List<ToolDomain> toDomain(final List<ToolEntity> entityList) {
		var toolDomainList = new ArrayList<ToolDomain>();
		
		for (var tool : entityList) {
			toolDomainList.add(toDomain(tool));
		}
		
		return toolDomainList;
	}
}

