package co.edu.uco.treepruning.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class PQRDomain extends Domain {

    private LocalDate date;
    private StateDomain state;
    private RiskDomain risk;
    private SectorDomain sector;
    private PersonDomain person;
    private String photographicRecordPath;

    public PQRDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setDate(LocalDate.now());
        setState(new StateDomain());
        setRisk(new RiskDomain());
        setSector(new SectorDomain());
        setPerson(new PersonDomain());
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQRDomain(final UUID id, final LocalDate date, final StateDomain state, final RiskDomain risk,
            final SectorDomain sector, final PersonDomain person, final String photographicRecordPath) {
        super(id);
        setDate(date);
        setState(state);
        setRisk(risk);
        setSector(sector);
        setPerson(person);
        setPhotographicRecordPath(photographicRecordPath);
    }

    public static PQRDomain create(final UUID id, final LocalDate date, final StateDomain state, final RiskDomain risk,
            final SectorDomain sector, final PersonDomain person, final String photographicRecordPath) {
        return new PQRDomain(id, date, state, risk, sector, person, photographicRecordPath);
    }

    public LocalDate getDate() {
        return date;
    }

    private void setDate(final LocalDate date) {
        this.date = ObjectHelper.getDefault(date, LocalDate.now());
    }

    public StateDomain getState() {
        return state;
    }

    private void setState(final StateDomain state) {
        this.state = ObjectHelper.getDefault(state, new StateDomain());
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



