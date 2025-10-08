package co.edu.uco.treepruning.data.dao.entity;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;

public abstract class SqlConnection {
    private Connection connection;

    protected SqlConnection(final Connection connection) {
        setConnection(connection);
    }

    protected Connection getConnection() {
        return connection;
    }

    private void setConnection(final Connection connection) {
        if (ObjectHelper.isNull(connection)) {
            throw TreePruningException.create(
                MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent(),
                MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent()
            );
        }
        try {
            if (connection.isClosed()) {
                throw TreePruningException.create(
                    MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent()
                );
            }
        } catch (final SQLException exception) {
            throw TreePruningException.create(
                exception,
                MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent(),
                MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent()
            );
        }
        this.connection = connection;
    }

    public void validateTransactionActive() {
        if (ObjectHelper.isNull(connection)) {
            throw TreePruningException.create(
                MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent(),
                MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent()
            );
        }
        try {
            if (connection.getAutoCommit()) {
                throw TreePruningException.create(
                    "La conexión no está en modo transaccional.",
                    "El autoCommit está activado, no hay transacción activa."
                );
            }
        } catch (SQLException e) {
            throw TreePruningException.create(
                e,
                MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent(),
                MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent()
            );
        }
    }
}