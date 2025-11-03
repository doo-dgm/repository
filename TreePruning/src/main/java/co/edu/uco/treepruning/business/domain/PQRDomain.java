package co.edu.uco.treepruning.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class PQRDomain extends Domain {

    private LocalDate date;
    private StatusDomain status;
    private RiskDomain risk;
    private SectorDomain sector;
    private PersonDomain person;
    private String photographicRecordPath;

    public PQRDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setDate(DateHelper.getDateHelper().getDefault());
        setStatus(new StatusDomain());
        setRisk(new RiskDomain());
        setSector(new SectorDomain());
        setPerson(new PersonDomain());
        setPhotographicRecordPath(TextHelper.getDefault());
    }
    
    public PQRDomain(UUID id) {
        super(id);
        setDate(DateHelper.getDateHelper().getDefault());
        setStatus(new StatusDomain());
        setRisk(new RiskDomain());
        setSector(new SectorDomain());
        setPerson(new PersonDomain());
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQRDomain(final UUID id, final LocalDate date, final StatusDomain status, final RiskDomain risk,
            final SectorDomain sector, final PersonDomain person, final String photographicRecordPath) {
        super(id);
        setDate(date);
        setStatus(status);
        setRisk(risk);
        setSector(sector);
        setPerson(person);
        setPhotographicRecordPath(photographicRecordPath);
    }

    public LocalDate getDate() {
        return date;
    }

    private void setDate(final LocalDate date) {
        this.date = DateHelper.getDateHelper().getDefault(date);
    }

    public StatusDomain getStatus() {
        return status;
    }

    private void setStatus(final StatusDomain status) {
        this.status = ObjectHelper.getDefault(status, new StatusDomain());
    }

    public RiskDomain getRisk() {
        return risk;
    }

    private void setRisk(final RiskDomain risk) {
        this.risk = ObjectHelper.getDefault(risk, new RiskDomain());
    }

    public SectorDomain getSector() {
        return sector;
    }

    private void setSector(final SectorDomain sector) {
        this.sector = ObjectHelper.getDefault(sector, new SectorDomain());
    }

    public PersonDomain getPerson() {
        return person;
    }

    private void setPerson(final PersonDomain person) {
        this.person = ObjectHelper.getDefault(person, new PersonDomain());
    }

    public String getPhotographicRecordPath() {
        return TextHelper.getDefaultWithTrim(photographicRecordPath);
    }

    private void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
}



