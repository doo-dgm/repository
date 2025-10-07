package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class DocumentEntity {

    private UUID id;
    private String name;
    private String code;

    public DocumentEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setCode(TextHelper.getDefault());
    }

    public DocumentEntity(final UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
        setCode(TextHelper.getDefault());
    }

    public DocumentEntity(final UUID id, final String name, final String code) {
        setId(id);
        setName(name);
        setCode(code);
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

    public String getCode() {
        return TextHelper.getDefaultWithTrim(code);
    }

    public void setCode(final String code) {
        this.code = TextHelper.getDefaultWithTrim(code);
    }
}

