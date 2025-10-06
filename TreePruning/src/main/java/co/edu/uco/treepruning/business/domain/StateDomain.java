package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class StateDomain extends Domain {

    private CountryDomain country;
    private String name;

    public StateDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setCountry(new CountryDomain());
        setName(TextHelper.getDefault());
    }

    public StateDomain(final UUID id) {
        super(id);
        setCountry(new CountryDomain());
        setName(TextHelper.getDefault());
    }

    public StateDomain(final UUID id, final CountryDomain country, final String name) {
        super(id);
        setCountry(country);
        setName(name);
    }

    public CountryDomain getCountry() {
        return country;
    }

    public void setCountry(final CountryDomain country) {
        this.country = (country == null) ? new CountryDomain() : country;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}

