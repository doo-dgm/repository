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
	
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexion contra la fuente de datos deseado", 
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

	// Mapper - Quadrille
	USER_ERROR_QUADRILLE_MAPPER("Ocurrió un problema al mapear la cuadricula desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir QuadrilleEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_QUADRILLE_MAPPER("Error técnico mapeando QuadrilleMapper",
		"Se presentó un error técnico al mapear el ResultSet a QuadrilleEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_QUADRILLE_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la cuadricula",
		"Se presentó un error inesperado al mapear el ResultSet a QuadrilleEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_QUADRILLE_MAPPER_UNEXPECTED("Error inesperado mapeando QuadrilleMapper",
		"Se presentó un error inesperado al mapear el ResultSet a QuadrilleEntity. Revise la traza de errores para más detalle."),

	// Mapper - Risk
	USER_ERROR_RISK_MAPPER("Ocurrió un problema al mapear el riesgo desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir RiskEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_RISK_MAPPER("Error técnico mapeando RiskMapper",
		"Se presentó un error técnico al mapear el ResultSet a RiskEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_RISK_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el riesgo",
		"Se presentó un error inesperado al mapear el ResultSet a RiskEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_RISK_MAPPER_UNEXPECTED("Error inesperado mapeando RiskMapper",
		"Se presentó un error inesperado al mapear el ResultSet a RiskEntity. Revise la traza de errores para más detalle."),

	// Mapper - Sector
	USER_ERROR_SECTOR_MAPPER("Ocurrió un problema al mapear el sector desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir SectorEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_SECTOR_MAPPER("Error técnico mapeando SectorMapper",
		"Se presentó un error técnico al mapear el ResultSet a SectorEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_SECTOR_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el sector",
		"Se presentó un error inesperado al mapear el ResultSet a SectorEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_SECTOR_MAPPER_UNEXPECTED("Error inesperado mapeando SectorMapper",
		"Se presentó un error inesperado al mapear el ResultSet a SectorEntity. Revise la traza de errores para más detalle."),

	// Mapper - State
	USER_ERROR_STATE_MAPPER("Ocurrió un problema al mapear el estado desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir StateEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_STATE_MAPPER("Error técnico mapeando StateMapper",
		"Se presentó un error técnico al mapear el ResultSet a StateEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_STATE_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el estado",
		"Se presentó un error inesperado al mapear el ResultSet a StateEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_STATE_MAPPER_UNEXPECTED("Error inesperado mapeando StateMapper",
		"Se presentó un error inesperado al mapear el ResultSet a StateEntity. Revise la traza de errores para más detalle."),

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

	// Mapper - Type
	USER_ERROR_TYPE_MAPPER("Ocurrió un problema al mapear el tipo desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir TypeEntity. Verifique esquema y nombres de columnas."),
	TECHNICAL_ERROR_TYPE_MAPPER("Error técnico mapeando TypeMapper",
		"Se presentó un error técnico al mapear el ResultSet a TypeEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_TYPE_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el tipo",
		"Se presentó un error inesperado al mapear el ResultSet a TypeEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_TYPE_MAPPER_UNEXPECTED("Error inesperado mapeando TypeMapper",
		"Se presentó un error inesperado al mapear el ResultSet a TypeEntity. Revise la traza de errores para más detalle."),

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
		"Error SQL ejecutando la creación de Manager. Revise la traza de errores para más detalles."),
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

	// DAO - Programming
	USER_ERROR_PROGRAMMING_CREATE("Se ha presentado un problema tratando de registrar la programación. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Programming en la base de datos."),
	TECHNICAL_ERROR_PROGRAMMING_CREATE("Error técnico creando programación",
		"Error SQL ejecutando la creación de Programming. Revise la traza de errores para más detalles."),
	USER_ERROR_PROGRAMMING_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando programación",
		"Se produjo una excepción inesperada al crear la programación. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PROGRAMMING_CREATE_UNEXPECTED("Error inesperado creando programación",
		"Excepción inesperada al ejecutar la creación de Programming. Revise la traza de errores para más detalles."),

	USER_ERROR_PROGRAMMING_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar programaciones. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de programaciones en la base de datos."),
	TECHNICAL_ERROR_PROGRAMMING_FIND_BY_FILTER("Error técnico consultando programaciones",
		"Error SQL ejecutando ProgrammingSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_PROGRAMMING_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando programaciones",
		"Se produjo una excepción inesperada al consultar programaciones. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PROGRAMMING_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando programaciones",
		"Excepción inesperada al ejecutar ProgrammingSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

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

	// DAO - PruningTool
	USER_ERROR_PRUNING_TOOL_CREATE("Se ha presentado un problema tratando de registrar la herramienta de poda. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de PruningTool en la base de datos."),
	TECHNICAL_ERROR_PRUNING_TOOL_CREATE("Error técnico creando herramienta de poda",
		"Error SQL ejecutando la creación de PruningTool. Revise la traza de errores para más detalles."),
	USER_ERROR_PRUNING_TOOL_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando herramienta de poda",
		"Se produjo una excepción inesperada al crear la herramienta de poda. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PRUNING_TOOL_CREATE_UNEXPECTED("Error inesperado creando herramienta de poda",
		"Excepción inesperada al ejecutar la creación de PruningTool. Revise la traza de errores para más detalles."),

	USER_ERROR_PRUNING_TOOL_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar herramientas de poda. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de herramientas de poda en la base de datos."),
	TECHNICAL_ERROR_PRUNING_TOOL_FIND_BY_FILTER("Error técnico consultando herramientas de poda",
		"Error SQL ejecutando PruningToolSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_PRUNING_TOOL_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando herramientas de poda",
		"Se produjo una excepción inesperada al consultar herramientas de poda. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_PRUNING_TOOL_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando herramientas de poda",
		"Excepción inesperada al ejecutar PruningToolSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - Quadrille
	USER_ERROR_QUADRILLE_CREATE("Se ha presentado un problema tratando de registrar la cuadricula. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Quadrille en la base de datos."),
	TECHNICAL_ERROR_QUADRILLE_CREATE("Error técnico creando cuadricula",
		"Error SQL ejecutando la creación de Quadrille. Revise la traza de errores para más detalles."),
	USER_ERROR_QUADRILLE_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando cuadricula",
		"Se produjo una excepción inesperada al crear la cuadricula. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_QUADRILLE_CREATE_UNEXPECTED("Error inesperado creando cuadricula",
		"Excepción inesperada al ejecutar la creación de Quadrille. Revise la traza de errores para más detalles."),

	USER_ERROR_QUADRILLE_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar cuadriculas. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de cuadriculas en la base de datos."),
	TECHNICAL_ERROR_QUADRILLE_FIND_BY_FILTER("Error técnico consultando cuadriculas",
		"Error SQL ejecutando QuadrilleSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_QUADRILLE_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando cuadriculas",
		"Se produjo una excepción inesperada al consultar cuadriculas. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_QUADRILLE_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando cuadriculas",
		"Excepción inesperada al ejecutar QuadrilleSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	USER_ERROR_QUADRILLE_UPDATE("Se ha presentado un problema tratando de modificar la cuadricula. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de Quadrille en la base de datos."),
	TECHNICAL_ERROR_QUADRILLE_UPDATE("Error técnico modificando cuadricula",
		"Error SQL ejecutando la actualización de Quadrille. Revise la traza de errores para más detalles."),
	USER_ERROR_QUADRILLE_UPDATE_UNEXPECTED("Se ha presentado un problema INESPERADO modificando cuadricula",
		"Se produjo una excepción inesperada al modificar la cuadricula. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_QUADRILLE_UPDATE_UNEXPECTED("Error inesperado modificando cuadricula",
		"Excepción inesperada al ejecutar la actualización de Quadrille. Revise la traza de errores para más detalles."),

	USER_ERROR_QUADRILLE_DELETE("Se ha presentado un problema tratando de eliminar la cuadricula. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de Quadrille en la base de datos."),
	TECHNICAL_ERROR_QUADRILLE_DELETE("Error técnico eliminando cuadricula",
		"Error SQL ejecutando la eliminación de Quadrille. Revise la traza de errores para más detalles."),
	USER_ERROR_QUADRILLE_DELETE_UNEXPECTED("Se ha presentado un problema INESPERADO eliminando cuadricula",
		"Se produjo una excepción inesperada al eliminar la cuadricula. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_QUADRILLE_DELETE_UNEXPECTED("Error inesperado eliminando cuadricula",
		"Excepción inesperada al ejecutar la eliminación de Quadrille. Revise la traza de errores para más detalles."),

	// DAO - Risk
	USER_ERROR_RISK_CREATE("Se ha presentado un problema tratando de registrar el riesgo. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Risk en la base de datos."),
	TECHNICAL_ERROR_RISK_CREATE("Error técnico creando riesgo",
		"Error SQL ejecutando la creación de Risk. Revise la traza de errores para más detalles."),
	USER_ERROR_RISK_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando riesgo",
		"Se produjo una excepción inesperada al crear el riesgo. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_RISK_CREATE_UNEXPECTED("Error inesperado creando riesgo",
		"Excepción inesperada al ejecutar la creación de Risk. Revise la traza de errores para más detalles."),

	USER_ERROR_RISK_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar riesgos. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de riesgos en la base de datos."),
	TECHNICAL_ERROR_RISK_FIND_BY_FILTER("Error técnico consultando riesgos",
		"Error SQL ejecutando RiskSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_RISK_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando riesgos",
		"Se produjo una excepción inesperada al consultar riesgos. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_RISK_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando riesgos",
		"Excepción inesperada al ejecutar RiskSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - Sector
	USER_ERROR_SECTOR_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar sectores. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de sectores en la base de datos."),
	TECHNICAL_ERROR_SECTOR_FIND_BY_FILTER("Error técnico consultando sectores",
		"Error SQL ejecutando SectorSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_SECTOR_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando sectores",
		"Se produjo una excepción inesperada al consultar sectores. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_SECTOR_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando sectores",
		"Excepción inesperada al ejecutar SectorSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - State
	USER_ERROR_STATE_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar estados. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de estados en la base de datos."),
	TECHNICAL_ERROR_STATE_FIND_BY_FILTER("Error técnico consultando estados",
		"Error SQL ejecutando StateSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando estados",
		"Se produjo una excepción inesperada al consultar estados. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando estados",
		"Excepción inesperada al ejecutar StateSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - Status
	USER_ERROR_STATUS_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar estados de registro. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de estados de registro en la base de datos."),
	TECHNICAL_ERROR_STATUS_FIND_BY_FILTER("Error técnico consultando estados de registro",
		"Error SQL ejecutando StatusSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_STATUS_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando estados de registro",
		"Se produjo una excepción inesperada al consultar estados de registro. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_STATUS_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando estados de registro",
		"Excepción inesperada al ejecutar StatusSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - Tool
	USER_ERROR_TOOL_CREATE("Se ha presentado un problema tratando de registrar la herramienta. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Tool en la base de datos."),
	TECHNICAL_ERROR_TOOL_CREATE("Error técnico creando herramienta",
		"Error SQL ejecutando la creación de Tool. Revise la traza de errores para más detalles."),
	USER_ERROR_TOOL_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO creando herramienta",
		"Se produjo una excepción inesperada al crear la herramienta. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_TOOL_CREATE_UNEXPECTED("Error inesperado creando herramienta",
		"Excepción inesperada al ejecutar la creación de Tool. Revise la traza de errores para más detalles."),

	USER_ERROR_TOOL_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar herramientas. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de herramientas en la base de datos."),
	TECHNICAL_ERROR_TOOL_FIND_BY_FILTER("Error técnico consultando herramientas",
		"Error SQL ejecutando ToolSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_TOOL_FIND_BY_FILTER_UNEXPECTED("Se ha presentado un problema INESPERADO consultando herramientas",
		"Se produjo una excepción inesperada al consultar herramientas. Revise la traza de errores para más detalles."),
	TECHNICAL_ERROR_TOOL_FIND_BY_FILTER_UNEXPECTED("Error inesperado consultando herramientas",
		"Excepción inesperada al ejecutar ToolSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),

	// DAO - Tree (existing but ensure unexpected/other ops present)
	USER_ERROR_TREE_CREATE("Se ha presentado un problema tratando de crear el arbol. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de creación de Tree en la base de datos."),
	TECHNICAL_ERROR_TREE_CREATE("Error técnico creando Tree",
		"Error SQL ejecutando la creación de Tree. Revise la traza de errores para más detalles."),
	USER_ERROR_TREE_FIND_BY_FILTER("Se ha presentado un problema tratando de consultar arboles. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la consulta de arboles en la base de datos."),
	TECHNICAL_ERROR_TREE_FIND_BY_FILTER("Error técnico consultando arboles",
		"Error SQL ejecutando TreeSqlServerDAO.findByFilter. Revise la traza de errores para más detalles."),
	USER_ERROR_TREE_UPDATE("Se ha presentado un problema tratando de modificar el arbol. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de actualización de Tree en la base de datos."),
	TECHNICAL_ERROR_TREE_UPDATE("Error técnico modificando Tree",
		"Error SQL ejecutando la actualización de Tree. Revise la traza de errores para más detalles."),
	USER_ERROR_TREE_DELETE("Se ha presentado un problema tratando de eliminar el arbol. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se produjo un error al ejecutar la operación de eliminación de Tree en la base de datos."),
	TECHNICAL_ERROR_TREE_DELETE("Error técnico eliminando Tree",
		"Error SQL ejecutando la eliminación de Tree. Revise la traza de errores para más detalles."),

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
