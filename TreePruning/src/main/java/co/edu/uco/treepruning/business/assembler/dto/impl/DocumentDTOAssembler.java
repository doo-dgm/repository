package co.edu.uco.treepruning.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.dto.DTOAssembler;
import co.edu.uco.treepruning.business.domain.DocumentDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
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
		var domainTmp = ObjectHelper.getDefault(domain, new DocumentDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new DocumentDTO(domainTmp.getId(), domainTmp.getName(), domainTmp.getCode());
	}

	@Override
	public DocumentDomain toDomain(DocumentDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new DocumentDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new DocumentDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getCode());
	}

	@Override
	public List<DocumentDTO> toDTO(List<DocumentDomain> domainList) {
		var documentDTOList = new ArrayList<DocumentDTO>();
		
		for (var document : domainList) {
			documentDTOList.add(toDTO(document));
		}
		
		return documentDTOList;
	}
	

}
