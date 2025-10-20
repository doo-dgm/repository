package co.edu.uco.treepruning.data.dao.factory.sqlserver;

import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import java.io.InputStream;
import java.sql.DriverManager;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
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
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;

public class SqlServerDAOFactory extends DAOFactory {
	
	private JdbcTemplate jdbcTemplate;
	
	public SqlServerDAOFactory() {
		openConnection();
		jdbcTemplate = new JdbcTemplate();
	}
	
	private static final String PROPERTIES_FILE = "/application.properties";
	
	@Override
	protected void openConnection() {
		
		try (InputStream input = SqlConnectionHelper.class.getResourceAsStream(PROPERTIES_FILE)){
			//this.connection = SqlConnectionHelper.getConnection();
			Properties prop = new Properties();
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
            prop.load(input);

            String url = prop.getProperty("spring.datasource.url");
            String username = prop.getProperty("spring.datasource.username");
            String password = prop.getProperty("spring.datasource.password");

            this.connection = DriverManager.getConnection(url, username, password);
		} catch (final Exception exception) {
			var userMessage = "Error en la conexión a la base de datos.";
			var technicalMessage = "Error en la conexión a la base de datos. Detalles técnicos: " + exception.getMessage();
			throw TreePruningException.create(userMessage, technicalMessage);
		}
	}

	@Override
	public AdministratorDAO getAdministratorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryDAO getCountryDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentDAO getDocumentDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamilyDAO getFamilyDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagerDAO getManagerDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MunicipalityDAO getMunicipalityDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperatorDAO getOperatorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDAO getPersonDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PQRDAO getPQRDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProgrammingDAO getProgrammingDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruningDAO getPruningDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruningToolDAO getPrunningToolDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuadrilleDAO getQuadrilleDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiskDAO getRiskDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SectorDAO getSectorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateDAO getStateDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDAO getStatusDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToolDAO getToolDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeDAO getTreeDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDAO getTypeDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
