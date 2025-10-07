package co.edu.uco.treepruning.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class PruningDTO {

    private UUID id;
    private StateDTO state;
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

    public PruningDTO(final UUID id) {
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

    public PruningDTO(final UUID id, final StateDTO state, final LocalDate plannedDate, final LocalDate executedDate,
                      final TreeDTO tree, final QuadrilleDTO quadrille, final TypeDTO type,
                      final PQRDTO pqr, final ProgrammingDTO programming, final String photographicRecordPath,
                      final String observations) {
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

    public StateDTO getState() {
        return state;
    }

    public void setState(final StateDTO state) {
        this.state = state == null ? new StateDTO() : state;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = plannedDate == null ? LocalDate.now() : plannedDate;
    }

    public LocalDate getExecutedDate() {
        return executedDate;
    }

    public void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = executedDate == null ? LocalDate.now() : executedDate;
    }

    public TreeDTO getTree() {
        return tree;
    }

    public void setTree(final TreeDTO tree) {
        this.tree = tree == null ? new TreeDTO() : tree;
    }

    public QuadrilleDTO getQuadrille() {
        return quadrille;
    }

    public void setQuadrille(final QuadrilleDTO quadrille) {
        this.quadrille = quadrille == null ? new QuadrilleDTO() : quadrille;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(final TypeDTO type) {
        this.type = type == null ? new TypeDTO() : type;
    }

    public PQRDTO getPqr() {
        return pqr;
    }

    public void setPqr(final PQRDTO pqr) {
        this.pqr = pqr == null ? new PQRDTO() : pqr;
    }

    public ProgrammingDTO getProgramming() {
        return programming;
    }

    public void setProgramming(final ProgrammingDTO programming) {
        this.programming = programming == null ? new ProgrammingDTO() : programming;
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

