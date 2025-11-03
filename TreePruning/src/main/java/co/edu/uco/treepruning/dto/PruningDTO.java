package co.edu.uco.treepruning.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class PruningDTO {

    private UUID id;
    private StatusDTO status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private TreeDTO tree;
    private QuadrilleDTO quadrille;
    private TypeDTO type;
    private PQRDTO pqr;
    private ProgrammingDTO programming;
    private String photographicRecordPath;
    private String observations;

    public PruningDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setStatus(new StatusDTO());
        setPlannedDate(DateHelper.getDateHelper().getDefault());
        setExecutedDate(DateHelper.getDateHelper().getDefault());
        setTree(new TreeDTO());
        setQuadrille(new QuadrilleDTO());
        setType(new TypeDTO());
        setPqr(new PQRDTO());
        setProgramming(new ProgrammingDTO());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public PruningDTO(final UUID id) {
        setId(id);
        setStatus(new StatusDTO());
        setPlannedDate(DateHelper.getDateHelper().getDefault());
        setExecutedDate(DateHelper.getDateHelper().getDefault());
        setTree(new TreeDTO());
        setQuadrille(new QuadrilleDTO());
        setType(new TypeDTO());
        setPqr(new PQRDTO());
        setProgramming(new ProgrammingDTO());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public PruningDTO(final UUID id, final StatusDTO status, final LocalDate plannedDate, final LocalDate executedDate,
                      final TreeDTO tree, final QuadrilleDTO quadrille, final TypeDTO type,
                      final PQRDTO pqr, final ProgrammingDTO programming, final String photographicRecordPath,
                      final String observations) {
        setId(id);
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

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(final StatusDTO status) {
        this.status = ObjectHelper.getDefault(status, new StatusDTO());
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

    public TreeDTO getTree() {
        return tree;
    }

    public void setTree(final TreeDTO tree) {
        this.tree = ObjectHelper.getDefault(tree, new TreeDTO());
    }

    public QuadrilleDTO getQuadrille() {
        return quadrille;
    }

    public void setQuadrille(final QuadrilleDTO quadrille) {
        this.quadrille = ObjectHelper.getDefault(quadrille, new QuadrilleDTO());
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(final TypeDTO type) {
        this.type = ObjectHelper.getDefault(type, new TypeDTO());
    }

    public PQRDTO getPqr() {
        return pqr;
    }

    public void setPqr(final PQRDTO pqr) {
        this.pqr = ObjectHelper.getDefault(pqr, new PQRDTO());
    }

    public ProgrammingDTO getProgramming() {
        return programming;
    }

    public void setProgramming(final ProgrammingDTO programming) {
        this.programming = ObjectHelper.getDefault(programming, new ProgrammingDTO());
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

