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
import co.edu.uco.treepruning.data.dao.entity.StateDAO;
import co.edu.uco.treepruning.data.dao.entity.mapper.StateMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.FamilySql;
import co.edu.uco.treepruning.entity.StateEntity;

public class StateSqlServerDAO extends SqlConnection implements StateDAO {

	public StateSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<StateEntity> findAll() {
		return findByFilter(new StateEntity());
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filterEntity) {
		
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
			var userMessage = MessagesEnum.USER_ERROR_STATE_FIND_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public StateEntity findById(UUID id) {
		return findByFilter(new StateEntity(id)).stream().findFirst().orElse(new StateEntity());
	}
	
	private String createSentenceFindByFilter(final StateEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(FamilySql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final StateEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new StateEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"s.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"s.name= ?", filterEntityValidated.getName());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getCountry().getId()),
				"s.country= ?", filterEntityValidated.getCountry().getId());
		
		
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
	
	private List<StateEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listState = new ArrayList<StateEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listState.add(StateMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_STATE_FIND_BY_FILTER.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listState;
	}

}