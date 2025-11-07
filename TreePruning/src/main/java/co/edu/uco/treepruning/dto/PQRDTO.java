package co.edu.uco.treepruning.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class PQRDTO {

    private UUID id;
    private LocalDate date;
    private StatusDTO status;
    private RiskDTO risk;
    private SectorDTO sector;
    private PersonDTO person;
    private String photographicRecordPath;

    public PQRDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setDate(DateHelper.getDateHelper().getDefault());
        setStatus(new StatusDTO());
        setRisk(new RiskDTO());
        setSector(new SectorDTO());
        setPerson(new PersonDTO());
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQRDTO(final UUID id) {
        setId(id);
        setDate(DateHelper.getDateHelper().getDefault());
        setStatus(new StatusDTO());
        setRisk(new RiskDTO());
        setSector(new SectorDTO());
        setPerson(new PersonDTO());
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQRDTO(
    		final UUID id, 
    		final LocalDate date, 
    		final StatusDTO status, 
    		final RiskDTO risk,
    		final SectorDTO sector, 
    		final PersonDTO person, 
    		final String photographicRecordPath) {
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
        this.date = DateHelper.getDateHelper().getDefault(date);
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(final StatusDTO status) {
        this.status = ObjectHelper.getDefault(status, new StatusDTO());
    }

    public RiskDTO getRisk() {
        return risk;
    }

    public void setRisk(final RiskDTO risk) {
        this.risk = ObjectHelper.getDefault(risk, new RiskDTO());
    }

    public SectorDTO getSector() {
        return sector;
    }

    public void setSector(final SectorDTO sector) {
        this.sector = ObjectHelper.getDefault(sector, new SectorDTO());
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(final PersonDTO person) {
        this.person = ObjectHelper.getDefault(person, new PersonDTO());
    }

    public String getPhotographicRecordPath() {
        return photographicRecordPath;
    }

    public void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
}

