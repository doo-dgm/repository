package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.ToolDAO;
import co.edu.uco.treepruning.entity.ToolEntity;

public class ToolSqlServerDAO implements ToolDAO {
	
	public ToolSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(ToolEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ToolEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ToolEntity> findByFilter(ToolEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToolEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ToolEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entity) {
		// TODO Auto-generated method stub
		
	}

}
