package co.edu.uco.treepruning.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class RiskDTO {

    private UUID id;
    private String name;

    public RiskDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public RiskDTO(final UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
    }

    public RiskDTO(final UUID id, final String name) {
        setId(id);
        setName(name);
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
}

