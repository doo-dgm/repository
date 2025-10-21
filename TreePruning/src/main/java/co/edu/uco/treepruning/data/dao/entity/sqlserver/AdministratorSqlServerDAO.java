package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.AdministratorDAO;
import co.edu.uco.treepruning.entity.AdministratorEntity;

public class AdministratorSqlServerDAO implements AdministratorDAO {

	public AdministratorSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(AdministratorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdministratorEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdministratorEntity> findByFilter(AdministratorEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdministratorEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AdministratorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entity) {
		// TODO Auto-generated method stub
		
	}

}
