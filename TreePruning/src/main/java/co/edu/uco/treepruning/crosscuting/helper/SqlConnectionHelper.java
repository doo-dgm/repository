package co.edu.uco.treepruning.crosscuting.helper;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;

public class SqlConnectionHelper {
	
	private SqlConnectionHelper() {
		
	}

    public static void ensureConnectionIsNotNull(final Connection connection) {
 
		if(ObjectHelper.isNull(connection)) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);	
		}
    }
    
    public static void ensureConnectionIsOpen(final Connection connection) {
    	
    	ensureConnectionIsNotNull(connection);
		try {
			if (connection.isClosed()) {
				var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
				throw TreePruningException.create(userMessage, technicalMessage);
            }
            
        } catch (SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_CLOSED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_CLOSED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_CLOSED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_CLOSED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }
    
    public static void ensureTransactionIsStarted(final Connection connection) {
    	
    	ensureConnectionIsOpen(connection);
    	
		try {
			if (connection.getAutoCommit()) {
				var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_IS_NOT_STARTED.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED.getContent();
				throw TreePruningException.create(userMessage, technicalMessage);
            }
            
        } catch (SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_NOT_OPEN.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_NOT_OPEN.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_NOT_OPEN.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_NOT_OPEN.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }
    
    public static void ensureTransactionIsNotStarted(final Connection connection) {

    	ensureConnectionIsOpen(connection);
    	
		try {
			if (!connection.getAutoCommit()) {
				var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_IS_STARTED.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_IS_STARTED.getContent();
				throw TreePruningException.create(userMessage, technicalMessage);
            }
            
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }
    
    public static Connection setConnection(final Connection connection) {
		if(ObjectHelper.isNull(connection)) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
		
		try {
			if(connection.isClosed()) {
				var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
				throw TreePruningException.create(userMessage, technicalMessage);
			}
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return connection;
    }
}
