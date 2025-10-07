package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class CityEntity {

    private UUID id;
    private String name;
    private StateEntity state;

    public CityEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setState(null);
    }

    public CityEntity(final UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
        setState(null);
    }

    public CityEntity(final UUID id, final String name, final StateEntity state) {
        setId(id);
        setName(name);
        setState(state);
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

    public StateEntity getState() {
        return state;
    }

    public void setState(final StateEntity state) {
        this.state = state == null ? new StateEntity() : state;
    }
}

