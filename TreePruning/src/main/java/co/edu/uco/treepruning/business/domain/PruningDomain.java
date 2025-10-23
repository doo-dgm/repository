package co.edu.uco.treepruning.business.domain;

import java.time.LocalDate;
import java.util.UUID;

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
        setPlannedDate(LocalDate.now());
        setExecutedDate(LocalDate.now());
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
        setPlannedDate(LocalDate.now());
        setExecutedDate(LocalDate.now());
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

    private void setStatus(final StatusDomain status) {
        this.status = ObjectHelper.getDefault(status, new StatusDomain());
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    private void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = ObjectHelper.getDefault(plannedDate, LocalDate.now());
    }

    public LocalDate getExecutedDate() {
        return executedDate;
    }

    private void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = ObjectHelper.getDefault(executedDate, LocalDate.now());
    }

    public TreeDomain getTree() {
        return tree;
    }

    private void setTree(final TreeDomain tree) {
        this.tree = ObjectHelper.getDefault(tree, new TreeDomain());
    }

    public QuadrilleDomain getQuadrille() {
        return quadrille;
    }

    private void setQuadrille(final QuadrilleDomain quadrille) {
        this.quadrille = ObjectHelper.getDefault(quadrille, new QuadrilleDomain());
    }

    public TypeDomain getType() {
        return type;
    }

    private void setType(final TypeDomain type) {
        this.type = ObjectHelper.getDefault(type, new TypeDomain());
    }

    public PQRDomain getPqr() {
        return pqr;
    }

    private void setPqr(final PQRDomain pqr) {
        this.pqr = ObjectHelper.getDefault(pqr, new PQRDomain());
    }

    public ProgrammingDomain getProgramming() {
        return programming;
    }

    private void setProgramming(final ProgrammingDomain programming) {
        this.programming = ObjectHelper.getDefault(programming, new ProgrammingDomain());
    }

    public String getPhotographicRecordPath() {
        return TextHelper.getDefaultWithTrim(photographicRecordPath);
    }

    private void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }

    public String getObservations() {
        return TextHelper.getDefaultWithTrim(observations);
    }

    private void setObservations(final String observations) {
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }
}


