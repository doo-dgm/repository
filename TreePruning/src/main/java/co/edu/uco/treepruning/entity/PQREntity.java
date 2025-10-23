package co.edu.uco.treepruning.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class PQREntity {

    private UUID id;
    private LocalDate date;
    private StatusEntity status;
    private RiskEntity risk;
    private SectorEntity sector;
    private PersonEntity person;
    private String photographicRecordPath;

    public PQREntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setDate(LocalDate.now());
        setStatus(new StatusEntity());
        setRisk(new RiskEntity());
        setSector(new SectorEntity());
        setPerson(new PersonEntity());
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQREntity(final UUID id) {
        setId(id);
        setDate(LocalDate.now());
        setStatus(new StatusEntity());
        setRisk(new RiskEntity());
        setSector(new SectorEntity());
        setPerson(new PersonEntity());
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQREntity(final UUID id, final LocalDate date, final StatusEntity status, final RiskEntity risk,
                     final SectorEntity sector, final PersonEntity person, final String photographicRecordPath) {
        setId(id);
        setDate(date);
        setStatus(status);
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

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(final StatusEntity status) {
        this.status = ObjectHelper.getDefault(status, new StatusEntity());
    }

    public RiskEntity getRisk() {
        return risk;
    }

    public void setRisk(final RiskEntity risk) {
        this.risk = ObjectHelper.getDefault(risk, new RiskEntity());
    }

    public SectorEntity getSector() {
        return sector;
    }

    public void setSector(final SectorEntity sector) {
        this.sector = ObjectHelper.getDefault(sector, new SectorEntity());
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(final PersonEntity person) {
        this.person = ObjectHelper.getDefault(person, new PersonEntity());
    }

    public String getPhotographicRecordPath() {
        return TextHelper.getDefaultWithTrim(photographicRecordPath);
    }

    public void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
}

