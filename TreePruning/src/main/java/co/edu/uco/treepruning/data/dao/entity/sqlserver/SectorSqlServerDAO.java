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
import co.edu.uco.treepruning.data.dao.entity.SectorDAO;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.SectorMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.SectorSql;
import co.edu.uco.treepruning.entity.SectorEntity;

public class SectorSqlServerDAO extends SqlConnection implements SectorDAO {

	public SectorSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(SectorEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(SectorSql.CREATE)) {
			
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setString(2, entity.getName());
			preparedStatement.setObject(3, entity.getMunicipality().getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_CREATE.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_CREATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_CREATE_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_CREATE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public List<SectorEntity> findAll() {
		return findByFilter(new SectorEntity());
	}

	@Override
	public List<SectorEntity> findByFilter(SectorEntity filterEntity) {
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
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_FIND_BY_FILTER.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public SectorEntity findById(UUID id) {
		return findByFilter(new SectorEntity(id)).stream().findFirst().orElse(new SectorEntity());
	}

	@Override
	public void update(SectorEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(SectorSql.UPDATE)) {
			
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setObject(2, entity.getMunicipality().getId());
			preparedStatement.setObject(3, entity.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_UPDATE.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_UPDATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_UPDATE.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_UPDATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void delete(SectorEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(SectorSql.DELETE)) {
			
			preparedStatement.setObject(1, entity.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_DELETE.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_DELETE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_DELETE.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_DELETE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}
	
	private String createSentenceFindByFilter(final SectorEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(SectorSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final SectorEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new SectorEntity ());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"s.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"s.scientificName= ?", filterEntityValidated.getName());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getMunicipality().getId()),
				"s.commonName= ?", filterEntityValidated.getMunicipality().getId());
		
		
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
	
	private List<SectorEntity > executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listSector = new ArrayList<SectorEntity >();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listSector.add(SectorMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_FIND_BY_FILTER.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_SECTOR_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_SECTOR_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listSector;
	}

}
