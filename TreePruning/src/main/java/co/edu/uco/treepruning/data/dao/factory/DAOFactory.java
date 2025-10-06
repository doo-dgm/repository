package co.edu.uco.treepruning.data.dao.factory;

import java.sql.ConnectionBuilder;
import co.edu.uco.treepruning.data.dao.entity.*;

public abstract class DAOFactory {
	protected ConnectionBuilder connection;
	protected FactoryEnum factory = FactoryEnum.SQLSERVER;
	
	public static DAOFactory getFactory() {
		return null;
	}
	
	public abstract AdministratorDAO getAdministratorDAO();
	public abstract CityDAO getCityDAO();
	public abstract CountryDAO getCountryDAO();
	public abstract DocumentDAO getDocumentDAO();
	public abstract FamilyDAO getFamilyDAO();
	public abstract ManagerDAO getManagerDAO();
	public abstract MunicipalityDAO getMunicipalityDAO();
	public abstract OperatorDAO getOperatorDAO();
	public abstract PersonDAO getPersonDAO();
	public abstract PQRDAO getPQRDAO();
	public abstract ProgrammingDAO getProgrammingDAO();
	public abstract PruningDAO getPruningDAO();
	public abstract PruningToolDAO getPrunningToolDAO();
	public abstract QuadrilleDAO getQuadrilleDAO();
	public abstract RiskDAO getRiskDAO();
	public abstract SectorDAO getSectorDAO();
	public abstract StateDAO getStateDAO();
	public abstract StatusDAO getStatusDAO();
	public abstract ToolDAO getToolDAO();
	public abstract TreeDAO getTreeDAO();
	public abstract TypeDAO getTypeDAO();
	
	protected final void openConnection() {
		
	}
	
	protected final void initTransaction() {
		
	}
	
	protected final void commitTransaction() {
		
	}
	
	protected final void rollbackTransaction() {
		
	}
	
	protected final void closeConnection() {
		
	}
	
}
