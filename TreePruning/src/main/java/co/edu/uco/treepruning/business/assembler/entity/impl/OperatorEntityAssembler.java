package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.OperatorDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.entity.OperatorEntity;
import static co.edu.uco.treepruning.business.assembler.entity.impl.PersonEntityAssembler.getPersonEntityAssembler;
import static co.edu.uco.treepruning.business.assembler.entity.impl.QuadrilleEntityAssembler.getQuadrilleEntityAssembler;

public class OperatorEntityAssembler implements EntityAssembler<OperatorEntity, OperatorDomain> {

	private static final EntityAssembler<OperatorEntity, OperatorDomain> INSTANCE = new OperatorEntityAssembler();

	private OperatorEntityAssembler() {
		
	}

	public static EntityAssembler<OperatorEntity, OperatorDomain> getOperatorEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public OperatorEntity toEntity(final OperatorDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new OperatorDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var personEntityTmp = getPersonEntityAssembler().toEntity(domainTmp.getPerson());
		var quadrilleEntityTmp = getQuadrilleEntityAssembler().toEntity(domainTmp.getQuadrille());

		return new OperatorEntity(domainTmp.getId(), personEntityTmp, quadrilleEntityTmp);
	}

	@Override
	public OperatorDomain toDomain(final OperatorEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new OperatorEntity(UUIDHelper.getUUIDHelper().getDefault()));
		var personDomainTmp = getPersonEntityAssembler().toDomain(entityTmp.getPerson());
		var quadrilleDomainTmp = getQuadrilleEntityAssembler().toDomain(entityTmp.getQuadrille());

		return new OperatorDomain(entityTmp.getId(), personDomainTmp, quadrilleDomainTmp);
	}

	@Override
	public List<OperatorEntity> toEntity(final List<OperatorDomain> domainList) {
		var operatorEntityList = new ArrayList<OperatorEntity>();

		for (var operator : domainList) {
			operatorEntityList.add(toEntity(operator));
		}

		return operatorEntityList;
	}
}
