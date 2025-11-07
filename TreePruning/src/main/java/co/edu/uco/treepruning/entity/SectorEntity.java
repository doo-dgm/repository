package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class SectorEntity {

    private UUID id;
    private String name;
    private MunicipalityEntity municipality;

    public SectorEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setMunicipality(new MunicipalityEntity());
    }

    public SectorEntity(final UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
        setMunicipality(new MunicipalityEntity());
    }

    public SectorEntity(final UUID id, final String name, final MunicipalityEntity municipality) {
        setId(id);
        setName(name);
        setMunicipality(municipality);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public MunicipalityEntity getMunicipality() {
        return municipality;
    }

    public void setMunicipality(final MunicipalityEntity municipality) {
        this.municipality = ObjectHelper.getDefault(municipality, new MunicipalityEntity());
    }
}

