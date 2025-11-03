package co.edu.uco.treepruning.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class PruningDomain extends Domain {

    private StatusDomain status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private TreeDomain tree;
    private QuadrilleDomain quadrille;
    private TypeDomain type;
    private PQRDomain pqr;
    private ProgrammingDomain programming;
    private String photographicRecordPath;
    private String observations;

    public PruningDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setStatus(new StatusDomain());
        setPlannedDate(DateHelper.getDateHelper().getDefault());
        setExecutedDate(DateHelper.getDateHelper().getDefault());
        setTree(new TreeDomain());
        setQuadrille(new QuadrilleDomain());
        setType(new TypeDomain());
        setPqr(new PQRDomain());
        setProgramming(new ProgrammingDomain());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }
    
    public PruningDomain(UUID id) {
        super(id);
        setStatus(new StatusDomain());
        setPlannedDate(DateHelper.getDateHelper().getDefault());
        setExecutedDate(DateHelper.getDateHelper().getDefault());
        setTree(new TreeDomain());
        setQuadrille(new QuadrilleDomain());
        setType(new TypeDomain());
        setPqr(new PQRDomain());
        setProgramming(new ProgrammingDomain());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public PruningDomain(final UUID id, final StatusDomain status, final LocalDate plannedDate, final LocalDate executedDate,
                         final TreeDomain tree, final QuadrilleDomain quadrille, final TypeDomain type,
                         final PQRDomain pqr, final ProgrammingDomain programming,
                         final String photographicRecordPath, final String observations) {
        super(id);
        setStatus(status);
        setPlannedDate(plannedDate);
        setExecutedDate(executedDate);
        setTree(tree);
        setQuadrille(quadrille);
        setType(type);
        setPqr(pqr);
        setProgramming(programming);
        setPhotographicRecordPath(photographicRecordPath);
        setObservations(observations);
    }

    public StatusDomain getStatus() {
        return status;
    }

    public void setStatus(final StatusDomain status) {
        this.status = ObjectHelper.getDefault(status, new StatusDomain());
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDateHelper().getDefault(plannedDate);
    }

    public LocalDate getExecutedDate() {
        return executedDate;
    }

    public void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = DateHelper.getDateHelper().getDefault(executedDate);
    }

    public TreeDomain getTree() {
        return tree;
    }

    public void setTree(final TreeDomain tree) {
        this.tree = ObjectHelper.getDefault(tree, new TreeDomain());
    }

    public QuadrilleDomain getQuadrille() {
        return quadrille;
    }

    public void setQuadrille(final QuadrilleDomain quadrille) {
        this.quadrille = ObjectHelper.getDefault(quadrille, new QuadrilleDomain());
    }

    public TypeDomain getType() {
        return type;
    }

    public void setType(final TypeDomain type) {
        this.type = ObjectHelper.getDefault(type, new TypeDomain());
    }

    public PQRDomain getPqr() {
        return pqr;
    }

    public void setPqr(final PQRDomain pqr) {
        this.pqr = ObjectHelper.getDefault(pqr, new PQRDomain());
    }

    public ProgrammingDomain getProgramming() {
        return programming;
    }

    public void setProgramming(final ProgrammingDomain programming) {
        this.programming = ObjectHelper.getDefault(programming, new ProgrammingDomain());
    }

    public String getPhotographicRecordPath() {
        return TextHelper.getDefaultWithTrim(photographicRecordPath);
    }

    public void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }

    public String getObservations() {
        return TextHelper.getDefaultWithTrim(observations);
    }

    public void setObservations(final String observations) {
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }
}


