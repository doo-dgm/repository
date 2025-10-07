package co.edu.uco.treepruning.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class PQREntity {

    private UUID id;
    private LocalDate date;
    private StateEntity state;
    private RiskEntity risk;
    private SectorEntity sector;
    private PersonEntity person;
    private String photographicRecordPath;

    public PQREntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setDate(LocalDate.now());
        setState(null);
        setRisk(null);
        setSector(null);
        setPerson(null);
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQREntity(final UUID id) {
        setId(id);
        setDate(LocalDate.now());
        setState(null);
        setRisk(null);
        setSector(null);
        setPerson(null);
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQREntity(final UUID id, final LocalDate date, final StateEntity state, final RiskEntity risk,
                     final SectorEntity sector, final PersonEntity person, final String photographicRecordPath) {
        setId(id);
        setDate(date);
        setState(state);
        setRisk(risk);
        setSector(sector);
        setPerson(person);
        setPhotographicRecordPath(photographicRecordPath);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date == null ? LocalDate.now() : date;
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(final StateEntity state) {
        this.state = state == null ? new StateEntity() : state;
    }

    public RiskEntity getRisk() {
        return risk;
    }

    public void setRisk(final RiskEntity risk) {
        this.risk = risk == null ? new RiskEntity() : risk;
    }

    public SectorEntity getSector() {
        return sector;
    }

    public void setSector(final SectorEntity sector) {
        this.sector = sector == null ? new SectorEntity() : sector;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(final PersonEntity person) {
        this.person = person == null ? new PersonEntity() : person;
    }

    public String getPhotographicRecordPath() {
        return TextHelper.getDefaultWithTrim(photographicRecordPath);
    }

    public void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
}

