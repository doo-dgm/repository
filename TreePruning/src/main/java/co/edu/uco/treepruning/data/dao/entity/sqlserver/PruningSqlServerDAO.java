package co.edu.uco.treepruning.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.treepruning.data.dao.entity.PruningDAO;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.PruningMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.PruningSql;
import co.edu.uco.treepruning.entity.PruningEntity;

public class PruningSqlServerDAO extends SqlConnection implements PruningDAO {

	public PruningSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(final PruningEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try {
			var preparedStatement = this.getConnection().prepareStatement(PruningSql.CREATE);

			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getStatus().getId());
			preparedStatement.setObject(3, entity.getPlannedDate());
			preparedStatement.setObject(4, entity.getExecutedDate());
			preparedStatement.setObject(5, entity.getTree().getId());
			preparedStatement.setObject(6, entity.getQuadrille().getId());
			preparedStatement.setObject(7, entity.getType().getId());
			preparedStatement.setObject(8, (UUIDHelper.getUUIDHelper().isDefaultUUID(entity.getPqr().getId()) ? null : entity.getPqr().getId()));
			preparedStatement.setObject(9, (UUIDHelper.getUUIDHelper().isDefaultUUID(entity.getProgramming().getId()) ? null : entity.getProgramming().getId()));
			preparedStatement.setString(10, entity.getPhotographicRecordPath());
			preparedStatement.setString(11, entity.getObservations());

			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PRUNING_CREATE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PRUNING_CREATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public List<PruningEntity> findAll() {
		return findByFilter(new PruningEntity());
	}

	@Override
	public List<PruningEntity> findByFilter(final PruningEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

			for (var index = 0; index < parameterList.size(); index++) {
				preparedStatement.setObject(index + 1, parameterList.get(index));
			}
			
			return executeSentenceFindByFilter(preparedStatement);
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PRUNING_FIND_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PRUNING_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_PRUNING_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PRUNING_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public PruningEntity findById(final UUID id) {
		
		return findByFilter(new PruningEntity(id)).stream().findFirst().orElse(new PruningEntity());
	}

	@Override
	public void update(final PruningEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try {
			var preparedStatement = this.getConnection().prepareStatement(PruningSql.UPDATE);

			} catch (final SQLException exception) {
				
			}
		
	}

	@Override
	public void delete(final UUID entity) {
		// TODO Auto-generated method stub
		
	}
	
	private String createSentenceFindByFilter(final PruningEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(PruningSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final PruningEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new PruningEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"pru.id = ?", filterEntityValidated.getId());

		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getStatus().getId()),
				"pru.statusId = ?", filterEntityValidated.getStatus().getId());
		
		addCondition(conditions, parameterList, !DateHelper.getDateHelper().isDefaultDate(filterEntityValidated.getPlannedDate()),
				"pru.plannedDate = ?", filterEntityValidated.getPlannedDate());
		
		addCondition(conditions, parameterList, !DateHelper.getDateHelper().isDefaultDate(filterEntityValidated.getExecutedDate()),
				"pru.executedDate = ?", filterEntityValidated.getExecutedDate());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getTree().getId()),
				"pru.treeId = ?", filterEntityValidated.getTree().getId());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getQuadrille().getId()),
				"pru.quadrilleId = ?", filterEntityValidated.getQuadrille().getId());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getType().getId()),
				"pru.typeId = ?", filterEntityValidated.getType().getId());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getPqr().getId()),
				"pru.pqrId = ?", filterEntityValidated.getPqr().getId());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getProgramming().getId()),
				"pru.programmingId = ?", filterEntityValidated.getProgramming().getId());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getPhotographicRecordPath()),
				"pru.photographicReportPath = ?", filterEntityValidated.getPhotographicRecordPath());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getObservations()),
				"pru.observations = ?", filterEntityValidated.getObservations());
		
		
		
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
	
	private List<PruningEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listPruning = new ArrayList<PruningEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listPruning.add(PruningMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PRUNING_FIND_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PRUNING_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_PRUNING_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PRUNING_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listPruning;
	}

}