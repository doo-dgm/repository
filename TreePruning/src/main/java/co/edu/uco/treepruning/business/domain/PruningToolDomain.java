package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class PruningToolDomain extends Domain {

    private PruningDomain pruning;
    private ToolDomain tool;

    public PruningToolDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setPruning(new PruningDomain());
        setTool(new ToolDomain());
    }

    public PruningToolDomain(final UUID id, final PruningDomain pruning, final ToolDomain tool) {
        super(id);
        setPruning(pruning);
        setTool(tool);
    }

    public static PruningToolDomain create(final UUID id, final PruningDomain pruning, final ToolDomain tool) {
        return new PruningToolDomain(id, pruning, tool);
    }

    public PruningDomain getPruning() {
        return pruning;
    }

    private void setPruning(final PruningDomain pruning) {
        this.pruning = ObjectHelper.getDefault(pruning, new PruningDomain());
    }

    public ToolDomain getTool() {
        return tool;
    }

    private void setTool(final ToolDomain tool) {
        this.tool = ObjectHelper.getDefault(tool, new ToolDomain());
    }
}

