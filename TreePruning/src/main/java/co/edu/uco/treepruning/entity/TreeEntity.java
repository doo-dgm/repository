package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class TreeEntity {

    private UUID id;
    private double longitude;
    private double latitude;
    private String scientificName;
    private SectorEntity sector;

    public TreeEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setLongitude(0.0);
        setLatitude(0.0);
        setScientificName(TextHelper.getDefault());
        setSector(null);
    }

    public TreeEntity(final UUID id) {
        setId(id);
        setLongitude(0.0);
        setLatitude(0.0);
        setScientificName(TextHelper.getDefault());
        setSector(null);
    }

    public TreeEntity(final UUID id, final double longitude, final double latitude, final String scientificName, final SectorEntity sector) {
        setId(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setScientificName(scientificName);
        setSector(sector);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(final double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(final double latitude) {
        this.latitude = latitude;
    }

    public String getScientificName() {
        return TextHelper.getDefaultWithTrim(scientificName);
    }

    public void setScientificName(final String scientificName) {
        this.scientificName = TextHelper.getDefaultWithTrim(scientificName);
    }

    public SectorEntity getSector() {
        return sector;
    }

    public void setSector(final SectorEntity sector) {
        this.sector = sector == null ? new SectorEntity() : sector;
    }
}

