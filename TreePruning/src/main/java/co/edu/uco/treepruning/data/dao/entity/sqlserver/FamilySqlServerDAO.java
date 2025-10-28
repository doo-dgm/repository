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
import co.edu.uco.treepruning.data.dao.entity.FamilyDAO;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.FamilyMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.FamilySql;
import co.edu.uco.treepruning.entity.FamilyEntity;

public class FamilySqlServerDAO extends SqlConnection implements FamilyDAO {

	public FamilySqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(final FamilyEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(FamilySql.CREATE)) {
			
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setString(2, entity.getScientificName());
			preparedStatement.setString(3, entity.getCommonName());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_FAMILY_CREATE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FAMILY_CREATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_FAMILY_CREATE_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FAMILY_CREATE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public List<FamilyEntity> findAll() {
		return findByFilter(new FamilyEntity());
	}

	@Override
	public List<FamilyEntity> findByFilter(final FamilyEntity filterEntity) {
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
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_FAMILY_FIND_BY_FILTER.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_FAMILY_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_FAMILY_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_FAMILY_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public FamilyEntity findById(final UUID id) {
		return findByFilter(new FamilyEntity(id)).stream().findFirst().orElse(null);
	}

	@Override
	public void update(final FamilyEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(FamilySql.UPDATE)) {
			
			preparedStatement.setString(1, entity.getScientificName());
			preparedStatement.setString(2, entity.getCommonName());
			preparedStatement.setObject(3, entity.getId());
			
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_FAMILY_UPDATE.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_FAMILY_UPDATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_FAMILY_UPDATE.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_FAMILY_UPDATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void delete(final UUID entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(FamilySql.DELETE)) {
			
			preparedStatement.setObject(1, entity);
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_FAMILY_DELETE.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_FAMILY_DELETE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_FAMILY_DELETE.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_FAMILY_DELETE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}
	
	private String createSentenceFindByFilter(final FamilyEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(FamilySql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final FamilyEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new FamilyEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"f.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getScientificName()),
				"f.scientificName= ?", filterEntityValidated.getScientificName());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getCommonName()),
				"f.commonName= ?", filterEntityValidated.getCommonName());
		
		
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
	
	private List<FamilyEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listFamily = new ArrayList<FamilyEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listFamily.add(FamilyMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_FAMILY_FIND_BY_FILTER.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_FAMILY_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_FAMILY_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_FAMILY_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listFamily;
	}
}