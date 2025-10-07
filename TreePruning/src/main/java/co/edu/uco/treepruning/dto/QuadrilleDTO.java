package co.edu.uco.treepruning.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;

public class QuadrilleDTO {

    private UUID id;
    private String name;
    private ManagerDTO manager;

    public QuadrilleDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setManager(null);
    }

    public QuadrilleDTO(final UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
        setManager(null);
    }

    public QuadrilleDTO(final UUID id, final String name, final ManagerDTO manager) {
        setId(id);
        setName(name);
        setManager(manager);
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

    public ManagerDTO getManager() {
        return manager;
    }

    public void setManager(final ManagerDTO manager) {
        this.manager = manager == null ? new ManagerDTO() : manager;
    }
}

