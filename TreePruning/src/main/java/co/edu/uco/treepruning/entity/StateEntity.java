package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class StateEntity {

    private UUID id;
    private String name;
    private CountryEntity country;

    public StateEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setCountry(null);
    }

    public StateEntity(final UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
        setCountry(null);
    }

    public StateEntity(final UUID id, final String name, final CountryEntity country) {
        setId(id);
        setName(name);
        setCountry(country);
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

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(final CountryEntity country) {
        this.country = country == null ? new CountryEntity() : country;
    }
}

