package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class QuadrilleEntity {

    private UUID id;
    private String quadrilleName;
    private ManagerEntity manager;

    public QuadrilleEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setQuadrilleName(TextHelper.getDefault());
        setManager(new ManagerEntity());
    }

    public QuadrilleEntity(final UUID id) {
        setId(id);
        setQuadrilleName(TextHelper.getDefault());
        setManager(new ManagerEntity());
    }

    public QuadrilleEntity(final UUID id, final String quadrilleName, final ManagerEntity manager) {
        setId(id);
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getQuadrilleName() {
        return quadrilleName;
    }

    public void setQuadrilleName(final String quadrilleName) {
        this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName);
    }

    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(final ManagerEntity manager) {
        this.manager = ObjectHelper.getDefault(manager, new ManagerEntity());
    }
}

