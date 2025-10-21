package co.edu.uco.treepruning.data.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.treepruning.data.dao.entity.*;
import co.edu.uco.treepruning.data.dao.factory.sqlserver.SqlServerDAOFactory;

public abstract class DAOFactory {
	
	protected Connection connection;
	protected static FactoryEnum factory = FactoryEnum.SQLSERVER;
	
	public static DAOFactory getFactory() {
		
		if(FactoryEnum.SQLSERVER.equals(factory)) {
			return new SqlServerDAOFactory();
		} else {
			var userMessage = MessagesEnum.USER_ERROR_FACTORY_NOT_INITIALIZED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACTORY_NOT_INITIALIZED.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
	}
	
	public abstract AdministratorDAO getAdministratorDAO();
	public abstract CountryDAO getCountryDAO();
	public abstract DocumentDAO getDocumentDAO();
	public abstract FamilyDAO getFamilyDAO();
	public abstract ManagerDAO getManagerDAO();
	public abstract MunicipalityDAO getMunicipalityDAO();
	public abstract OperatorDAO getOperatorDAO();
	public abstract PersonDAO getPersonDAO();
	public abstract PQRDAO getPQRDAO();
	public abstract ProgrammingDAO getProgrammingDAO();
	public abstract PruningDAO getPruningDAO();
	public abstract PruningToolDAO getPrunningToolDAO();
	public abstract QuadrilleDAO getQuadrilleDAO();
	public abstract RiskDAO getRiskDAO();
	public abstract SectorDAO getSectorDAO();
	public abstract StateDAO getStateDAO();
	public abstract StatusDAO getStatusDAO();
	public abstract ToolDAO getToolDAO();
	public abstract TreeDAO getTreeDAO();
	public abstract TypeDAO getTypeDAO();
	
	protected abstract void openConnection();
	
	public final void initTransaction() {
		SqlConnectionHelper.ensureTransactionIsNotStarted(connection);
		try {
			connection.setAutoCommit(false);
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_BEGIN.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_BEGIN.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_BEGIN.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_BEGIN.getContent();
			throw TreePruningException.create(exception,userMessage, technicalMessage);
		}
	}

	public final void commitTransaction() {
		SqlConnectionHelper.ensureTransactionIsStarted(connection);
		try {
			connection.commit();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_COMMIT.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_COMMIT.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_COMMIT.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_COMMIT.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	public final void rollbackTransaction() {
		SqlConnectionHelper.ensureTransactionIsStarted(connection);
		try {
			connection.rollback();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_ROLLBACK.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_ROLLBACK.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_ROLLBACK.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_ROLLBACK.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	public final void closeConnection() {
		SqlConnectionHelper.ensureConnectionIsOpen(connection);
		try {
			connection.close();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_CLOSE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_CLOSE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_CLOSE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_CLOSE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
	}
	
	}
}