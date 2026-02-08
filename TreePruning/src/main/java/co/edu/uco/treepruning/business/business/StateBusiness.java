package co.edu.uco.treepruning.business.business;

import java.util.List;

import co.edu.uco.treepruning.business.domain.StateDomain;

public interface StateBusiness {
	List<StateDomain> listStates(StateDomain stateFilter);
}
