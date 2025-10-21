package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.PruningToolDAO;
import co.edu.uco.treepruning.entity.PruningToolEntity;

public class PruningToolSqlServerDAO implements PruningToolDAO {

	public PruningToolSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(PruningToolEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PruningToolEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PruningToolEntity> findByFilter(PruningToolEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruningToolEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PruningToolEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PruningToolEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
