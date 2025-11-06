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
	private ProgrammingDTO programming;

    public TreeDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setFamily(new FamilyDTO());
        setSector(new SectorDTO());
        setProgramming(new ProgrammingDTO());
    }

    public TreeDTO(final UUID id) {
        setId(id);
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setFamily(new FamilyDTO());
        setSector(new SectorDTO());
        setProgramming(new ProgrammingDTO());
    }

    public TreeDTO(final UUID id, final String longitude, final String latitude, final FamilyDTO family, final SectorDTO sector, final ProgrammingDTO programming) {
        setId(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setFamily(family);
        setSector(sector);
        setProgramming(programming);
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
	public ProgrammingDTO getProgramming() {
		return programming;
	}

	public void setProgramming(ProgrammingDTO programming) {
		this.programming = ObjectHelper.getDefault(programming, new ProgrammingDTO());
		
	}
}

