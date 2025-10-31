package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.entity.PQRDAO;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.PQRMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.PQRSql;
import co.edu.uco.treepruning.entity.PQREntity;

public class PQRSqlServerDAO extends SqlConnection implements PQRDAO {

	public PQRSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(final PQREntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

		try (var preparedStatement = getConnection().prepareStatement(PQRSql.CREATE)) {

			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getDate());
			preparedStatement.setObject(3, entity.getStatus().getId());
			preparedStatement.setObject(4, entity.getRisk().getId());
			preparedStatement.setObject(5, entity.getSector().getId());
			preparedStatement.setObject(6, entity.getPerson().getId());
			preparedStatement.setString(7, entity.getPhotographicRecordPath());
						
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_CREATE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_CREATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_CREATE_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_CREATE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public List<PQREntity> findAll() {
		return findByFilter(new PQREntity());
	}

	@Override
	public List<PQREntity> findByFilter(final PQREntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {            		
		
			for (var index = 0; index < parameterList.size(); index++) {
				preparedStatement.setObject(index + 1, parameterList.get(index));
			}
			
			return executeSentenceFindByFilter(preparedStatement);
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_FIND_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public PQREntity findById(final UUID id) {
		return findByFilter(new PQREntity(id)).stream().findFirst().orElse(new PQREntity());
	}

	@Override
	public void update(final PQREntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(PQRSql.UPDATE)) {
			
			preparedStatement.setObject(1, entity.getDate());
			preparedStatement.setObject(2, entity.getStatus().getId());
			preparedStatement.setObject(3, entity.getRisk().getId());
			preparedStatement.setObject(4, entity.getSector().getId());
			preparedStatement.setObject(5, entity.getPerson().getId());
			preparedStatement.setString(6, entity.getPhotographicRecordPath());
			preparedStatement.setObject(7, entity.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_UPDATE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_UPDATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_UPDATE_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_UPDATE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void delete(final PQREntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = getConnection().prepareStatement(PQRSql.DELETE)) {
			
			preparedStatement.setObject(1, entity.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_DELETE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_DELETE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_DELETE_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_DELETE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
	}
	
private String createSentenceFindByFilter(final PQREntity filterEntity, final List<Object> parametersList) {
		
		var sql = new StringBuilder(PQRSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parametersList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
        final PQREntity filterEntity) {

    var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new PQREntity());

    final var conditions = new ArrayList<String>();

    addCondition(conditions, parameterList,
            !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "pr.id = ?",
            filterEntityValidated.getId());

    addCondition(conditions, parameterList,
            filterEntityValidated.getDate() != null, "p.date = ?",
            filterEntityValidated.getDate());

    addCondition(conditions, parameterList,
            !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getStatus().getId()), "p.status = ?",
            filterEntityValidated.getStatus().getId());
    
    addCondition(conditions, parameterList,
            !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getRisk().getId()), "p.risk = ?",
            filterEntityValidated.getRisk().getId());
    
    addCondition(conditions, parameterList,
            !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getSector().getId()), "p.sector = ?",
            filterEntityValidated.getSector().getId());
    
    addCondition(conditions, parameterList,
            !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getPerson().getId()), "p.person = ?",
            filterEntityValidated.getPerson().getId());

    addCondition(conditions, parameterList,
            !TextHelper.isEmptyWithTrim(filterEntityValidated.getPhotographicRecordPath()), "p.photoRecord = ?",
            filterEntityValidated.getPhotographicRecordPath());
		
		
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
	
	private List<PQREntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listPqr = new ArrayList<PQREntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listPqr.add(PQRMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_MAPPER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_PQR_MAPPER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PQR_MAPPER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listPqr;
	}


}