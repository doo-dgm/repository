package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.StateDomain;
import co.edu.uco.treepruning.dto.StateDTO;

public class StateDTOAssembler  implements DTOAssembler<StateDTO, StateDomain>{
	
	private static final DTOAssembler<StateDTO, StateDomain> INSTANCE = new StateDTOAssembler();
	
	private StateDTOAssembler() {
		
	}
	
	public static DTOAssembler<StateDTO, StateDomain> getStateDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public StateDTO toDTO(StateDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateDomain toDomain(StateDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateDTO> toDTO(List<StateDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
