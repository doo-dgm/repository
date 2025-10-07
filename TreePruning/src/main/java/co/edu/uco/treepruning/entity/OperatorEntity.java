package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class OperatorEntity {

    private UUID id;
    private PersonEntity person;
    private QuadrilleEntity quadrille;

    public OperatorEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setPerson(null);
        setQuadrille(null);
    }

    public OperatorEntity(final UUID id) {
        setId(id);
        setPerson(null);
        setQuadrille(null);
    }

    public OperatorEntity(final UUID id, final PersonEntity person, final QuadrilleEntity quadrille) {
        setId(id);
        setPerson(person);
        setQuadrille(quadrille);
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

    public QuadrilleEntity getQuadrille() {
        return quadrille;
    }

    public void setQuadrille(final QuadrilleEntity quadrille) {
        this.quadrille = quadrille == null ? new QuadrilleEntity() : quadrille;
    }
}

