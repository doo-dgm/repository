package co.edu.uco.treepruning.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class ManagerDTO {

    private UUID id;
    private PersonDTO person;

    public ManagerDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setPerson(null);
    }

    public ManagerDTO(final UUID id) {
        setId(id);
        setPerson(null);
    }

    public ManagerDTO(final UUID id, final PersonDTO person) {
        setId(id);
        setPerson(person);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(final PersonDTO person) {
        this.person = person == null ? new PersonDTO() : person;
    }
}

