package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.StatusDAO;
import co.edu.uco.treepruning.data.dao.entity.mapper.StatusMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.StatusSql;
import co.edu.uco.treepruning.entity.StatusEntity;

public class StatusSqlServerDAO extends SqlConnection implements StatusDAO {

	public StatusSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<StatusEntity> findAll() {
		return findByFilter(new StatusEntity());
	}

	@Override
	public List<StatusEntity> findByFilter(StatusEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		
		try (var preparedStatement = getConnection().prepareStatement(sql)) {
			
			for (int index = 0; index < parameterList.size(); index++) {
				preparedStatement.setObject(index + 1, parameterList.get(index));
			}
			
			return executeSentenceFindByFilter(preparedStatement);
			
		} catch (final TreePruningException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_EXECUTE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_EXECUTE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_EXECUTE_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_EXECUTE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public StatusEntity findById(UUID id) { 
		return findByFilter(new StatusEntity(id)).stream().findFirst().orElse(new StatusEntity());
	}
	
	private String createSentenceFindByFilter(final StatusEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(StatusSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final StatusEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new StatusEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"s.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"s.name= ?", filterEntityValidated.getName());
		
		
		if (!conditions.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", conditions));
		}
	}
	
	private void addCondition(final List<String> conditions, final List<Object> parameterList,
			final boolean condition, final String clause, final Object value) {
		if (condition) {
			conditions.add(clause);
			parameterList.add(value);
		}
	}
	
	private List<StatusEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listStatus = new ArrayList<StatusEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listStatus.add(StatusMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_STATUS_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATUS_MAPPER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_STATUS_MAPPER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATUS_MAPPER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listStatus;
	}

}