package co.edu.uco.treepruning.crosscuting.messagescatalog;

public enum MessagesEnum {
	
	USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada vacia", 
			"La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada esta vacio. "
			+ "Por favor intente de nuevo y si el problema persiste, contacto al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada nula", 
			"La conexion requerida para llevar a cabo la operacion contra la base de datos llego nula."),
	
	USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada", 
			"La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada esta cerrada. "
			+ "Por favor intente de nuevo y si el problema persiste, contacto al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada", 
			"La conexion requerida para llevar a cabo la operacion contra la base de datos esta cerrada."),
	
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexion contra la fuente de datos deseado", 
			"Se ha presentado un problema inesperado tratando de validar el estado de la conexion requerida "
			+ "para llevar a cabo la operacion contra la fuente de datos deseada. Por favor intente de nuevo y "
			+ "si el problema persiste, contacto al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validadno si la "
			+ "conexion contra la base de datos estaba abierta", 
			"Se presento un error de tipo SQL.Exception al validar si la conexion contra la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	USER_ERROR_SQL_CONNECTION_NOT_IN_TRANSACTION("Operacion no permitida sin transaccion activa","La operacion que se desea realizar no esta permitida fuera de una transaccion. Por favor inicie una transaccion e intente de nuevo. Si el problema persiste, contacte al administrador de la aplicacion"),
	TECHNICAL_SQL_CONNECTION_NOT_IN_TRANSACTION("Operacion no permitida sin transaccion activa","Se ha intentado ejecutar una operacion que requiere de una transaccion activa, pero la conexion contra la base de datos no esta en modo transaccional (autoCommit == true).");;
	
	
	private String title;
	private String content;
	
	
	private MessagesEnum(final String title, final String content) {
		setTitle(title);
		setContent(content);
	}
	
	public String getTitle() {
		return title;
	}
	
	private void setTitle(final String title) {
		this.title = title == null ? "" : title.trim();
	}
	
	public String getContent() {
		return content;
	}
	private void setContent(String content) {
		this.content = content == null ? "" : content.trim();
	}
	
}
