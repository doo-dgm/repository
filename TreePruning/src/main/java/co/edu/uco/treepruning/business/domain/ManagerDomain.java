package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;

public final class ManagerDomain extends Domain {
    
    private PersonDomain person;

    public ManagerDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setPerson(new PersonDomain());
    }

    public ManagerDomain(final UUID id) {
        super(id);
        setPerson(new PersonDomain());
    }

    public ManagerDomain(final UUID id, final PersonDomain person) {
        super(id);
        setPerson(person);
    }

    public PersonDomain getPerson() {
        return person;
    }

    public void setPerson(final PersonDomain person) {
        this.person = ObjectHelper.isNull(person) ? new PersonDomain() : person;
    }
}

