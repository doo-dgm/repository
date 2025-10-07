package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class TreeDomain extends Domain {

    private String longitude;
    private String latitude;
    private String scientificName;
    private SectorDomain sector;

    public TreeDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setScientificName(TextHelper.getDefault());
        setSector(new SectorDomain());
    }

    public TreeDomain(final UUID id) {
        super(id);
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setScientificName(TextHelper.getDefault());
        setSector(new SectorDomain());
    }

    public TreeDomain(final UUID id, final String longitude, final String latitude, final String scientificName, final SectorDomain sector) {
        super(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setScientificName(scientificName);
        setSector(sector);
    }

    public String getLongitude() {
        return TextHelper.getDefaultWithTrim(longitude);
    }

    public void setLongitude(final String longitude) {
        this.longitude = TextHelper.getDefaultWithTrim(longitude);
    }

    public String getLatitude() {
        return TextHelper.getDefaultWithTrim(latitude);
    }

    public void setLatitude(final String latitude) {
        this.latitude = TextHelper.getDefaultWithTrim(latitude);
    }

    public String getScientificName() {
        return TextHelper.getDefaultWithTrim(scientificName);
    }

    public void setScientificName(final String scientificName) {
        this.scientificName = TextHelper.getDefaultWithTrim(scientificName);
    }

    public SectorDomain getSector() {
        return sector;
    }

    public void setSector(final SectorDomain sector) {
        this.sector = ObjectHelper.getDefault(sector, new SectorDomain());
    }
}

