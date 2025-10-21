package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.TypeDAO;
import co.edu.uco.treepruning.entity.TypeEntity;

public class TypeSqlServerDAO implements TypeDAO {

	public TypeSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TypeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeEntity> findByFilter(TypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
