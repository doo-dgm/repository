package co.edu.uco.treepruning.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class TreeDTO {

    private UUID id;
    private String longitude;
    private String latitude;
    private FamilyDTO family;
    private SectorDTO sector;

    public TreeDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setFamily(new FamilyDTO());
        setSector(new SectorDTO());
    }

    public TreeDTO(final UUID id) {
        setId(id);
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setFamily(new FamilyDTO());
        setSector(new SectorDTO());
    }

    public TreeDTO(final UUID id, final String longitude, final String latitude, final FamilyDTO family, final SectorDTO sector) {
        setId(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setFamily(family);
        setSector(sector);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }

    public FamilyDTO getFamily() {
        return family;
    }

    public void setFamily(final FamilyDTO family) {
        this.family = ObjectHelper.getDefault(family, new FamilyDTO());
    }

    public SectorDTO getSector() {
        return sector;
    }

    public void setSector(final SectorDTO sector) {
        this.sector = ObjectHelper.getDefault(sector, new SectorDTO());
    }
}

