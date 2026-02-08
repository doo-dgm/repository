package co.edu.uco.treepruning.business.business;

import java.util.List;

import co.edu.uco.treepruning.business.domain.RiskDomain;

public interface RiskBusiness {
	List<RiskDomain> listRisks(RiskDomain riskFilter);
}
