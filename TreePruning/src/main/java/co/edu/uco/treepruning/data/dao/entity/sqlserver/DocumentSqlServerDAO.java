package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.DocumentMapper;
import co.edu.uco.treepruning.data.dao.entity.mapper.FamilyMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.DocumentSql;
import co.edu.uco.treepruning.data.dao.entity.DocumentDAO;
import co.edu.uco.treepruning.entity.DocumentEntity;
import co.edu.uco.treepruning.entity.FamilyEntity;

public final class DocumentSqlServerDAO extends SqlConnection implements DocumentDAO {

    public DocumentSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public DocumentEntity findById(UUID id) {
        return findByFilter(new DocumentEntity(id)).stream().findFirst().orElse(null);
    }

    @Override
    public List<DocumentEntity> findAll() {
        return findByFilter(new DocumentEntity());
    }

<<<<<<< HEAD
    @Override
    public List<DocumentEntity> findByFilter(final DocumentEntity filterEntity) {
        var parametersList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parametersList);
=======
	@Override
	public DocumentEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> 46d5ca4b51d131dff7004937acc2d80a938c46e1

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
            for (int index = 0; index < parametersList.size(); index++) {
                preparedStatement.setObject(index + 1, parametersList.get(index));
            }

            return executeSentenceFindByFilter(preparedStatement);
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final DocumentEntity filterEntity, final List<Object> parametersList) {
        final var sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(" d.id, ");
        sql.append(" d.nombre, ");
        sql.append(" d.codigo ");
        sql.append("FROM Document AS d ");

        createWhereClauseFindByFilter(sql, parametersList, filterEntity);

        return sql.toString();
    }

    private String createWhereClauseFindByFilter(final DocumentEntity filterEntity, final List<Object> parametersList)
    {
        var sql = new StringBuilder(DocumentSql.FIND_BY_FILTER); 
        createWhereClauseFindByFilter(sql, parametersList, filterEntity);
		
		return sql.toString();
}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList, final DocumentEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new DocumentEntity());
		
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parametersList,!UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "d.id = ?",filterEntityValidated.getId());
        addCondition(conditions, parametersList,!TextHelper.isEmptyWithTrim(filterEntityValidated.getName()), "d.nombre = ?)",filterEntityValidated.getName());
        addCondition(conditions, parametersList,!TextHelper.isEmptyWithTrim(filterEntityValidated.getCode()), "d.codigo = ?)",filterEntityValidated.getCode());

        if (!conditions.isEmpty()) {
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", conditions));
        }
    }

    private void addCondition(final List<String> conditions, final List<Object> parametersList,
            final boolean condition, final String clause, final Object value) {
        if (condition) {
            conditions.add(clause);
            parametersList.add(value);
        }
    }

    private List<DocumentEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listDocument = new ArrayList<DocumentEntity>();

        try (var resultset = preparedStatement.executeQuery()) {
        	try (var resultSet = preparedStatement.executeQuery()) {
    			while (resultSet.next()) {
    				listDocument.add(DocumentMapper.map(resultSet));
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return listDocument;
    }

   }
}

