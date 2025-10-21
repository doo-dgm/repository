package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.TreeDAO;
import co.edu.uco.treepruning.entity.TreeEntity;

public class TreeSqlServerDAO implements TreeDAO {

	public TreeSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(TreeEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TreeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TreeEntity> findByFilter(TreeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TreeEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TreeEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
