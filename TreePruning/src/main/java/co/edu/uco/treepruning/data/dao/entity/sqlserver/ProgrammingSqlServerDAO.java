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
import co.edu.uco.treepruning.data.dao.entity.ProgrammingDAO;
import co.edu.uco.treepruning.entity.ProgrammingEntity;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.ProgrammingMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.ProgrammingSql;

public class ProgrammingSqlServerDAO extends SqlConnection implements ProgrammingDAO {

	public ProgrammingSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(ProgrammingEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

		try (var preparedStatement = getConnection().prepareStatement(ProgrammingSql.CREATE)) {

			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getInitialDate());
			preparedStatement.setInt(3, entity.getFrequencyMonths());
			preparedStatement.setInt(4, entity.getQuantity());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_CREATE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_CREATE.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_CREATE_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_CREATE_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}

	}

	@Override
	public List<ProgrammingEntity> findAll() {
		return findByFilter(new ProgrammingEntity());
	}

	@Override
	public List<ProgrammingEntity> findByFilter(ProgrammingEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parameterList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            for (var index = 0; index < parameterList.size(); index++) {
                preparedStatement.setObject(index + 1, parameterList.get(index));
            }

            return executeSentenceFindByFilter(preparedStatement);

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_FIND_BY_FILTER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
	}
	}

	@Override
	public ProgrammingEntity findById(UUID id) {
		return findByFilter(new ProgrammingEntity(id)).stream().findFirst().orElse(new ProgrammingEntity());
	}

	@Override
	public void update(ProgrammingEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(ProgrammingSql.UPDATE)) {

            preparedStatement.setObject(1, entity.getInitialDate());
            preparedStatement.setInt(2, entity.getFrequencyMonths());
            preparedStatement.setInt(3, entity.getQuantity());
            preparedStatement.setObject(4, entity.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_UPDATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_UPDATE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_UPDATE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_UPDATE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }
		
	}

	@Override
	public void delete(UUID id) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        try (var preparedStatement = getConnection().prepareStatement(ProgrammingSql.DELETE)) {

            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_DELETE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_DELETE.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_DELETE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_DELETE_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
		
	}
	}
private String createSentenceFindByFilter(final ProgrammingEntity filterEntity, final List<Object> parametersList) {
		
		var sql = new StringBuilder(ProgrammingSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parametersList, filterEntity);
		
		return sql.toString();
	}
	
private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
        final ProgrammingEntity filterEntity) {

    var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ProgrammingEntity());

    final var conditions = new ArrayList<String>();

    addCondition(conditions, parameterList,
            !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()), "pr.id = ?",
            filterEntityValidated.getId());

    addCondition(conditions, parameterList,
            filterEntityValidated.getInitialDate() != null, "pr.fechaInicial = ?",
            filterEntityValidated.getInitialDate());

    addCondition(conditions, parameterList,
            NumericHelper.getDefaultInt(filterEntityValidated.getFrequencyMonths()) > 0, "pr.frecuenciaMeses = ?",
            filterEntityValidated.getFrequencyMonths());

    addCondition(conditions, parameterList,
            NumericHelper.getDefaultInt(filterEntityValidated.getQuantity()) > 0, "pr.cantidad = ?",
            filterEntityValidated.getQuantity());
		
		
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
	
	private List<ProgrammingEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listProgramming = new ArrayList<ProgrammingEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listProgramming.add(ProgrammingMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_MAPPER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_PROGRAMMING_MAPPER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_PROGRAMMING_MAPPER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listProgramming;
	}

}