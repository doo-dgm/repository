package co.edu.uco.treepruning.data.dao.entity;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.helper.SqlConnectionHelper;

public abstract class SqlConnection {
private Connection connection;
	
	protected SqlConnection(final Connection connection) {
		setConnection(connection);
	}

	protected Connection getConnection() {
		return connection;
		//return SqlConnectionHelper.setConnection();
	}

	private void setConnection(Connection connection) {
		SqlConnectionHelper.ensureConnectionIsOpen(connection);
		
		this.connection = connection;
		//this.connection = SqlConnectionHelper.setConnection();
	}
}
