package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.PQRDAO;
import co.edu.uco.treepruning.entity.PQREntity;

public class PQRSqlServerDAO implements PQRDAO {

	public PQRSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(PQREntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PQREntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PQREntity> findByFilter(PQREntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PQREntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PQREntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PQREntity entity) {
		// TODO Auto-generated method stub
		
	}

}
