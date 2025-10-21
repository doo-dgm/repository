package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.StatusDAO;
import co.edu.uco.treepruning.entity.StatusEntity;

public class StatusSqlServerDAO implements StatusDAO {

	public StatusSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StatusEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatusEntity> findByFilter(StatusEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
