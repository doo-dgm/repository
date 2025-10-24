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
import co.edu.uco.treepruning.data.dao.entity.RiskDAO;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.RiskMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.RiskSql;
import co.edu.uco.treepruning.entity.RiskEntity;

public class RiskSqlServerDAO extends SqlConnection implements RiskDAO {

	public RiskSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<RiskEntity> findAll() {
		return findByFilter(new RiskEntity());
	}

	@Override
	public List<RiskEntity> findByFilter(final RiskEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		
		try (var preparedStatement = getConnection().prepareStatement(sql)) {
			
			for (var index = 0; index < parameterList.size(); index++) {
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
	public RiskEntity findById(final UUID id) {
		return findByFilter(new RiskEntity(id)).stream().findFirst().orElse(new RiskEntity());
	}
	
	private String createSentenceFindByFilter(final RiskEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(RiskSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final RiskEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new RiskEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"r.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"r.name= ?", filterEntityValidated.getName());
		
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
	
	private List<RiskEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listRisk = new ArrayList<RiskEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listRisk.add(RiskMapper.map(resultSet));
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
		
		return listRisk;
	}

}
