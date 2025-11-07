package co.edu.uco.treepruning.data.dao.factory.sqlserver;

import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;

import java.io.InputStream;
import java.sql.DriverManager;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.treepruning.data.dao.entity.AdministratorDAO;
import co.edu.uco.treepruning.data.dao.entity.CountryDAO;
import co.edu.uco.treepruning.data.dao.entity.DocumentDAO;
import co.edu.uco.treepruning.data.dao.entity.FamilyDAO;
import co.edu.uco.treepruning.data.dao.entity.ManagerDAO;
import co.edu.uco.treepruning.data.dao.entity.MunicipalityDAO;
import co.edu.uco.treepruning.data.dao.entity.OperatorDAO;
import co.edu.uco.treepruning.data.dao.entity.PQRDAO;
import co.edu.uco.treepruning.data.dao.entity.PersonDAO;
import co.edu.uco.treepruning.data.dao.entity.ProgrammingDAO;
import co.edu.uco.treepruning.data.dao.entity.PruningDAO;
import co.edu.uco.treepruning.data.dao.entity.PruningToolDAO;
import co.edu.uco.treepruning.data.dao.entity.QuadrilleDAO;
import co.edu.uco.treepruning.data.dao.entity.RiskDAO;
import co.edu.uco.treepruning.data.dao.entity.SectorDAO;
import co.edu.uco.treepruning.data.dao.entity.StateDAO;
import co.edu.uco.treepruning.data.dao.entity.StatusDAO;
import co.edu.uco.treepruning.data.dao.entity.ToolDAO;
import co.edu.uco.treepruning.data.dao.entity.TreeDAO;
import co.edu.uco.treepruning.data.dao.entity.TypeDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.AdministratorSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.CountrySqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.DocumentSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.FamilySqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.ManagerSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.MunicipalitySqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.OperatorSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.PQRSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.PersonSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.ProgrammingSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.PruningSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.PruningToolSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.QuadrilleSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.RiskSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.SectorSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.StateSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.StatusSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.ToolSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.TreeSqlServerDAO;
import co.edu.uco.treepruning.data.dao.entity.sqlserver.TypeSqlServerDAO;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class SqlServerDAOFactory extends DAOFactory {
	
	private JdbcTemplate jdbcTemplate;
		
	public SqlServerDAOFactory() {
		openConnection();
		this.jdbcTemplate = new JdbcTemplate();
	}
	
	private static final String PROPERTIES_FILE = "/application.properties";
	
	@Override
	protected void openConnection() {
		
		try (InputStream input = SqlConnectionHelper.class.getResourceAsStream(PROPERTIES_FILE)){
			
			Properties prop = new Properties();
						
            prop.load(input);

            String url = prop.getProperty("spring.datasource.url");
            String username = prop.getProperty("spring.datasource.username");
            String password = prop.getProperty("spring.datasource.password");
            
            this.connection = DriverManager.getConnection(url, username, password);

		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS
	                .getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS
	                .getContent();
			exception.printStackTrace();
			throw TreePruningException.create(exception, userMessage, technicalMessage);
	}
	}

	@Override
	public AdministratorDAO getAdministratorDAO() {
		return new AdministratorSqlServerDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountrySqlServerDAO(connection);
	}

	@Override
	public DocumentDAO getDocumentDAO() {
		return new DocumentSqlServerDAO(connection);
	}

	@Override
	public FamilyDAO getFamilyDAO() {
		return new FamilySqlServerDAO(connection);
	}

	@Override
	public ManagerDAO getManagerDAO() {
		return new ManagerSqlServerDAO(connection);
	}

	@Override
	public MunicipalityDAO getMunicipalityDAO() {
		return new MunicipalitySqlServerDAO(connection);
	}

	@Override
	public OperatorDAO getOperatorDAO() {
		return new OperatorSqlServerDAO(connection);
	}

	@Override
	public PersonDAO getPersonDAO() {
		return new PersonSqlServerDAO(connection);
	}

	@Override
	public PQRDAO getPQRDAO() {
		return new PQRSqlServerDAO(connection);
	}

	@Override
	public ProgrammingDAO getProgrammingDAO() {
		return new ProgrammingSqlServerDAO(connection);
	}

	@Override
	public PruningDAO getPruningDAO() {
		return new PruningSqlServerDAO(connection);
	}

	@Override
	public PruningToolDAO getPrunningToolDAO() {
		return new PruningToolSqlServerDAO (connection);
	}

	@Override
	public QuadrilleDAO getQuadrilleDAO() {
		return new QuadrilleSqlServerDAO(connection);
	}

	@Override
	public RiskDAO getRiskDAO() {
		return new RiskSqlServerDAO(connection);
	}

	@Override
	public SectorDAO getSectorDAO() {
		return new SectorSqlServerDAO(connection);
	}

	@Override
	public StateDAO getStateDAO() {
		return new StateSqlServerDAO(connection);
	}

	@Override
	public StatusDAO getStatusDAO() {
		return new StatusSqlServerDAO(connection);
	}

	@Override
	public ToolDAO getToolDAO() {
		return new ToolSqlServerDAO(connection);
	}

	@Override
	public TreeDAO getTreeDAO() {
		return new TreeSqlServerDAO(connection);
	}

	@Override
	public TypeDAO getTypeDAO() {
		return new TypeSqlServerDAO(connection);
	}

}
