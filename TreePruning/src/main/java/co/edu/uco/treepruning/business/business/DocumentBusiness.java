package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.DocumentDomain;

public interface DocumentBusiness {
	List<DocumentDomain> visualizeDocuments(DocumentDomain documentFilters);
	
	DocumentDomain showDocumentDetails(UUID id);
	
	void updateDocumentsInfo(UUID id, DocumentDomain document);
}
