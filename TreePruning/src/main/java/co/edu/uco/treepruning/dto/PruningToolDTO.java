package co.edu.uco.treepruning.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class PruningToolDTO {

    private UUID id;
    private PruningDTO pruning;
    private ToolDTO tool;

    public PruningToolDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setPruning(null);
        setTool(null);
    }

    public PruningToolDTO(final UUID id) {
        setId(id);
        setPruning(null);
        setTool(null);
    }

    public PruningToolDTO(final UUID id, final PruningDTO pruning, final ToolDTO tool) {
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

    public PruningDTO getPruning() {
        return pruning;
    }

    public void setPruning(final PruningDTO pruning) {
        this.pruning = pruning == null ? new PruningDTO() : pruning;
    }

    public ToolDTO getTool() {
        return tool;
    }

    public void setTool(final ToolDTO tool) {
        this.tool = tool == null ? new ToolDTO() : tool;
    }
}

