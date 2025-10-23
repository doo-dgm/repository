package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class QuadrilleDomain extends Domain {

    private String quadrilleName;
    private ManagerDomain manager;

    public QuadrilleDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setQuadrilleName(TextHelper.getDefault());
        setManager(new ManagerDomain());
    }
    
    public QuadrilleDomain(UUID id) {
        super(id);
        setQuadrilleName(TextHelper.getDefault());
        setManager(new ManagerDomain());
    }

    public QuadrilleDomain(final UUID id, final String quadrilleName, final ManagerDomain manager) {
        super(id);
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public static QuadrilleDomain create(final UUID id, final String quadrilleName, final ManagerDomain manager) {
        return new QuadrilleDomain(id, quadrilleName, manager);
    }

    public String getName() {
        return TextHelper.getDefaultWithTrim(quadrilleName);
    }

    private void setQuadrilleName(final String quadrilleName) {
        this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName);
    }

    public ManagerDomain getManager() {
        return manager;
    }

    private void setManager(final ManagerDomain manager) {
        this.manager = ObjectHelper.getDefault(manager, new ManagerDomain());
    }
}

