package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.treepruning.data.dao.entity.DocumentDAO;
import co.edu.uco.treepruning.entity.DocumentEntity;

public class DocumentSqlServerDAO implements DocumentDAO {

	public DocumentSqlServerDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DocumentEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentEntity> findByFilter(DocumentEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
