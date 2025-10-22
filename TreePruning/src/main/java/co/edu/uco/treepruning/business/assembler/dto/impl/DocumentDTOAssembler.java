package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.DocumentDomain;
import co.edu.uco.treepruning.dto.DocumentDTO;

public class DocumentDTOAssembler implements DTOAssembler<DocumentDTO, DocumentDomain> {
	
	private static final DTOAssembler<DocumentDTO, DocumentDomain> INSTANCE = new DocumentDTOAssembler();
	
	private DocumentDTOAssembler() {
		
	}
	
	public static DTOAssembler<DocumentDTO, DocumentDomain> getDocumentDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public DocumentDTO toDTO(DocumentDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentDomain toDomain(DocumentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentDTO> toDTO(List<DocumentDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
