package co.edu.uco.treepruning.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class OperatorDTO {

    private UUID id;
    private PersonDTO person;
    private QuadrilleDTO quadrille;

    public OperatorDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setPerson(new PersonDTO());
        setQuadrille(new QuadrilleDTO());
    }

    public OperatorDTO(final UUID id) {
        setId(id);
        setPerson(new PersonDTO());
        setQuadrille(new QuadrilleDTO());
    }

    public OperatorDTO(final UUID id, final PersonDTO person, final QuadrilleDTO quadrille) {
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

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(final PersonDTO person) {
        this.person = ObjectHelper.getDefault(person, new PersonDTO());
    }

    public QuadrilleDTO getQuadrille() {
        return quadrille;
    }

    public void setQuadrille(final QuadrilleDTO quadrille) {
        this.quadrille = ObjectHelper.getDefault(quadrille, new QuadrilleDTO());
    }
}

