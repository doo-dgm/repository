package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class FamilyEntity {

    private UUID id;
    private String scientificName;
    private String commonName;

    public FamilyEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setScientificName(TextHelper.getDefault());
        setCommonName(TextHelper.getDefault());
    }

    public FamilyEntity(final UUID id) {
        setId(id);
        setScientificName(TextHelper.getDefault());
        setCommonName(TextHelper.getDefault());
    }

    public FamilyEntity(final UUID id, final String scientificName, final String commonName) {
        setId(id);
        setScientificName(scientificName);
        setCommonName(commonName);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
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

