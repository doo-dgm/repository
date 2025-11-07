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
import co.edu.uco.treepruning.data.dao.entity.SqlConnection;
import co.edu.uco.treepruning.data.dao.entity.TypeDAO;
import co.edu.uco.treepruning.data.dao.entity.mapper.TypeMapper;
import co.edu.uco.treepruning.data.dao.entity.sql.TypeSql;
import co.edu.uco.treepruning.entity.TypeEntity;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;

public class TypeSqlServerDAO extends SqlConnection implements TypeDAO {

	public TypeSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<TypeEntity> findAll() {
		
		return findByFilter(new TypeEntity());
	}

	@Override
	public List<TypeEntity> findByFilter(final TypeEntity filterEntity) {
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
			
			for (int index = 0; index < parameterList.size(); index++) {
				preparedStatement.setObject(index + 1, parameterList.get(index));
			}
			
			return executeSentenceFindByFilter(preparedStatement);
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_FIND_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_FIND_BY_FILTER.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public TypeEntity findById(final UUID id) {
		return findByFilter(new TypeEntity(id)).stream().findFirst().orElse(new TypeEntity());
	}
	
	private String createSentenceFindByFilter(final TypeEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(TypeSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final TypeEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new TypeEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"t.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"t.name= ?", filterEntityValidated.getName());		
		
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
	
	private List<TypeEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listFamily = new ArrayList<TypeEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listFamily.add(TypeMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_FIND_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_FIND_BY_FILTER.getContent();
			exception.printStackTrace();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_TYPE_FIND_BY_FILTER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TYPE_FIND_BY_FILTER_UNEXPECTED.getContent();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
		}
		
		return listFamily;
	}

}