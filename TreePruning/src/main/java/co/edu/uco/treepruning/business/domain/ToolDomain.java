package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class ToolDomain extends Domain {

    private String name;
    private String description;

    public ToolDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
    }

    public ToolDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
    }

    public ToolDomain(final UUID id, final String name, final String description) {
        super(id);
        setName(name);
        setDescription(description);
    }

    public String getName() {
        return TextHelper.getDefaultWithTrim(name);
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public String getDescription() {
        return TextHelper.getDefaultWithTrim(description);
    }

    public void setDescription(final String description) {
        this.description = TextHelper.getDefaultWithTrim(description);
    }
}

