package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class ToolEntity {

    private UUID id;
    private String name;
    private String description;

    public ToolEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
    }

    public ToolEntity(final UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
    }

    public ToolEntity(final UUID id, final String name, final String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
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

