package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class TreeEntity {

    private UUID id;
    private String longitude;
    private String latitude;
    private FamilyEntity family;
    private SectorEntity sector;

    public TreeEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setFamily(new FamilyEntity());
        setSector(null);
    }

    public TreeEntity(final UUID id) {
        setId(id);
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setFamily(new FamilyEntity());
        setSector(null);
    }

    public TreeEntity(final UUID id, final String longitude, final String latitude, final FamilyEntity family, final SectorEntity sector) {
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

    public FamilyEntity getFamily() {
        return family;
    }

    public void setFamily(final FamilyEntity family) {
        this.family = ObjectHelper.getDefault(family, new FamilyEntity());
    }

    public SectorEntity getSector() {
        return sector;
    }

    public void setSector(final SectorEntity sector) {
        this.sector = ObjectHelper.getDefault(sector, new SectorEntity());
    }
}

