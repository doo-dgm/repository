package co.edu.uco.treepruning.business.domain;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class OperatorDomain extends Domain {

	private PersonDomain person;
	private QuadrilleDomain quadrille;

	public OperatorDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setPerson(new PersonDomain());
		setQuadrille(new QuadrilleDomain());
	}
	
	public OperatorDomain(UUID id) {
		super(id);
		setPerson(new PersonDomain());
		setQuadrille(new QuadrilleDomain());
	}

	public OperatorDomain(final UUID id, final PersonDomain person, final QuadrilleDomain quadrille) {
		super(id);
		setPerson(person);
		setQuadrille(quadrille);
	}

	public static OperatorDomain create(final UUID id, final PersonDomain person, final QuadrilleDomain quadrille) {
		return new OperatorDomain(id, person, quadrille);
	}

	public PersonDomain getPerson() {
		return person;
	}

	private void setPerson(final PersonDomain person) {
		this.person = ObjectHelper.getDefault(person, new PersonDomain());
	}

	public QuadrilleDomain getQuadrille() {
		return quadrille;
	}

	private void setQuadrille(final QuadrilleDomain quadrille) {
		this.quadrille = ObjectHelper.getDefault(quadrille, new QuadrilleDomain());
	}
}

