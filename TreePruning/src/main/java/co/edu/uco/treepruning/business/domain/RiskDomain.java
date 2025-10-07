package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class RiskDomain extends Domain {

    private String name;

    public RiskDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public RiskDomain(final UUID id, final String name) {
        super(id);
        setName(name);
    }

    public static RiskDomain create(final UUID id, final String name) {
        return new RiskDomain(id, name);
    }

    public String getName() {
        return TextHelper.getDefaultWithTrim(name);
    }

    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}
