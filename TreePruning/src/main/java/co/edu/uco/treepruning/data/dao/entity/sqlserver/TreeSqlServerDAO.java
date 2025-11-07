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
import co.edu.uco.treepruning.data.dao.entity.TreeDAO;
import co.edu.uco.treepruning.data.dao.entity.mapper.TreeMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.TreeSql;
import co.edu.uco.treepruning.entity.TreeEntity;

public class TreeSqlServerDAO extends SqlConnection implements TreeDAO {

	public TreeSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(final TreeEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(TreeSql.CREATE)) {
			
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setString(2, entity.getLatitude());
			preparedStatement.setString(3, entity.getLongitude());
			preparedStatement.setObject(4, entity.getFamily().getId());
			preparedStatement.setObject(5, entity.getSector().getId());
			preparedStatement.setObject(6, entity.getProgramming().getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_CREATE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_CREATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_CREATE_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_CREATE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public List<TreeEntity> findAll() {
		return findByFilter(new TreeEntity());
	}

	@Override
	public List<TreeEntity> findByFilter(final TreeEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {            		
			
			for (var index = 0; index < parameterList.size(); index++) {
				preparedStatement.setObject(index + 1, parameterList.get(index));
			}
			
			return executeSentenceFindByFilter(preparedStatement);
			
		} catch (final TreePruningException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_FIND_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public TreeEntity findById(final UUID id) {
		return findByFilter(new TreeEntity (id)).stream().findFirst().orElse(new TreeEntity ());
	}

	@Override
	public void update(final TreeEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(TreeSql.UPDATE)) {
			
			preparedStatement.setString(1, entity.getLatitude());
			preparedStatement.setString(2, entity.getLongitude());
			preparedStatement.setObject(3, entity.getFamily().getId());
			preparedStatement.setObject(4,  entity.getSector().getId());
			preparedStatement.setObject(5, entity.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_UPDATE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_UPDATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_UPDATE_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_UPDATE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void delete(final TreeEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(TreeSql.DELETE)) {
			
			preparedStatement.setObject(1, entity.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_DELETE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_DELETE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_DELETE_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_DELETE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}
	
private String createSentenceFindByFilter(final TreeEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(TreeSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final TreeEntity  filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new TreeEntity ());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"t.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getLatitude()),
				"t.latitude = ?", filterEntityValidated.getLatitude());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getLongitude()),
				"t.longitude = ?", filterEntityValidated.getLongitude());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getFamily().getId()),
				"t.familyId = ?", filterEntityValidated.getFamily().getId());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getSector().getId()),
				"t.sectorId = ?", filterEntityValidated.getSector().getId());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getProgramming().getId()),
				"t.programmingId = ?", filterEntityValidated.getProgramming().getId());
		
		
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
	
	private List<TreeEntity > executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listTree = new ArrayList<TreeEntity >();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listTree.add(TreeMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_FIND_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listTree;
	}

}