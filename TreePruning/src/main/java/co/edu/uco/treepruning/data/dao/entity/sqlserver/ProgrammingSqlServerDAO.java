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
import co.edu.uco.treepruning.data.dao.entity.ProgrammingDAO;
import co.edu.uco.treepruning.entity.ProgrammingEntity;
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.mapper.ProgrammingMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.FamilySql;

public class ProgrammingSqlServerDAO extends SqlConnection implements ProgrammingDAO {

	public ProgrammingSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(ProgrammingEntity entity) {
		try (var preparedStatement = getConnection().prepareStatement(FamilySql.CREATE)) {
			
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setDate(2, entity.getInitialDate());
			preparedStatement.setString(3, entity.get());
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProgrammingEntity findById(UUID id) {
		return findByFilter(new ProgrammingEntity(id)).stream().findFirst().orElse(new ProgrammingEntity());
	}

	@Override
	public void update(ProgrammingEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entity) {
		// TODO Auto-generated method stub
		
	}
	
private String createSentenceFindByFilter(final ProgrammingEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(FamilySql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final ProgrammingEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ProgrammingEntity());
		
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
	
	private List<ProgrammingEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listFamily = new ArrayList<ProgrammingEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listFamily.add(ProgrammingMapper.map(resultSet));
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
		
		return listFamily;
	}

}