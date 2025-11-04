package co.edu.uco.treepruning.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.treepruning.business.assembler.entity.EntityAssembler;
import co.edu.uco.treepruning.business.domain.DocumentDomain;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
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
		var domainTmp = ObjectHelper.getDefault(domain, new DocumentDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new DocumentEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getCode());
	}

	@Override
	public DocumentDomain toDomain(DocumentEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new DocumentEntity(UUIDHelper.getUUIDHelper().getDefault()));
		return new DocumentDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getCode());
	}

	@Override
	public List<DocumentEntity> toEntity(List<DocumentDomain> domainList) {
		var documentEntityList = new ArrayList<DocumentEntity>();
		
		for (var document : domainList) {
			documentEntityList.add(toEntity(document));
		}
		
		return documentEntityList;
	}
	
	@Override
	public List<DocumentDomain> toDomain(List<DocumentEntity> entityList) {
		var documentDomainList = new ArrayList<DocumentDomain>();
		
		for (var document : entityList) {
			documentDomainList.add(toDomain(document));
		}
		
		return documentDomainList;
	}
}
