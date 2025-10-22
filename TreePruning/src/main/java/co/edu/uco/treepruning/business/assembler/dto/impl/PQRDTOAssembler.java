package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.PQRDomain;
import co.edu.uco.treepruning.dto.PQRDTO;

public class PQRDTOAssembler implements DTOAssembler<PQRDTO, PQRDomain> {

	private static final PQRDTOAssembler INSTANCE = new PQRDTOAssembler();
	
	private PQRDTOAssembler() {
		
	}
	
	public static PQRDTOAssembler getInstance() {
		return INSTANCE;
	}
	
	@Override
	public PQRDTO toDTO(PQRDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PQRDomain toDomain(PQRDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PQRDTO> toDTO(List<PQRDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
