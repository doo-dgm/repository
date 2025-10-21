package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.SectorDAO;
import co.edu.uco.treepruning.entity.SectorEntity;

public class SectorSqlServerDAO implements SectorDAO {

	public SectorSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(SectorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SectorEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SectorEntity> findByFilter(SectorEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SectorEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SectorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SectorEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
