package co.edu.uco.treepruning.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class SectorDTO {

    private UUID id;
    private String name;
    private MunicipalityDTO municipality;

    public SectorDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setMunicipality(null);
    }

    public SectorDTO(final UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
        setMunicipality(null);
    }

    public SectorDTO(final UUID id, final String name, final MunicipalityDTO municipality) {
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
        return TextHelper.getDefaultWithTrim(name);
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public MunicipalityDTO getMunicipality() {
        return municipality;
    }

    public void setMunicipality(final MunicipalityDTO municipality) {
        this.municipality = ObjectHelper.getDefault(municipality, new MunicipalityDTO());
    }
}
