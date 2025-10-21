package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.RiskDAO;
import co.edu.uco.treepruning.entity.RiskEntity;

public class RiskSqlServerDAO implements RiskDAO {

	public RiskSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RiskEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskEntity> findByFilter(RiskEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiskEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
