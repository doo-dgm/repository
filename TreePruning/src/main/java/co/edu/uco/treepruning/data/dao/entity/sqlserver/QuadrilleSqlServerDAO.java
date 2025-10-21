package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.QuadrilleDAO;
import co.edu.uco.treepruning.entity.QuadrilleEntity;

public class QuadrilleSqlServerDAO implements QuadrilleDAO {

	public QuadrilleSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(QuadrilleEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<QuadrilleEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuadrilleEntity> findByFilter(QuadrilleEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuadrilleEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(QuadrilleEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entity) {
		// TODO Auto-generated method stub
		
	}

}
