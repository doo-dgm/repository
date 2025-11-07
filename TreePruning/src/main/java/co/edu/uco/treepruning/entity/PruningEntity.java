package co.edu.uco.treepruning.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;

public final class PruningEntity {

    private UUID id;
    private StatusEntity status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private TreeEntity tree;
    private QuadrilleEntity quadrille;
    private TypeEntity type;
    private PQREntity pqr;
    private String photographicRecordPath;
    private String observations;

    public PruningEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setStatus(new StatusEntity());
        setPlannedDate(DateHelper.getDateHelper().getDefault());
        setExecutedDate(DateHelper.getDateHelper().getDefault());
        setTree(new TreeEntity());
        setQuadrille(new QuadrilleEntity());
        setType(new TypeEntity());
        setPqr(new PQREntity());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public PruningEntity(final UUID id) {
        setStatus(new StatusEntity());
        setPlannedDate(DateHelper.getDateHelper().getDefault());
        setExecutedDate(DateHelper.getDateHelper().getDefault());
        setTree(new TreeEntity());
        setQuadrille(new QuadrilleEntity());
        setType(new TypeEntity());
        setPqr(new PQREntity());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public PruningEntity(final UUID id, final StatusEntity status, final LocalDate plannedDate, final LocalDate executedDate,
                         final TreeEntity tree, final QuadrilleEntity quadrille, final TypeEntity type,
                         final PQREntity pqr,
                         final String photographicRecordPath, final String observations) {
        setId(id);
        setStatus(status);
        setPlannedDate(plannedDate);
        setExecutedDate(executedDate);
        setTree(tree);
        setQuadrille(quadrille);
        setType(type);
        setPqr(pqr);
        setPhotographicRecordPath(photographicRecordPath);
        setObservations(observations);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(final StatusEntity status) {
        this.status = ObjectHelper.getDefault(status, new StatusEntity());
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

    public TreeEntity getTree() {
        return tree;
    }

    public void setTree(final TreeEntity tree) {
        this.tree = ObjectHelper.getDefault(tree, new TreeEntity());
    }

    public QuadrilleEntity getQuadrille() {
        return quadrille;
    }

    public void setQuadrille(final QuadrilleEntity quadrille) {
        this.quadrille = ObjectHelper.getDefault(quadrille, new QuadrilleEntity());
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(final TypeEntity type) {
        this.type = ObjectHelper.getDefault(type, new TypeEntity());
    }

    public PQREntity getPqr() {
        return pqr;
    }

    public void setPqr(final PQREntity pqr) {
        this.pqr = ObjectHelper.getDefault(pqr, new PQREntity());
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

