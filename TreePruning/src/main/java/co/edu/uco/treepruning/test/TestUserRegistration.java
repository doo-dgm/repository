package co.edu.uco.treepruning.test;

//import co.edu.uco.treepruning.business.facade.impl.PruningFacadeImpl;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;

public class TestUserRegistration {
	public static void main(String[] args) {
		try {
						
			//var facade = new PruningFacadeImpl();
			//facade.schedulePruning();
			
			System.out.println("Gane el semestre");
		} catch (TreePruningException e) {
			System.err.println(e.getUserMessage());
			System.err.println(e.getTechnicalMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
