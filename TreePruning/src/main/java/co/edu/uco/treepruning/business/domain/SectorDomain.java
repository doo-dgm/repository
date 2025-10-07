package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class SectorDomain extends Domain {

    private String name;
    private MunicipalityDomain municipality;

    public SectorDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setMunicipality(new MunicipalityDomain());
    }

    public SectorDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
        setMunicipality(new MunicipalityDomain());
    }

    public SectorDomain(final UUID id, final String name, final MunicipalityDomain municipality) {
        super(id);
        setName(name);
        setMunicipality(municipality);
    }

    public String getName() {
        return TextHelper.getDefaultWithTrim(name);
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public MunicipalityDomain getMunicipality() {
        return municipality;
    }

    public void setMunicipality(final MunicipalityDomain municipality) {
        this.municipality = ObjectHelper.isNull(municipality) ? new MunicipalityDomain() : municipality;
    }
}

