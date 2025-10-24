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
import co.edu.uco.treepruning.data.dao.entity.QuadrilleDAO;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.QuadrilleMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.QuadrilleSql;
import co.edu.uco.treepruning.entity.QuadrilleEntity;

public class QuadrilleSqlServerDAO extends SqlConnection implements QuadrilleDAO {

	public QuadrilleSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(final QuadrilleEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(QuadrilleSql.CREATE)) {
			
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setString(2, entity.getQuadrilleName());
			preparedStatement.setObject(3,  entity.getManager().getId());
			
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
	public List<QuadrilleEntity> findAll() {
		return findByFilter(new QuadrilleEntity());
	}

	@Override
	public List<QuadrilleEntity> findByFilter(final QuadrilleEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {            		
			
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
	public QuadrilleEntity findById(final UUID id) {
		return findByFilter(new QuadrilleEntity(id)).stream().findFirst().orElse(new QuadrilleEntity());
	}

	@Override
	public void update(final QuadrilleEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(QuadrilleSql.UPDATE)) {
			
			preparedStatement.setString(1, entity.getQuadrilleName());
			preparedStatement.setObject(2,  entity.getManager().getId());
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
	public void delete(final UUID entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(QuadrilleSql.DELETE)) {
			
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
	
	private String createSentenceFindByFilter(final QuadrilleEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(QuadrilleSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final QuadrilleEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new QuadrilleEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"q.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getQuadrilleName()),
				"q.name= ?", filterEntityValidated.getQuadrilleName());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getManager().getId()),
				"q.manager= ?", filterEntityValidated.getManager().getId());
		
		
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
	
	private List<QuadrilleEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listQuadrille = new ArrayList<QuadrilleEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listQuadrille.add(QuadrilleMapper.map(resultSet));
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
		
		return listQuadrille;
	}

}
