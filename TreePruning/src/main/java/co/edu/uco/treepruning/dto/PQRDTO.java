package co.edu.uco.treepruning.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class PQRDTO {

    private UUID id;
    private LocalDate date;
    private StateDTO state;
    private RiskDTO risk;
    private SectorDTO sector;
    private PersonDTO person;
    private String photographicRecordPath;

    public PQRDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setDate(LocalDate.now());
        setState(null);
        setRisk(null);
        setSector(null);
        setPerson(null);
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQRDTO(final UUID id) {
        setId(id);
        setDate(LocalDate.now());
        setState(null);
        setRisk(null);
        setSector(null);
        setPerson(null);
        setPhotographicRecordPath(TextHelper.getDefault());
    }

    public PQRDTO(final UUID id, final LocalDate date, final StateDTO state, final RiskDTO risk,
                  final SectorDTO sector, final PersonDTO person, final String photographicRecordPath) {
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

    public StateDTO getState() {
        return state;
    }

    public void setState(final StateDTO state) {
        this.state = state == null ? new StateDTO() : state;
    }

    public RiskDTO getRisk() {
        return risk;
    }

    public void setRisk(final RiskDTO risk) {
        this.risk = risk == null ? new RiskDTO() : risk;
    }

    public SectorDTO getSector() {
        return sector;
    }

    public void setSector(final SectorDTO sector) {
        this.sector = sector == null ? new SectorDTO() : sector;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(final PersonDTO person) {
        this.person = person == null ? new PersonDTO() : person;
    }

    public String getPhotographicRecordPath() {
        return TextHelper.getDefaultWithTrim(photographicRecordPath);
    }

    public void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
}

