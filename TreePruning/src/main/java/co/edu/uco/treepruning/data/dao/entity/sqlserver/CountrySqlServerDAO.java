package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.data.dao.entity.CountryDAO;
import co.edu.uco.treepruning.entity.CountryEntity;

public class CountrySqlServerDAO implements CountryDAO {

	public CountrySqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CountryEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> findByFilter(CountryEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
