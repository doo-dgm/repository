package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.DocumentDomain;
import co.edu.uco.treepruning.entity.DocumentEntity;

public class DocumentEntityAssembler implements EntityAssembler<DocumentEntity, DocumentDomain> {
	
	private static final EntityAssembler<DocumentEntity, DocumentDomain> INSTANCE = new DocumentEntityAssembler();
	
	private DocumentEntityAssembler() {
		
	}
	
	public static EntityAssembler<DocumentEntity, DocumentDomain> getDocumentEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public DocumentEntity toEntity(DocumentDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentDomain toDomain(DocumentEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentEntity> toEntity(List<DocumentDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
