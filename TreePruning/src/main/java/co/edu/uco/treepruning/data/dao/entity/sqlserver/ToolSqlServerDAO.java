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
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.ToolDAO;
import co.edu.uco.treepruning.data.dao.entity.mapper.ToolMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.ToolSql;
import co.edu.uco.treepruning.entity.ToolEntity;

public class ToolSqlServerDAO extends SqlConnection implements ToolDAO {
	
	public ToolSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(ToolEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(ToolSql.CREATE)) {
			
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setString(2,  entity.getName());
			preparedStatement.setString(3, entity.getDescription());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public List<ToolEntity> findAll() {
		return findByFilter(new ToolEntity());
	}

	@Override
	public List<ToolEntity> findByFilter(ToolEntity filterEntity) {
		
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {            		
			
			for (int index = 0; index < parameterList.size(); index++) {
				preparedStatement.setObject(index + 1, parameterList.get(index));
			}
			
			return executeSentenceFindByFilter(preparedStatement);
			
		} catch (final TreePruningException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public ToolEntity findById(UUID id) {
		return findByFilter(new ToolEntity (id)).stream().findFirst().orElse(new ToolEntity ());
	}

	@Override
	public void update(ToolEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(ToolSql.UPDATE)) {
			
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setString(2, entity.getDescription());
			preparedStatement.setObject(3, entity.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void delete(UUID entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(ToolSql.DELETE)) {
			
			preparedStatement.setObject(1, entity);
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}
	
private String createSentenceFindByFilter(final ToolEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(ToolSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final ToolEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ToolEntity ());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"t.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"t.name= ?", filterEntityValidated.getName());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getDescription()),
				"t.name= ?", filterEntityValidated.getDescription());
		
		
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
	
	private List<ToolEntity > executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listTool = new ArrayList<ToolEntity >();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listTool.add(ToolMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listTool;
	}

}
