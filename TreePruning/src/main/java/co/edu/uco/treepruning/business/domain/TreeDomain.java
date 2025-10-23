package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class TreeDomain extends Domain {

    private String longitude;
    private String latitude;
    private FamilyDomain family;
    private SectorDomain sector;

    public TreeDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setFamily(new FamilyDomain());
        setSector(new SectorDomain());
    }

    public TreeDomain(final UUID id) {
        super(id);
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setFamily(new FamilyDomain());
        setSector(new SectorDomain());
    }

    public TreeDomain(final UUID id, final String longitude, final String latitude, final FamilyDomain family, final SectorDomain sector) {
        super(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setFamily(family);
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

    public FamilyDomain getFamily() {
        return family;
    }

    public void setFamily(final FamilyDomain family) {
        this.family = ObjectHelper.getDefault(family, new FamilyDomain());
    }

    public SectorDomain getSector() {
        return sector;
    }

    public void setSector(final SectorDomain sector) {
        this.sector = ObjectHelper.getDefault(sector, new SectorDomain());
    }
}

