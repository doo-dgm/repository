package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class FamilyDomain extends Domain {
    
    private String scientificName;
    private String commonName;

    public FamilyDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setScientificName(TextHelper.getDefault());
        setCommonName(TextHelper.getDefault());
    }

    public FamilyDomain(final UUID id) {
        super(id);
        setScientificName(TextHelper.getDefault());
        setCommonName(TextHelper.getDefault());
    }

    public FamilyDomain(final UUID id, final String scientificName, final String commonName) {
        super(id);
        setScientificName(scientificName);
        setCommonName(commonName);
    }

    public String getScientificName() {
        return TextHelper.getDefaultWithTrim(scientificName);
    }

    public void setScientificName(final String scientificName) {
        this.scientificName = TextHelper.getDefaultWithTrim(scientificName);
    }

    public String getCommonName() {
        return TextHelper.getDefaultWithTrim(commonName);
    }

    public void setCommonName(final String commonName) {
        this.commonName = TextHelper.getDefaultWithTrim(commonName);
    }
}

