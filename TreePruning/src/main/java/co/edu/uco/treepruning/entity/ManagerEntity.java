package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;

public final class ManagerEntity {

    private UUID id;
    private PersonEntity person;

    public ManagerEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setPerson(null);
    }

    public ManagerEntity(final UUID id) {
        setId(id);
        setPerson(null);
    }

    public ManagerEntity(final UUID id, final PersonEntity person) {
        setId(id);
        setPerson(person);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(final PersonEntity person) {
        this.person = person == null ? new PersonEntity() : person;
    }
}

