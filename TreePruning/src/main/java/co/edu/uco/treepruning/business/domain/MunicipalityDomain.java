package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class MunicipalityDomain extends Domain {

    private String name;
    private StateDomain state;

    public MunicipalityDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setState(new StateDomain());
    }

    public MunicipalityDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
        setState(new StateDomain());
    }

    public MunicipalityDomain(final UUID id, final String name, final StateDomain state) {
        super(id);
        setName(name);
        setState(state);
    }

    public String getName() {
        return TextHelper.getDefaultWithTrim(name);
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public StateDomain getState() {
        return state;
    }

    public void setState(final StateDomain state) {
        this.state = ObjectHelper.isNull(state) ? new StateDomain() : state;
    }
}

