package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class DocumentDomain extends Domain {
    
    private String name;
    private String code;

    public DocumentDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setCode(TextHelper.getDefault());
    }

    public DocumentDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
        setCode(TextHelper.getDefault());
    }

    public DocumentDomain(final UUID id, final String name, final String code) {
        super(id);
        setName(name);
        setCode(code);
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

