package co.edu.uco.treepruning.crosscuting.messagescatalog;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;

public enum MessagesEnum {

	USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada vacia", 
			"La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada esta vacio. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada nula", 
			"La conexion requerida para llevar a cabo la operacion contra la base de datos llego nula."),
	
	USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada", 
			"La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada esta cerrada. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada", 
			"La conexion requerida para llevar a cabo la operacion contra la base de datos esta cerrada."),
	
	// Factory / Transaction / Connection messages used by DAOFactory
	USER_ERROR_FACTORY_NOT_INITIALIZED("Factory no inicializado",
		"La fabrica de acceso a datos requerida no ha sido inicializada. Verifique la configuración del sistema y contacte al administrador si el problema persiste."),
	TECHNICAL_ERROR_FACTORY_NOT_INITIALIZED("Factory no inicializado (técnico)",
		"La configuración del FactoryEnum o la inicialización de la fábrica devolvió null. Revise la inicialización de DAOFactory y la configuración de la aplicación para más detalles."),

	USER_ERROR_SQL_TRANSACTION_BEGIN("No fue posible iniciar la transacción",
		"Se presentó un problema al intentar iniciar la transacción en la base de datos. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_SQL_TRANSACTION_BEGIN("Error técnico iniciando transacción SQL",
		"Se produjo una SQLException al intentar deshabilitar el auto-commit (connection.setAutoCommit(false)). Revise la traza de errores y el estado de la conexión para más detalle."),

	USER_ERROR_SQL_TRANSACTION_COMMIT("No fue posible confirmar la transacción",
		"Se presentó un problema al intentar confirmar la transacción. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_SQL_TRANSACTION_COMMIT("Error técnico confirmando transacción SQL",
		"Se produjo una SQLException al ejecutar connection.commit(). Revise la traza de errores y el estado de la conexión para más detalles."),

	USER_ERROR_SQL_TRANSACTION_ROLLBACK("No fue posible deshacer la transacción",
		"Se presentó un problema al intentar revertir la transacción. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_SQL_TRANSACTION_ROLLBACK("Error técnico revirtiendo transacción SQL",
		"Se produjo una SQLException al ejecutar connection.rollback(). Revise la traza de errores y el estado de la conexión para más detalles."),

	USER_ERROR_SQL_CONNECTION_CLOSE("No fue posible cerrar la conexión",
		"Se presentó un problema al intentar cerrar la conexión a la base de datos. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_SQL_CONNECTION_CLOSE("Error técnico cerrando la conexión SQL",
		"Se produjo una SQLException al ejecutar connection.close(). Revise la traza de errores y el estado de la conexión para más detalles."),

	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexion contra la fuente de datos deseada", 
			"Se ha presentado un problema inesperado tratando de validar el estado de la conexion requerida "
			+ "para llevar a cabo la operacion contra la fuente de datos deseada. Por favor intente de nuevo y "
			+ "si el problema persiste, contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexion contra la base de datos estaba abierta", 
			"Se presento un error de tipo SQL.Exception al validar si la conexion contra la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS("Problema inesperado validando el estado de la transaccion", 
			"Se ha presentado un problema inesperado tratando de validar el estado de la transaccion. Por favor intente de nuevo y "
			+ "si el problema persiste, contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS("Error inesperado validando si la transaccion estaba iniciada", 
			"Se presento un error de tipo SQL.Exception al validar si la transaccion estaba iniciada. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."), 
	
	USER_ERROR_TRANSACTION_IS_NOT_STARTED ("Transaccion no iniciada", 
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de informacion deseada no ha sido iniciada. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED ("Transaccion no iniciada",
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de informacion deseada no ha sido iniciada. "
					+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion"), 
	USER_ERROR_TRANSACTION_IS_STARTED("Transaccion iniciada", 
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de informacion deseada ha sido iniciada. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_TRANSACTION_IS_STARTED ("Transaccion iniciada",
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de informacion deseada ha sido iniciada. "
				+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion"), 
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_CLOSED("Transaccion cerrada",
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de datos se encuentra cerrada. "
			+ "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_CLOSED("Error validando estado cerrado de transaccion",
			"Se presento un error al validar si la transaccion estaba cerrada. Revise la traza de errores para mas detalles."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_NOT_OPEN("Transaccion no iniciada",
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de datos no se encuentra iniciada. "
			+ "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_NOT_OPEN("Error validando estado de transaccion no iniciada",
			"Se presento un error al validar si la transaccion estaba iniciada. Revise la traza de errores para mas detalles."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN("Transaccion ya iniciada",
			"La transaccion ya se encuentra iniciada y no puede iniciarse nuevamente. "
			+ "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN("Error validando estado de transaccion ya iniciada",
			"Se presento un error al validar que la transaccion no estuviera iniciada antes de la operacion. Revise la traza de errores para mas detalles."),

	// DAO - Type
	USER_ERROR_TYPE_FIND_BY_FILTER("Ocurrió un problema al ejecutar la consulta de tipos", 
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_TYPE_FIND_BY_FILTER("Error SQL ejecutando TypeDAO.findByFilter",
		"Error SQL ejecutando el query en TypeSqlServerDAO.findByFilter. Revise la traza de errores para mas detalles."),
	USER_ERROR_TYPE_FIND_BY_FILTER_UNEXPECTED("Ocurrió un problema INESPERADO al ejecutar la consulta de tipos",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_TYPE_FIND_BY_FILTER_UNEXPECTED("Error inesperado ejecutando TypeDAO.findByFilter",
		"Error inesperado ejecutando el query en TypeSqlServerDAO.findByFilter. Revise la traza de errores para mas detalles."),

	// Mapper - Type
	USER_ERROR_TYPE_MAPPER("Ocurrió un problema al mapear el tipo desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir TypeEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_TYPE_MAPPER("Error técnico mapeando TypeMapper",
		"Se presentó un error técnico al mapear el ResultSet a TypeEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_TYPE_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el tipo",
		"Se presentó un error inesperado al mapear el ResultSet a TypeEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_TYPE_MAPPER_UNEXPECTED("Error inesperado mapeando TypeMapper",
		"Se presentó un error inesperado al mapear el ResultSet a TypeEntity. Revise la traza de errores para más detalle."),

	// Mapper - Administrator
	USER_ERROR_ADMINISTRATOR_MAPPER("Ocurrió un problema al mapear el administrador desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir AdministratorEntity. Por favor verifique el esquema de la consulta y los nombres de las columnas."),
	TECHNICAL_ERROR_ADMINISTRATOR_MAPPER("Error SQL mapeando AdministratorMapper",
		"Se presentó un error técnico al mapear el ResultSet a AdministratorEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_ADMINISTRATOR_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el administrador",
		"Se presentó un error inesperado al mapear el ResultSet a AdministratorEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_ADMINISTRATOR_MAPPER_UNEXPECTED("Error inesperado mapeando AdministratorMapper",
		"Se presentó un error inesperado al mapear el ResultSet a AdministratorEntity. Revise la traza de errores para más detalle."),

	// Mapper - Country
	USER_ERROR_COUNTRY_MAPPER("Ocurrió un problema al mapear el país desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir CountryEntity. Por favor verifique el esquema de la consulta y los nombres de las columnas."),
	TECHNICAL_ERROR_COUNTRY_MAPPER("Error técnico mapeando CountryMapper",
		"Se presentó un error técnico al mapear el ResultSet a CountryEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_COUNTRY_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el país",
		"Se presentó un error inesperado al mapear el ResultSet a CountryEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_COUNTRY_MAPPER_UNEXPECTED("Error inesperado mapeando CountryMapper",
		"Se presentó un error inesperado al mapear el ResultSet a CountryEntity. Revise la traza de errores para más detalle."),

	// DAO - Country
	USER_ERROR_COUNTRY_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar paises. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de paises en la base de datos."),
	TECHNICAL_ERROR_COUNTRY_FIND_BY_FILTER("Error técnico consultando paises",
		"Error SQL ejecutando CountrySqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_COUNTRY_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando paises",
		"Se produjo una excepción inesperada al consultar paises. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_COUNTRY_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando paises",
		"Excepción inesperada al ejecutar CountrySqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// Mapper - Document
	USER_ERROR_DOCUMENT_MAPPER("Ocurrió un problema al mapear el documento desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir DocumentEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_DOCUMENT_MAPPER("Error técnico mapeando DocumentMapper",
		"Se presentó un error técnico al mapear el ResultSet a DocumentEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_DOCUMENT_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el documento",
		"Se presentó un error inesperado al mapear el ResultSet a DocumentEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_DOCUMENT_MAPPER_UNEXPECTED("Error inesperado mapeando DocumentMapper",
		"Se presentó un error inesperado al mapear el ResultSet a DocumentEntity. Revise la traza de errores para más detalle."),

	// Mapper - Family
	USER_ERROR_FAMILY_MAPPER("Ocurrió un problema al mapear la familia desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir FamilyEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_FAMILY_MAPPER("Error técnico mapeando FamilyMapper",
		"Se presentó un error técnico al mapear el ResultSet a FamilyEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_FAMILY_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la familia",
		"Se presentó un error inesperado al mapear el ResultSet a FamilyEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_FAMILY_MAPPER_UNEXPECTED("Error inesperado mapeando FamilyMapper",
		"Se presentó un error inesperado al mapear el ResultSet a FamilyEntity. Revise la traza de errores para más detalle."),

	// DAO - Family
	USER_ERROR_FAMILY_CREATE("Se ha presentado un problema tratando de registrar la familia. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Family en la base de datos."),
	TECHNICAL_ERROR_FAMILY_CREATE("Error técnico creando Family",
		"Error SQL ejecutando el proceso de creación de Family. Revise la traza de errores para más detalles."),
	USER_ERROR_FAMILY_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando la familia",
		"Se produjo una excepción inesperada al crear la familia. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_FAMILY_CREATE_UNEXPECTED("Error inesperado creando Family",
		"Excepción inesperada al ejecutar la creación de Family. Revise la traza de errores para más detalles."),

	USER_ERROR_FAMILY_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar familias. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de familias en la base de datos."),
	TECHNICAL_ERROR_FAMILY_FIND_BY_FILTER("Error técnico consultando familias",
		"Error SQL ejecutando FamilySqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_FAMILY_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando familias",
		"Se produjo una excepción inesperada al consultar familias. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_FAMILY_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando familias",
		"Excepción inesperada al ejecutar FamilySqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	USER_ERROR_FAMILY_UPDATE("Se ha presentado un problema tratando de modificar la familia. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de Family en la base de datos."),
	TECHNICAL_ERROR_FAMILY_UPDATE("Error técnico modificando Family",
		"Error SQL ejecutando la actualización de Family. Revise la traza de errores para más detalles."),
	USER_ERROR_FAMILY_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar la familia",
		"Se produjo una excepción inesperada al intentar actualizar la familia. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_FAMILY_UPDATE_UNEXPECTED("Error inesperado modificando Family",
		"Excepción inesperada al ejecutar la actualización de Family. Revise la traza de errores para más detalles."),

	USER_ERROR_FAMILY_DELETE("Se ha presentado un problema tratando de eliminar la familia. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de Family en la base de datos."),
	TECHNICAL_ERROR_FAMILY_DELETE("Error técnico eliminando Family",
		"Error SQL ejecutando la eliminación de Family. Revise la traza de errores para más detalles."),
	USER_ERROR_FAMILY_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando la familia",
		"Se produjo una excepción inesperada al eliminar la familia. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_FAMILY_DELETE_UNEXPECTED("Error inesperado eliminando Family",
		"Excepción inesperada al ejecutar la eliminación de Family. Revise la traza de errores para más detalles."),

	// Mapper - Manager
	USER_ERROR_MANAGER_MAPPER("Ocurrió un problema al mapear el manager desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir ManagerEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_MANAGER_MAPPER("Error técnico mapeando ManagerMapper",
		"Se presentó un error técnico al mapear el ResultSet a ManagerEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_MANAGER_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el manager",
		"Se presentó un error inesperado al mapear el ResultSet a ManagerEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_MANAGER_MAPPER_UNEXPECTED("Error inesperado mapeando ManagerMapper",
		"Se presentó un error inesperado al mapear el ResultSet a ManagerEntity. Revise la traza de errores para más detalle."),

	// Mapper - Municipality
	USER_ERROR_MUNICIPALITY_MAPPER("Ocurrió un problema al mapear el municipio desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir MunicipalityEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_MUNICIPALITY_MAPPER("Error técnico mapeando MunicipalityMapper",
		"Se presentó un error técnico al mapear el ResultSet a MunicipalityEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_MUNICIPALITY_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el municipio",
		"Se presentó un error inesperado al mapear el ResultSet a MunicipalityEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_MUNICIPALITY_MAPPER_UNEXPECTED("Error inesperado mapeando MunicipalityMapper",
		"Se presentó un error inesperado al mapear el ResultSet a MunicipalityEntity. Revise la traza de errores para más detalle."),

	// Mapper - Operator
	USER_ERROR_OPERATOR_MAPPER("Ocurrió un problema al mapear el operador desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir OperatorEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_OPERATOR_MAPPER("Error técnico mapeando OperatorMapper",
		"Se presentó un error técnico al mapear el ResultSet a OperatorEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_OPERATOR_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el operador",
		"Se presentó un error inesperado al mapear el ResultSet a OperatorEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_OPERATOR_MAPPER_UNEXPECTED("Error inesperado mapeando OperatorMapper",
		"Se presentó un error inesperado al mapear el ResultSet a OperatorEntity. Revise la traza de errores para más detalle."),

	// Mapper - Person
	USER_ERROR_PERSON_MAPPER("Ocurrió un problema al mapear la persona desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir PersonEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_PERSON_MAPPER("Error técnico mapeando PersonMapper",
		"Se presentó un error técnico al mapear el ResultSet a PersonEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_PERSON_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la persona",
		"Se presentó un error inesperado al mapear el ResultSet a PersonEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_PERSON_MAPPER_UNEXPECTED("Error inesperado mapeando PersonMapper",
		"Se presentó un error inesperado al mapear el ResultSet a PersonEntity. Revise la traza de errores para más detalle."),

	// Mapper - PQR
	USER_ERROR_PQR_MAPPER("Ocurrió un problema al mapear la PQR desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir PQREntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_PQR_MAPPER("Error técnico mapeando PQRMapper",
		"Se presentó un error técnico al mapear el ResultSet a PQREntity. Revise la traza de errores para más detalle."),
	USER_ERROR_PQR_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la PQR",
		"Se presentó un error inesperado al mapear el ResultSet a PQREntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_PQR_MAPPER_UNEXPECTED("Error inesperado mapeando PQRMapper",
		"Se presentó un error inesperado al mapear el ResultSet a PQREntity. Revise la traza de errores para más detalle."),

	// Mapper - Programming
	USER_ERROR_PROGRAMMING_MAPPER("Ocurrió un problema al mapear la programación desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir ProgrammingEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_PROGRAMMING_MAPPER("Error técnico mapeando ProgrammingMapper",
		"Se presentó un error técnico al mapear el ResultSet a ProgrammingEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_PROGRAMMING_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la programación",
		"Se presentó un error inesperado al mapear el ResultSet a ProgrammingEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_PROGRAMMING_MAPPER_UNEXPECTED("Error inesperado mapeando ProgrammingMapper",
		"Se presentó un error inesperado al mapear el ResultSet a ProgrammingEntity. Revise la traza de errores para más detalle."),

	// DAO - Programming (create, find, update, delete)
	USER_ERROR_PROGRAMMING_CREATE("Se ha presentado un problema tratando de registrar la programación. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Programming en la base de datos."),
	TECHNICAL_ERROR_PROGRAMMING_CREATE("Error técnico creando Programming",
		"Error SQL ejecutando ProgrammingSqlServerDAO.create. Revise la traza de errores para más detalles."),
	USER_ERROR_PROGRAMMING_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando la programación",
		"Se produjo una excepción inesperada al crear la programación. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PROGRAMMING_CREATE_UNEXPECTED("Error inesperado creando Programming",
		"Excepción inesperada al ejecutar la creación de Programming. Revise la traza de errores para más detalles."),

	USER_ERROR_PROGRAMMING_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar programaciones. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de Programming en la base de datos."),
	TECHNICAL_ERROR_PROGRAMMING_FIND_BY_FILTER("Error técnico consultando Programming",
		"Error SQL ejecutando ProgrammingSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_PROGRAMMING_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando programaciones",
		"Se produjo una excepción inesperada al consultar programaciones. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PROGRAMMING_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando Programming",
		"Excepción inesperada al ejecutar ProgrammingSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	USER_ERROR_PROGRAMMING_UPDATE("Se ha presentado un problema tratando de modificar la programación. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"No se pudo actualizar la programación en la base de datos. Verifique que el id exista, los datos enviados y que la transacción esté activa."),
	TECHNICAL_ERROR_PROGRAMMING_UPDATE("Error técnico modificando Programming",
		"SQLException ejecutando ProgrammingSqlServerDAO.update. Revise la sentencia SQL, parámetros y el estado de la conexión/transacción."),
	USER_ERROR_PROGRAMMING_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar la programación",
		"Se produjo una excepción inesperada al intentar actualizar la programación. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PROGRAMMING_UPDATE_UNEXPECTED("Error inesperado modificando Programming",
		"Excepción inesperada al ejecutar la actualización de Programming. Revise la traza completa de la excepción para identificar la causa."),

	USER_ERROR_PROGRAMMING_DELETE("Se ha presentado un problema tratando de eliminar la programación. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"No se pudo eliminar la programación en la base de datos. Verifique que el id exista y que no existan restricciones que impidan la eliminación (FKs)."),
	TECHNICAL_ERROR_PROGRAMMING_DELETE("Error técnico eliminando Programming",
		"SQLException ejecutando ProgrammingSqlServerDAO.delete. Revise la sentencia SQL, parámetros y restricciones de integridad referencial que puedan bloquear la operación."),
	USER_ERROR_PROGRAMMING_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando la programación",
		"Se produjo una excepción inesperada al eliminar la programación. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PROGRAMMING_DELETE_UNEXPECTED("Error inesperado eliminando Programming",
		"Excepción inesperada al ejecutar la eliminación de Programming. Revise la traza completa de la excepción para identificar la causa."),

	// Mapper - Pruning
	USER_ERROR_PRUNING_MAPPER("Ocurrió un problema al mapear la poda desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir PruningEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_PRUNING_MAPPER("Error técnico mapeando PruningMapper",
		"Se presentó un error técnico al mapear el ResultSet a PruningEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_PRUNING_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la poda",
		"Se presentó un error inesperado al mapear el ResultSet a PruningEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_PRUNING_MAPPER_UNEXPECTED("Error inesperado mapeando PruningMapper",
		"Se presentó un error inesperado al mapear el ResultSet a PruningEntity. Revise la traza de errores para más detalle."),

	// Mapper - PruningTool
	USER_ERROR_PRUNING_TOOL_MAPPER("Ocurrió un problema al mapear la herramienta de poda desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir PruningToolEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_PRUNING_TOOL_MAPPER("Error técnico mapeando PruningToolMapper",
		"Se presentó un error técnico al mapear el ResultSet a PruningToolEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_PRUNING_TOOL_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la herramienta de poda",
		"Se presentó un error inesperado al mapear el ResultSet a PruningToolEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_PRUNING_TOOL_MAPPER_UNEXPECTED("Error inesperado mapeando PruningToolMapper",
		"Se presentó un error inesperado al mapear el ResultSet a PruningToolEntity. Revise la traza de errores para más detalle."),

	// DAO - PruningTool (create, find, update, delete)
	USER_ERROR_PRUNING_TOOL_CREATE("Se ha presentado un problema tratando de registrar la herramienta de poda. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de PruningTool en la base de datos."),
	TECHNICAL_ERROR_PRUNING_TOOL_CREATE("Error técnico creando PruningTool",
		"Error SQL ejecutando PruningToolSqlServerDAO.create. Revise la traza de errores para más detalles."),
	USER_ERROR_PRUNING_TOOL_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando la herramienta de poda",
		"Se produjo una excepción inesperada al crear la herramienta de poda. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PRUNING_TOOL_CREATE_UNEXPECTED("Error inesperado creando PruningTool",
		"Excepción inesperada al ejecutar la creación de PruningTool. Revise la traza de errores para más detalles."),

	USER_ERROR_PRUNING_TOOL_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar herramientas de poda. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de PruningTool en la base de datos."),
	TECHNICAL_ERROR_PRUNING_TOOL_FIND_BY_FILTER("Error técnico consultando PruningTool",
		"Error SQL ejecutando PruningToolSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_PRUNING_TOOL_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando herramientas de poda",
		"Se produjo una excepción inesperada al consultar herramientas de poda. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PRUNING_TOOL_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando PruningTool",
		"Excepción inesperada al ejecutar PruningToolSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	USER_ERROR_PRUNING_TOOL_UPDATE("Se ha presentado un problema tratando de modificar la herramienta de poda. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de PruningTool en la base de datos."),
	TECHNICAL_ERROR_PRUNING_TOOL_UPDATE("Error técnico modificando PruningTool",
		"Error SQL ejecutando PruningToolSqlServerDAO.update. Revise la traza de errores para más detalles."),
	USER_ERROR_PRUNING_TOOL_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar la herramienta de poda",
		"Se produjo una excepción inesperada al intentar actualizar la herramienta de poda. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PRUNING_TOOL_UPDATE_UNEXPECTED("Error inesperado modificando PruningTool",
		"Excepción inesperada al ejecutar la actualización de PruningTool. Revise la traza de errores para más detalles."),

	USER_ERROR_PRUNING_TOOL_DELETE("Se ha presentado un problema tratando de eliminar la herramienta de poda. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de PruningTool en la base de datos."),
	TECHNICAL_ERROR_PRUNING_TOOL_DELETE("Error técnico eliminando PruningTool",
		"Error SQL ejecutando PruningToolSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	USER_ERROR_PRUNING_TOOL_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando la herramienta de poda",
		"Se produjo una excepción inesperada al eliminar la herramienta de poda. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PRUNING_TOOL_DELETE_UNEXPECTED("Error inesperado eliminando PruningTool",
		"Excepción inesperada al ejecutar la eliminación de PruningTool. Revise la traza de errores para más detalles."),

	// Mapper - Quadrille
	USER_ERROR_QUADRILLE_MAPPER("Ocurrió un problema al mapear la cuadricula desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir QuadrilleEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_QUADRILLE_MAPPER("Error técnico mapeando QuadrilleMapper",
		"Se presentó un error técnico al mapear el ResultSet a QuadrilleEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_QUADRILLE_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la cuadricula",
		"Se presentó un error inesperado al mapear el ResultSet a QuadrilleEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_QUADRILLE_MAPPER_UNEXPECTED("Error inesperado mapeando QuadrilleMapper",
		"Se presentó un error inesperado al mapear el ResultSet a QuadrilleEntity. Revise la traza de errores para más detalle."),

	// DAO - Quadrille (create, find, update, delete)
	USER_ERROR_QUADRILLE_CREATE("Se ha presentado un problema tratando de registrar la cuadricula. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Quadrille en la base de datos."),
	TECHNICAL_ERROR_QUADRILLE_CREATE("Error técnico creando Quadrille",
		"Error SQL ejecutando QuadrilleSqlServerDAO.create. Revise la traza de errores para más detalles."),
	USER_ERROR_QUADRILLE_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando la cuadricula",
		"Se produjo una excepción inesperada al crear la cuadricula. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_QUADRILLE_CREATE_UNEXPECTED("Error inesperado creando Quadrille",
		"Excepción inesperada al ejecutar la creación de Quadrille. Revise la traza de errores para más detalles."),

	USER_ERROR_QUADRILLE_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar cuadrículas. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de Quadrille en la base de datos."),
	TECHNICAL_ERROR_QUADRILLE_FIND_BY_FILTER("Error técnico consultando Quadrille",
		"Error SQL ejecutando QuadrilleSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_QUADRILLE_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando cuadrículas",
		"Se produjo una excepción inesperada al consultar cuadrículas. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_QUADRILLE_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando Quadrille",
		"Excepción inesperada al ejecutar QuadrilleSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	USER_ERROR_QUADRILLE_UPDATE("Se ha presentado un problema tratando de modificar la cuadricula. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de Quadrille en la base de datos."),
	TECHNICAL_ERROR_QUADRILLE_UPDATE("Error técnico modificando Quadrille",
		"Error SQL ejecutando QuadrilleSqlServerDAO.update. Revise la traza de errores para más detalles."),
	USER_ERROR_QUADRILLE_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar la cuadricula",
		"Se produjo una excepción inesperada al intentar actualizar la cuadricula. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_QUADRILLE_UPDATE_UNEXPECTED("Error inesperado modificando Quadrille",
		"Excepción inesperada al ejecutar la actualización de Quadrille. Revise la traza de errores para más detalles."),

	USER_ERROR_QUADRILLE_DELETE("Se ha presentado un problema tratando de eliminar la cuadricula. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de Quadrille en la base de datos."),
	TECHNICAL_ERROR_QUADRILLE_DELETE("Error técnico eliminando Quadrille",
		"Error SQL ejecutando QuadrilleSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	USER_ERROR_QUADRILLE_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando la cuadricula",
		"Se produjo una excepción inesperada al eliminar la cuadricula. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_QUADRILLE_DELETE_UNEXPECTED("Error inesperado eliminando Quadrille",
		"Excepción inesperada al ejecutar la eliminación de Quadrille. Revise la traza de errores para más detalles."),

	// Mapper - Risk
	USER_ERROR_RISK_MAPPER("Ocurrió un problema al mapear el riesgo desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir RiskEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_RISK_MAPPER("Error técnico mapeando RiskMapper",
		"Se presentó un error técnico al mapear el ResultSet a RiskEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_RISK_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el riesgo",
		"Se presentó un error inesperado al mapear el ResultSet a RiskEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_RISK_MAPPER_UNEXPECTED("Error inesperado mapeando RiskMapper",
		"Se presentó un error inesperado al mapear el ResultSet a RiskEntity. Revise la traza de errores para más detalle."),

	// DAO - Risk (create, find, update, delete)
	USER_ERROR_RISK_CREATE("Se ha presentado un problema tratando de registrar el riesgo. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Risk en la base de datos."),
	TECHNICAL_ERROR_RISK_CREATE("Error técnico creando Risk",
		"Error SQL ejecutando RiskSqlServerDAO.create. Revise la traza de errores para más detalles."),
	USER_ERROR_RISK_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando el riesgo",
		"Se produjo una excepción inesperada al crear el riesgo. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_RISK_CREATE_UNEXPECTED("Error inesperado creando Risk",
		"Excepción inesperada al ejecutar la creación de Risk. Revise la traza de errores para más detalles."),

	USER_ERROR_RISK_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar riesgos. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de Risk en la base de datos."),
	TECHNICAL_ERROR_RISK_FIND_BY_FILTER("Error técnico consultando Risk",
		"Error SQL ejecutando RiskSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_RISK_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando riesgos",
		"Se produjo una excepción inesperada al consultar riesgos. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_RISK_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando Risk",
		"Excepción inesperada al ejecutar RiskSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	USER_ERROR_RISK_UPDATE("Se ha presentado un problema tratando de modificar el riesgo. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de Risk en la base de datos."),
	TECHNICAL_ERROR_RISK_UPDATE("Error técnico modificando Risk",
		"Error SQL ejecutando RiskSqlServerDAO.update. Revise la traza de errores para más detalles."),
	USER_ERROR_RISK_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar el riesgo",
		"Se produjo una excepción inesperada al intentar actualizar el riesgo. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_RISK_UPDATE_UNEXPECTED("Error inesperado modificando Risk",
		"Excepción inesperada al ejecutar la actualización de Risk. Revise la traza de errores para más detalles."),

	USER_ERROR_RISK_DELETE("Se ha presentado un problema tratando de eliminar el riesgo. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de Risk en la base de datos."),
	TECHNICAL_ERROR_RISK_DELETE("Error técnico eliminando Risk",
		"Error SQL ejecutando RiskSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	USER_ERROR_RISK_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando el riesgo",
		"Se produjo una excepción inesperada al eliminar el riesgo. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_RISK_DELETE_UNEXPECTED("Error inesperado eliminando Risk",
		"Excepción inesperada al ejecutar la eliminación de Risk. Revise la traza de errores para más detalles."),

	// Mapper - Sector
	USER_ERROR_SECTOR_MAPPER("Ocurrió un problema al mapear el sector desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir SectorEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_SECTOR_MAPPER("Error técnico mapeando SectorMapper",
		"Se presentó un error técnico al mapear el ResultSet a SectorEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_SECTOR_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el sector",
		"Se presentó un error inesperado al mapear el ResultSet a SectorEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_SECTOR_MAPPER_UNEXPECTED("Error inesperado mapeando SectorMapper",
		"Se presentó un error inesperado al mapear el ResultSet a SectorEntity. Revise la traza de errores para más detalle."),

	// DAO - Sector (create, find, update, delete)
	USER_ERROR_SECTOR_CREATE("Se ha presentado un problema tratando de registrar el sector. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Sector en la base de datos."),
	TECHNICAL_ERROR_SECTOR_CREATE("Error técnico creando Sector",
		"Error SQL ejecutando SectorSqlServerDAO.create. Revise la traza de errores para más detalles."),
	USER_ERROR_SECTOR_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando el sector",
		"Se produjo una excepción inesperada al crear el sector. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_SECTOR_CREATE_UNEXPECTED("Error inesperado creando Sector",
		"Excepción inesperada al ejecutar la creación de Sector. Revise la traza de errores para más detalles."),

	USER_ERROR_SECTOR_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar sectores. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de Sector en la base de datos."),
	TECHNICAL_ERROR_SECTOR_FIND_BY_FILTER("Error técnico consultando Sector",
		"Error SQL ejecutando SectorSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_SECTOR_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando sectores",
		"Se produjo una excepción inesperada al consultar sectores. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_SECTOR_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando Sector",
		"Excepción inesperada al ejecutar SectorSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	USER_ERROR_SECTOR_UPDATE("Se ha presentado un problema tratando de modificar el sector. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de Sector en la base de datos."),
	TECHNICAL_ERROR_SECTOR_UPDATE("Error técnico modificando Sector",
		"Error SQL ejecutando SectorSqlServerDAO.update. Revise la traza de errores para más detalles."),
	USER_ERROR_SECTOR_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar el sector",
		"Se produjo una excepción inesperada al intentar actualizar el sector. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_SECTOR_UPDATE_UNEXPECTED("Error inesperado modificando Sector",
		"Excepción inesperada al ejecutar la actualización de Sector. Revise la traza de errores para más detalles."),

	USER_ERROR_SECTOR_DELETE("Se ha presentado un problema tratando de eliminar el sector. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de Sector en la base de datos."),
	TECHNICAL_ERROR_SECTOR_DELETE("Error técnico eliminando Sector",
		"Error SQL ejecutando SectorSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	USER_ERROR_SECTOR_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando el sector",
		"Se produjo una excepción inesperada al eliminar el sector. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_SECTOR_DELETE_UNEXPECTED("Error inesperado eliminando Sector",
		"Excepción inesperada al ejecutar la eliminación de Sector. Revise la traza de errores para más detalles."),

	// Mapper - State
	USER_ERROR_STATE_MAPPER("Ocurrió un problema al mapear el estado desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir StateEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_STATE_MAPPER("Error técnico mapeando StateMapper",
		"Se presentó un error técnico al mapear el ResultSet a StateEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_STATE_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el estado",
		"Se presentó un error inesperado al mapear el ResultSet a StateEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_STATE_MAPPER_UNEXPECTED("Error inesperado mapeando StateMapper",
		"Se presentó un error inesperado al mapear el ResultSet a StateEntity. Revise la traza de errores para más detalle."),

	// DAO - State (create, find, update, delete)
	USER_ERROR_STATE_CREATE("Se ha presentado un problema tratando de registrar el estado. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de State en la base de datos."),
	TECHNICAL_ERROR_STATE_CREATE("Error técnico creando State",
		"Error SQL ejecutando StateSqlServerDAO.create. Revise la traza de errores para más detalles."),
	USER_ERROR_STATE_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando el estado",
		"Se produjo una excepción inesperada al crear el estado. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_STATE_CREATE_UNEXPECTED("Error inesperado creando State",
		"Excepción inesperada al ejecutar la creación de State. Revise la traza de errores para más detalles."),

	USER_ERROR_STATE_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar estados. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de State en la base de datos."),
	TECHNICAL_ERROR_STATE_FIND_BY_FILTER("Error técnico consultando State",
		"Error SQL ejecutando StateSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando estados",
		"Se produjo una excepción inesperada al consultar estados. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando State",
		"Excepción inesperada al ejecutar StateSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	USER_ERROR_STATE_UPDATE("Se ha presentado un problema tratando de modificar el estado. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de State en la base de datos."),
	TECHNICAL_ERROR_STATE_UPDATE("Error técnico modificando State",
		"Error SQL ejecutando StateSqlServerDAO.update. Revise la traza de errores para más detalles."),
	USER_ERROR_STATE_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar el estado",
		"Se produjo una excepción inesperada al intentar actualizar el estado. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_STATE_UPDATE_UNEXPECTED("Error inesperado modificando State",
		"Excepción inesperada al ejecutar la actualización de State. Revise la traza de errores para más detalles."),

	USER_ERROR_STATE_DELETE("Se ha presentado un problema tratando de eliminar el estado. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de State en la base de datos."),
	TECHNICAL_ERROR_STATE_DELETE("Error técnico eliminando State",
		"Error SQL ejecutando StateSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	USER_ERROR_STATE_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando el estado",
		"Se produjo una excepción inesperada al eliminar el estado. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_STATE_DELETE_UNEXPECTED("Error inesperado eliminando State",
		"Excepción inesperada al ejecutar la eliminación de State. Revise la traza de errores para más detalles."),

	// Mapper - Status
	USER_ERROR_STATUS_MAPPER("Ocurrió un problema al mapear el estado de registro desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir StatusEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_STATUS_MAPPER("Error técnico mapeando StatusMapper",
		"Se presentó un error técnico al mapear el ResultSet a StatusEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_STATUS_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el estado de registro",
		"Se presentó un error inesperado al mapear el ResultSet a StatusEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_STATUS_MAPPER_UNEXPECTED("Error inesperado mapeando StatusMapper",
		"Se presentó un error inesperado al mapear el ResultSet a StatusEntity. Revise la traza de errores para más detalle."),

	// Mapper - Tool
	USER_ERROR_TOOL_MAPPER("Ocurrió un problema al mapear la herramienta desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir ToolEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_TOOL_MAPPER("Error técnico mapeando ToolMapper",
		"Se presentó un error técnico al mapear el ResultSet a ToolEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_TOOL_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la herramienta",
		"Se presentó un error inesperado al mapear el ResultSet a ToolEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_TOOL_MAPPER_UNEXPECTED("Error inesperado mapeando ToolMapper",
		"Se presentó un error inesperado al mapear el ResultSet a ToolEntity. Revise la traza de errores para más detalle."),

	// Mapper - Tree
	USER_ERROR_TREE_MAPPER("Ocurrió un problema al mapear el árbol desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir TreeEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_TREE_MAPPER("Error técnico mapeando TreeMapper",
		"Se presentó un error técnico al mapear el ResultSet a TreeEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_TREE_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el árbol",
		"Se presentó un error inesperado al mapear el ResultSet a TreeEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_TREE_MAPPER_UNEXPECTED("Error inesperado mapeando TreeMapper",
		"Se presentó un error inesperado al mapear el ResultSet a TreeEntity. Revise la traza de errores para más detalle."),

	// DAO - Tree (create, find, update, delete)
	USER_ERROR_TREE_CREATE("Se ha presentado un problema tratando de registrar el árbol. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Tree en la base de datos. Verifique la sentencia SQL y los parámetros enviados desde TreeSqlServerDAO.create."),
	TECHNICAL_ERROR_TREE_CREATE("Error técnico creando Tree",
		"SQLException ocurred ejecutando TreeSqlServerDAO.create. Revise la traza de errores y el estado de la conexión para más detalles."),
	USER_ERROR_TREE_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando el árbol",
		"Se produjo una excepción inesperada al crear el árbol. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_TREE_CREATE_UNEXPECTED("Error inesperado creando Tree",
		"Excepción inesperada en TreeSqlServerDAO.create. Revise la traza completa de la excepción para identificar la causa."),

	USER_ERROR_TREE_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar árboles. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de Tree en la base de datos. Verifique la sentencia SQL construida y los parámetros enviados desde TreeSqlServerDAO.findByFilter."),
	TECHNICAL_ERROR_TREE_FIND_BY_FILTER("Error técnico consultando Tree",
		"Error SQL ejecutando TreeSqlServerDAO.findByFilter. Revise la traza de errores y valide la construcción dinámica del WHERE."),
	USER_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando árboles",
		"Se produjo una excepción inesperada al consultar árboles. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando Tree",
		"Excepción inesperada en TreeSqlServerDAO.findByFilter. Revise la traza completa de la excepción para identificar la causa."),

	USER_ERROR_TREE_UPDATE("Se ha presentado un problema tratando de modificar el árbol. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de Tree en la base de datos. Verifique la sentencia SQL y los parámetros enviados desde TreeSqlServerDAO.update."),
	TECHNICAL_ERROR_TREE_UPDATE("Error técnico modificando Tree",
		"SQLException ocurred ejecutando TreeSqlServerDAO.update. Revise la traza de errores y el estado de la conexión para más detalles."),
	USER_ERROR_TREE_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar el árbol",
		"Se produjo una excepción inesperada al intentar actualizar el árbol. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_TREE_UPDATE_UNEXPECTED("Error inesperado modificando Tree",
		"Excepción inesperada en TreeSqlServerDAO.update. Revise la traza completa de la excepción para identificar la causa."),

	USER_ERROR_TREE_DELETE("Se ha presentado un problema tratando de eliminar el árbol. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de Tree en la base de datos. Verifique la sentencia SQL y que el id proporcionado exista."),
	TECHNICAL_ERROR_TREE_DELETE("Error técnico eliminando Tree",
		"SQLException ocurred ejecutando TreeSqlServerDAO.delete. Revise la traza de errores y el estado de la conexión para más detalles."),
	USER_ERROR_TREE_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando el árbol",
		"Se produjo una excepción inesperada al eliminar el árbol. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_TREE_DELETE_UNEXPECTED("Error inesperado eliminando Tree",
		"Excepción inesperada en TreeSqlServerDAO.delete. Revise la traza completa de la excepción para identificar la causa."),

	// Generic DAO operation messages (used when no entity-specific message exists)
	USER_ERROR_DAO_EXECUTE("Error realizando operación de datos",
		"Se ha presentado un problema al ejecutar la operación solicitada en la capa de acceso a datos. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_DAO_EXECUTE("Error técnico ejecutando operación de datos",
		"Se produjo un error técnico en la capa DAO. Revise la traza de errores para identificar el punto de fallo y tomar las acciones necesarias."),
	USER_ERROR_DAO_EXECUTE_UNEXPECTED("Error inesperado realizando operación de datos",
		"Se ha presentado un problema inesperado al ejecutar la operación en la capa de acceso a datos. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_DAO_EXECUTE_UNEXPECTED("Error técnico inesperado ejecutando operación de datos",
		"Se produjo una excepción inesperada en la capa DAO. Revise la traza de errores para identificar el punto de fallo y tomar las acciones necesarias."),

	// DAO - Administrator
	USER_ERROR_ADMINISTRATOR_CREATE("Se ha presentado un problema tratando de registrar el administrador. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación del administrador en la base de datos."),
	TECHNICAL_ERROR_ADMINISTRATOR_CREATE("Error técnico creando administrador",
		"Error SQL ejecutando el proceso de creación de Administrator. Revise la traza de errores para más detalles."),
	USER_ERROR_ADMINISTRATOR_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de crear el administrador. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo una excepción inesperada al intentar crear el administrador. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_ADMINISTRATOR_CREATE_UNEXPECTED("Error inesperado creando administrador",
		"Excepción inesperada al ejecutar la creación del administrador. Revise la traza de errores para más detalles."),

	USER_ERROR_ADMINISTRATOR_UPDATE("Se ha presentado un problema tratando de modificar el administrador. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización del administrador en la base de datos."),
	TECHNICAL_ERROR_ADMINISTRATOR_UPDATE("Error técnico modificando administrador",
		"Error SQL ejecutando el proceso de actualización de Administrator. Revise la traza de errores para más detalles."),
	USER_ERROR_ADMINISTRATOR_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar el administrador. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo una excepción inesperada al intentar actualizar el administrador. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_ADMINISTRATOR_UPDATE_UNEXPECTED("Error inesperado modificando administrador",
		"Excepción inesperada al ejecutar la actualización del administrador. Revise la traza de errores para más detalles."),

	USER_ERROR_ADMINISTRATOR_DELETE("Se ha presentado un problema tratando de eliminar el administrador. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación del administrador en la base de datos."),
	TECHNICAL_ERROR_ADMINISTRATOR_DELETE("Error técnico eliminando administrador",
		"Error SQL ejecutando el proceso de eliminación de Administrator. Revise la traza de errores para más detalles."),
	USER_ERROR_ADMINISTRATOR_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de eliminar el administrador. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo una excepción inesperada al intentar eliminar el administrador. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_ADMINISTRATOR_DELETE_UNEXPECTED("Error inesperado eliminando administrador",
		"Excepción inesperada al ejecutar la eliminación del administrador. Revise la traza de errores para más detalles."),

	USER_ERROR_ADMINISTRATOR_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar administradores. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de administradores en la base de datos."),
	TECHNICAL_ERROR_ADMINISTRATOR_FIND_BY_FILTER("Error técnico consultando administradores",
		"Error SQL ejecutando AdministratorSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de consultar administradores. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo una excepción inesperada al ejecutar la consulta de administradores. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando administradores",
		"Excepción inesperada al ejecutar AdministratorSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - Document
	USER_ERROR_DOCUMENT_CREATE("Se ha presentado un problema tratando de registrar el documento. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación del documento en la base de datos."),
	TECHNICAL_ERROR_DOCUMENT_CREATE("Error técnico creando documento",
		"Error SQL ejecutando la creación de Document. Revise la traza de errores para más detalles."),
	USER_ERROR_DOCUMENT_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando documento",
		"Se produjo una excepción inesperada al crear el documento. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_DOCUMENT_CREATE_UNEXPECTED("Error inesperado creando documento",
		"Excepción inesperada al ejecutar la creación del documento. Revise la traza de errores para más detalles."),

	USER_ERROR_DOCUMENT_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar documentos. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de documentos en la base de datos."),
	TECHNICAL_ERROR_DOCUMENT_FIND_BY_FILTER("Error técnico consultando documentos",
		"Error SQL ejecutando DocumentSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_DOCUMENT_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando documentos",
		"Se produjo una excepción inesperada al consultar documentos. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_DOCUMENT_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando documentos",
		"Excepción inesperada al ejecutar DocumentSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// --- Document update messages ---
	USER_ERROR_DOCUMENT_UPDATE("Se ha presentado un problema tratando de modificar el documento. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización del documento en la base de datos."),
	TECHNICAL_ERROR_DOCUMENT_UPDATE("Error técnico modificando documento",
		"Error SQL ejecutando la actualización en DocumentSqlServerDAO.update. Revise la traza de errores para más detalles."),
	USER_ERROR_DOCUMENT_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar el documento",
		"Se produjo una excepción inesperada al intentar actualizar el documento. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_DOCUMENT_UPDATE_UNEXPECTED("Error inesperado modificando documento",
		"Excepción inesperada al ejecutar la actualización en DocumentSqlServerDAO.update. Revise la traza de errores para más detalles."),

	USER_ERROR_DOCUMENT_DELETE("Se ha presentado un problema tratando de eliminar el documento. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la eliminación del documento en la base de datos."),
	TECHNICAL_ERROR_DOCUMENT_DELETE("Error técnico eliminando documento",
		"Error SQL ejecutando la eliminación de Document. Revise la traza de errores para más detalles."),
	USER_ERROR_DOCUMENT_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando documento",
		"Se produjo una excepción inesperada al eliminar el documento. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_DOCUMENT_DELETE_UNEXPECTED("Error inesperado eliminando documento",
		"Excepción inesperada al ejecutar la eliminación del documento. Revise la traza de errores para más detalles."),

	// DAO - Manager
	USER_ERROR_MANAGER_CREATE("Se ha presentado un problema tratando de registrar el manager. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación del manager en la base de datos."),
	TECHNICAL_ERROR_MANAGER_CREATE("Error técnico creando manager",
		"Error SQL ejecutando ManagerSqlServerDAO.create. Revise la traza de errores para más detalles."),
	USER_ERROR_MANAGER_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando manager",
		"Se produjo una excepción inesperada al crear el manager. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_MANAGER_CREATE_UNEXPECTED("Error inesperado creando manager",
		"Excepción inesperada al ejecutar la creación del manager. Revise la traza de errores para más detalles."),

	USER_ERROR_MANAGER_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar managers. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de managers en la base de datos."),
	TECHNICAL_ERROR_MANAGER_FIND_BY_FILTER("Error técnico consultando managers",
		"Error SQL ejecutando ManagerSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_MANAGER_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando managers",
		"Se produjo una excepción inesperada al consultar managers. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_MANAGER_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando managers",
		"Excepción inesperada al ejecutar ManagerSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	USER_ERROR_MANAGER_UPDATE("Se ha presentado un problema tratando de modificar el manager. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización del manager en la base de datos."),
	TECHNICAL_ERROR_MANAGER_UPDATE("Error técnico modificando manager",
		"Error SQL ejecutando ManagerSqlServerDAO.update. Revise la traza de errores para más detalles."),
	USER_ERROR_MANAGER_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar el manager",
		"Se produjo una excepción inesperada al intentar actualizar el manager. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_MANAGER_UPDATE_UNEXPECTED("Error inesperado modificando manager",
		"Excepción inesperada al ejecutar la actualización del manager. Revise la traza de errores para más detalles."),

	USER_ERROR_MANAGER_DELETE("Se ha presentado un problema tratando de eliminar el manager. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación del manager en la base de datos."),
	TECHNICAL_ERROR_MANAGER_DELETE("Error técnico eliminando manager",
		"Error SQL ejecutando ManagerSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	USER_ERROR_MANAGER_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de eliminar el manager",
		"Se produjo una excepción inesperada al intentar eliminar el manager. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_MANAGER_DELETE_UNEXPECTED("Error inesperado eliminando manager",
		"Excepción inesperada al ejecutar la eliminación del manager. Revise la traza de errores para más detalles."),

	// DAO - Municipality
	USER_ERROR_MUNICIPALITY_CREATE("Se ha presentado un problema tratando de registrar el municipio. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación del municipio en la base de datos."),
	TECHNICAL_ERROR_MUNICIPALITY_CREATE("Error técnico creando municipio",
		"Error SQL ejecutando la creación de Municipality. Revise la traza de errores para más detalles."),
	USER_ERROR_MUNICIPALITY_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando municipio",
		"Se produjo una excepción inesperada al crear el municipio. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_MUNICIPALITY_CREATE_UNEXPECTED("Error inesperado creando municipio",
		"Excepción inesperada al ejecutar la creación del municipio. Revise la traza de errores para más detalles."),

	USER_ERROR_MUNICIPALITY_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar municipios. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de municipios en la base de datos."),
	TECHNICAL_ERROR_MUNICIPALITY_FIND_BY_FILTER("Error técnico consultando municipios",
		"Error SQL ejecutando MunicipalitySqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_MUNICIPALITY_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando municipios",
		"Se produjo una excepción inesperada al consultar municipios. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_MUNICIPALITY_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando municipios",
		"Excepción inesperada al ejecutar MunicipalitySqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - Operator
	USER_ERROR_OPERATOR_CREATE("Se ha presentado un problema tratando de registrar el operador. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación del operador en la base de datos."),
	TECHNICAL_ERROR_OPERATOR_CREATE("Error técnico creando operador",
		"Error SQL ejecutando la creación de Operator. Revise la traza de errores para más detalles."),
	USER_ERROR_OPERATOR_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando operador",
		"Se produjo una excepción inesperada al crear el operador. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_OPERATOR_CREATE_UNEXPECTED("Error inesperado creando operador",
		"Excepción inesperada al ejecutar la creación del operador. Revise la traza de errores para más detalles."),

	USER_ERROR_OPERATOR_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar operadores. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de operadores en la base de datos."),
	TECHNICAL_ERROR_OPERATOR_FIND_BY_FILTER("Error técnico consultando operadores",
		"Error SQL ejecutando OperatorSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_OPERATOR_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando operadores",
		"Se produjo una excepción inesperada al consultar operadores. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_OPERATOR_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando operadores",
		"Excepción inesperada al ejecutar OperatorSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - Operator (update/delete messages added)
	USER_ERROR_OPERATOR_UPDATE("Se ha presentado un problema tratando de modificar el operador. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización del operador en la base de datos."),
	TECHNICAL_ERROR_OPERATOR_UPDATE("Error técnico modificando operador",
		"Error SQL ejecutando la actualización en OperatorSqlServerDAO.update. Revise la traza de errores para más detalles."),
	USER_ERROR_OPERATOR_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar el operador",
		"Se produjo una excepción inesperada al intentar modificar el operador. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_OPERATOR_UPDATE_UNEXPECTED("Error inesperado modificando operador",
		"Excepción inesperada al ejecutar la actualización en OperatorSqlServerDAO.update. Revise la traza de errores para más detalles."),

	USER_ERROR_OPERATOR_DELETE("Se ha presentado un problema tratando de eliminar el operador. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación del operador en la base de datos."),
	TECHNICAL_ERROR_OPERATOR_DELETE("Error técnico eliminando operador",
		"Error SQL ejecutando la eliminación en OperatorSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	USER_ERROR_OPERATOR_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando operador",
		"Se produjo una excepción inesperada al intentar eliminar el operador. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_OPERATOR_DELETE_UNEXPECTED("Error inesperado eliminando operador",
		"Excepción inesperada al ejecutar la eliminación en OperatorSqlServerDAO.delete. Revise la traza de errores para más detalles."),

	// DAO - Person
	USER_ERROR_PERSON_CREATE("Se ha presentado un problema tratando de registrar la persona. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de la persona en la base de datos."),
	TECHNICAL_ERROR_PERSON_CREATE("Error técnico creando persona",
		"Error SQL ejecutando la creación de Person. Revise la traza de errores para más detalles."),
	USER_ERROR_PERSON_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando persona",
		"Se produjo una excepción inesperada al crear la persona. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PERSON_CREATE_UNEXPECTED("Error inesperado creando persona",
		"Excepción inesperada al ejecutar la creación de la persona. Revise la traza de errores para más detalles."),

	USER_ERROR_PERSON_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar personas. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de personas en la base de datos."),
	TECHNICAL_ERROR_PERSON_FIND_BY_FILTER("Error técnico consultando personas",
		"Error SQL ejecutando PersonSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_PERSON_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando personas",
		"Se produjo una excepción inesperada al consultar personas. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PERSON_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando personas",
		"Excepción inesperada al ejecutar PersonSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - Person (update/delete messages added)
	USER_ERROR_PERSON_UPDATE("Se ha presentado un problema tratando de modificar la persona. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de la persona en la base de datos."),
	TECHNICAL_ERROR_PERSON_UPDATE("Error técnico modificando persona",
		"Error SQL ejecutando la actualización en PersonSqlServerDAO.update. Revise la traza de errores para más detalles."),
	USER_ERROR_PERSON_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar la persona",
		"Se produjo una excepción inesperada al intentar modificar la persona. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PERSON_UPDATE_UNEXPECTED("Error inesperado modificando persona",
		"Excepción inesperada al ejecutar la actualización en PersonSqlServerDAO.update. Revise la traza de errores para más detalles."),

	USER_ERROR_PERSON_DELETE("Se ha presentado un problema tratando de eliminar la persona. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de la persona en la base de datos."),
	TECHNICAL_ERROR_PERSON_DELETE("Error técnico eliminando persona",
		"Error SQL ejecutando la eliminación en PersonSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	USER_ERROR_PERSON_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando persona",
		"Se produjo una excepción inesperada al eliminar la persona. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PERSON_DELETE_UNEXPECTED("Error inesperado eliminando persona",
		"Excepción inesperada al ejecutar la eliminación en PersonSqlServerDAO.delete. Revise la traza de errores para más detalles."),

	// DAO - PQR
	USER_ERROR_PQR_CREATE("Se ha presentado un problema tratando de registrar la PQR. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de la PQR en la base de datos."),
	TECHNICAL_ERROR_PQR_CREATE("Error técnico creando PQR",
		"Error SQL ejecutando la creación de PQR. Revise la traza de errores para más detalles."),
	USER_ERROR_PQR_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando PQR",
		"Se produjo una excepción inesperada al crear la PQR. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PQR_CREATE_UNEXPECTED("Error inesperado creando PQR",
		"Excepción inesperada al ejecutar la creación de la PQR. Revise la traza de errores para más detalles."),

	USER_ERROR_PQR_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar PQRs. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de PQRs en la base de datos."),
	TECHNICAL_ERROR_PQR_FIND_BY_FILTER("Error técnico consultando PQRs",
		"Error SQL ejecutando PQRSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_PQR_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando PQRs",
		"Se produjo una excepción inesperada al consultar PQRs. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PQR_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando PQRs",
		"Excepción inesperada al ejecutar PQRSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// Added missing PQR update/delete messages
	USER_ERROR_PQR_UPDATE("Se ha presentado un problema tratando de modificar la PQR. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"No se pudo actualizar la PQR en la base de datos. Verifique que el id exista, los datos enviados y que la transacción esté activa."),
	TECHNICAL_ERROR_PQR_UPDATE("Error técnico modificando PQR",
		"SQLException ejecutando PQRSqlServerDAO.update. Revise la sentencia SQL, parámetros (orden y tipos) y el estado de la conexión/transacción."),
	USER_ERROR_PQR_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar la PQR",
		"Se produjo una excepción inesperada al intentar actualizar la PQR. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PQR_UPDATE_UNEXPECTED("Error inesperado modificando PQR",
		"Excepción inesperada al ejecutar la actualización de PQR. Revise la traza completa de la excepción para identificar la causa."),

	USER_ERROR_PQR_DELETE("Se ha presentado un problema tratando de eliminar la PQR. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"No se pudo eliminar la PQR en la base de datos. Verifique que el id exista y que no existan restricciones que impidan la eliminación (FKs)."),
	TECHNICAL_ERROR_PQR_DELETE("Error técnico eliminando PQR",
		"SQLException ejecutando PQRSqlServerDAO.delete. Revise la sentencia SQL, parámetros y restricciones de integridad referencial que puedan bloquear la operación."),
	USER_ERROR_PQR_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando la PQR",
		"Se produjo una excepción inesperada al eliminar la PQR. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PQR_DELETE_UNEXPECTED("Error inesperado eliminando PQR",
		"Excepción inesperada al ejecutar la eliminación de PQR. Revise la traza completa de la excepción para identificar la causa."),

		// DAO - Pruning
		USER_ERROR_PRUNING_CREATE("Se ha presentado un problema tratando de registrar la poda. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
			"Se produjo un error al ejecutar la operación de creación de Pruning en la base de datos."),
		TECHNICAL_ERROR_PRUNING_CREATE("Error técnico creando poda",
			"Error SQL ejecutando la creación de Pruning. Revise la traza de errores para más detalles."),
		USER_ERROR_PRUNING_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando poda",
			"Se produjo una excepción inesperada al crear la poda. Revise la traza de errores para más detalles."),
		TECHNICAL_ERROR_PRUNING_CREATE_UNEXPECTED("Error inesperado creando poda",
			"Excepción inesperada al ejecutar la creación de Pruning. Revise la traza de errores para más detalles."),

		USER_ERROR_PRUNING_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar podas. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
			"Se produjo un error al ejecutar la consulta de podas en la base de datos."),
		TECHNICAL_ERROR_PRUNING_FIND_BY_FILTER("Error técnico consultando podas",
			"Error SQL ejecutando PruningSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
		USER_ERROR_PRUNING_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando podas",
			"Se produjo una excepción inesperada al consultar podas. Revise la traza de errores para más detalles."),
		TECHNICAL_ERROR_PRUNING_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando podas",
			"Excepción inesperada al ejecutar PruningSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

		USER_ERROR_PRUNING_UPDATE("Se ha presentado un problema tratando de modificar la poda. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
			"Se produjo un error al ejecutar la operación de actualización de Pruning en la base de datos."),
		TECHNICAL_ERROR_PRUNING_UPDATE("Error técnico modificando poda",
			"Error SQL ejecutando la actualización en PruningSqlServerDAO.update. Revise la traza de errores para más detalles."),
		USER_ERROR_PRUNING_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de modificar la poda",
			"Se produjo una excepción inesperada al intentar actualizar la poda. Revise la traza de errores para más detalles."),
		TECHNICAL_ERROR_PRUNING_UPDATE_UNEXPECTED("Error inesperado modificando poda",
			"Excepción inesperada al ejecutar la actualización en PruningSqlServerDAO.update. Revise la traza de errores para más detalles."),


	USER_ERROR_PRUNING_DELETE("Se ha presentado un problema tratando de eliminar la poda. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de Pruning en la base de datos."),
	TECHNICAL_ERROR_PRUNING_DELETE("Error técnico eliminando poda",
		"Error SQL ejecutando la eliminación en PruningSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	USER_ERROR_PRUNING_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando la poda",
		"Se produjo una excepción inesperada al eliminar la poda. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PRUNING_DELETE_UNEXPECTED("Error inesperado eliminando poda",
		"Excepción inesperada al ejecutar la eliminación en PruningSqlServerDAO.delete. Revise la traza de errores para más detalles."),
	

;
	
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
		this.title = TextHelper.getDefaultWithTrim(title);
	}


	public String getContent() {
		return content;
	}


	private void setContent(String content) {
		this.content = TextHelper.getDefaultWithTrim(content);
	}
	
}
