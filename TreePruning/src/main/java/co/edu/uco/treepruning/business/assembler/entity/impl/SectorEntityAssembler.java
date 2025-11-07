package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.SectorDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.SectorEntity;

import static co.edu.uco.treepruning.business.assembler.entity.impl.MunicipalityEntityAssembler.getMunicipalityEntityAssembler;

public class SectorEntityAssembler implements EntityAssembler<SectorEntity, SectorDomain> {

    private static final EntityAssembler<SectorEntity, SectorDomain> INSTANCE = new SectorEntityAssembler();

    private SectorEntityAssembler() {
        super();
    }

    public static EntityAssembler<SectorEntity, SectorDomain> getSectorEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public SectorEntity toEntity(final SectorDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new SectorDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var municipalityEntityTmp = getMunicipalityEntityAssembler().toEntity(domainTmp.getMunicipality());
        return new SectorEntity(domainTmp.getId(), domainTmp.getName(), municipalityEntityTmp);
    }

    @Override
    public SectorDomain toDomain(final SectorEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new SectorEntity(UUIDHelper.getUUIDHelper().getDefault()));
        var municipalityDomainTmp = getMunicipalityEntityAssembler().toDomain(entityTmp.getMunicipality());
        return new SectorDomain(entityTmp.getId(), entityTmp.getName(), municipalityDomainTmp);
    }

    @Override
    public List<SectorEntity> toEntity(final List<SectorDomain> domainList) {
        var sectorEntityList = new ArrayList<SectorEntity>();

        for (var sector : domainList) {
            sectorEntityList.add(toEntity(sector));
        }

        return sectorEntityList;
    }
    
    @Override
    public List<SectorDomain> toDomain(final List<SectorEntity> entityList) {
		var sectorDomainList = new ArrayList<SectorDomain>();

		for (var sector : entityList) {
			sectorDomainList.add(toDomain(sector));
		}

		return sectorDomainList;
	}
}

