package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.ProgrammingDAO;
import co.edu.uco.treepruning.entity.ProgrammingEntity;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;

public class ProgrammingSqlServerDAO implements ProgrammingDAO {

	public ProgrammingSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(ProgrammingEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProgrammingEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProgrammingEntity> findByFilter(ProgrammingEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProgrammingEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ProgrammingEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entity) {
		// TODO Auto-generated method stub
		
	}

}
