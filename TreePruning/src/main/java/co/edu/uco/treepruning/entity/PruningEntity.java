package co.edu.uco.treepruning.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;

public final class PruningEntity {

    private UUID id;
    private StateEntity state;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private TreeEntity tree;
    private QuadrilleEntity quadrille;
    private TypeEntity type;
    private PQREntity pqr;
    private ProgrammingEntity programming;
    private String photographicRecordPath;
    private String observations;

    public PruningEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setState(null);
        setPlannedDate(LocalDate.now());
        setExecutedDate(LocalDate.now());
        setTree(null);
        setQuadrille(null);
        setType(null);
        setPqr(null);
        setProgramming(null);
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public PruningEntity(final UUID id) {
        setId(id);
        setState(null);
        setPlannedDate(LocalDate.now());
        setExecutedDate(LocalDate.now());
        setTree(null);
        setQuadrille(null);
        setType(null);
        setPqr(null);
        setProgramming(null);
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public PruningEntity(final UUID id, final StateEntity state, final LocalDate plannedDate, final LocalDate executedDate,
                         final TreeEntity tree, final QuadrilleEntity quadrille, final TypeEntity type,
                         final PQREntity pqr, final ProgrammingEntity programming,
                         final String photographicRecordPath, final String observations) {
        setId(id);
        setState(state);
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

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(final StateEntity state) {
        this.state = state == null ? new StateEntity() : state;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = ObjectHelper.getDefault(plannedDate, LocalDate.now());
    }

    public LocalDate getExecutedDate() {
        return executedDate;
    }

    public void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = ObjectHelper.getDefault(executedDate, LocalDate.now());
    }

    public TreeEntity getTree() {
        return tree;
    }

    public void setTree(final TreeEntity tree) {
        this.tree = tree == null ? new TreeEntity() : tree;
    }

    public QuadrilleEntity getQuadrille() {
        return quadrille;
    }

    public void setQuadrille(final QuadrilleEntity quadrille) {
        this.quadrille = quadrille == null ? new QuadrilleEntity() : quadrille;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(final TypeEntity type) {
        this.type = type == null ? new TypeEntity() : type;
    }

    public PQREntity getPqr() {
        return pqr;
    }

    public void setPqr(final PQREntity pqr) {
        this.pqr = pqr == null ? new PQREntity() : pqr;
    }

    public ProgrammingEntity getProgramming() {
        return programming;
    }

    public void setProgramming(final ProgrammingEntity programming) {
        this.programming = programming == null ? new ProgrammingEntity() : programming;
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

