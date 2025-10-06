package co.edu.uco.treepruning.crosscuting.exception;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;

public class TreePruningException extends RuntimeException {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -433023700129543247L;
	private Throwable rootException;
	private String userMessage;
	private String technicalMessage;
	
	public TreePruningException(final Throwable rootException, final String userMessage, final String technicalMessage) {
		setRootException(rootException);
		setUserMessage(userMessage);
		setTechnicalMessage(technicalMessage);
	}
	
	public static TreePruningException create(final String userMessage) {
		return new TreePruningException(new Exception(), userMessage, userMessage);
	}
	
	public static TreePruningException create(final String userMessage, 
			final String technicalMessage) {
		return new TreePruningException(new Exception(), userMessage, technicalMessage);
	}
	
	public static TreePruningException create(final Throwable rootException, 
			final String userMessage, final String technicalMessage) {
		return new TreePruningException(rootException, userMessage, technicalMessage);
	}
	
	public Throwable getRootException() {
		return rootException;
	}
	
	private void setRootException(final Throwable rootException) {
		this.rootException = ObjectHelper.getDefault(rootException, new Exception());
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	
	private void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.getDefaultWithTrim(userMessage);
	}
	
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	
	private void setTechnicalMessage(final String technicalMessage) {
		this.technicalMessage = TextHelper.getDefaultWithTrim(technicalMessage);
	}

}
