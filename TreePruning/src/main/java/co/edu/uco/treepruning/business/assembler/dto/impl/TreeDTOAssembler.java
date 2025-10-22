package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.TreeDomain;
import co.edu.uco.treepruning.business.domain.TypeDomain;
import co.edu.uco.treepruning.dto.TreeDTO;
import co.edu.uco.treepruning.dto.TypeDTO;

public class TreeDTOAssembler implements DTOAssembler<TreeDTO, TreeDomain> {
	
	private static final DTOAssembler<TreeDTO, TreeDomain> INSTANCE = new TreeDTOAssembler();
	
	private TreeDTOAssembler() {
		
	}
	
	public static DTOAssembler<TreeDTO, TreeDomain> getTreeDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public TreeDTO toDTO(TreeDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeDomain toDomain(TreeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TreeDTO> toDTO(List<TreeDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
