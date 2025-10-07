package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class PruningToolEntity {

    private UUID id;
    private PruningEntity pruning;
    private ToolEntity tool;

    public PruningToolEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setPruning(null);
        setTool(null);
    }

    public PruningToolEntity(final UUID id) {
        setId(id);
        setPruning(null);
        setTool(null);
    }

    public PruningToolEntity(final UUID id, final PruningEntity pruning, final ToolEntity tool) {
        setId(id);
        setPruning(pruning);
        setTool(tool);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public PruningEntity getPruning() {
        return pruning;
    }

    public void setPruning(final PruningEntity pruning) {
        this.pruning = pruning == null ? new PruningEntity() : pruning;
    }

    public ToolEntity getTool() {
        return tool;
    }

    public void setTool(final ToolEntity tool) {
        this.tool = tool == null ? new ToolEntity() : tool;
    }
}

