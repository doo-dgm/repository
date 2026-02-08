package co.edu.uco.treepruning.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.domain.OperatorDomain;

public interface OperatorBusiness {
	void addOperator(OperatorDomain operatorDomain);
	
	List<OperatorDomain> listOperators(OperatorDomain operatorFilters);
	
	OperatorDomain checkOperatorInformation(UUID id);
	
	void updateOperator(UUID id, OperatorDomain operatorDomain);
	
	void removeOperator(UUID id);
}
