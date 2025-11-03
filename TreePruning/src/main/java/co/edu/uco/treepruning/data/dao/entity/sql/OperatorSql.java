package co.edu.uco.treepruning.data.dao.entity.sql;

public final class OperatorSql {

    public static final String CREATE = """
            INSERT INTO Operator (
                id,
                person,
                cuadrille
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
    		SELECT 
    				o.id AS operatorId,
    				p.id AS personOperatorId,
    				p.firstName AS personOperatorFirstName, 
    				p.middleName AS personOperatorMiddleName,
    				p.surname AS personOperatorSurname,
    				p.secondSurname AS personOperatorSecondSurname,
    				d.id as documentOperatorId,
    				d.name AS documentPersonOperatorName,
    				d.code AS documentPersonOperatorCode,
    				p.documentNumber AS personOperatorDocumentNumber,
    				p.birthDate AS personOperatorBirthDate,
    				p.address AS personOperatorAddress,
    				p.email AS personOperatorEmail,
    				p.emailConfirmed AS personOperatorEmailConfirmed,
    				p.phone AS personOperatorPhone,
    				p.phoneConfirmed AS personOperatorPhoneConfirmed,
    				p.age AS personOperatorAge,
    				q.id AS quadrilleId,
    				q.quadrilleName AS quadrilleName,
    				m.id AS managerId,
    				pm.id AS personManagerId,
    				pm.firstName AS personManagerFirstName,
    				pm.middleName AS personManagerMiddleName,
    				pm.surname AS personManagerSurname,
    				pm.secondSurname AS personManagerSecondSurname,
    				dm.id AS documentId AS personManagerId,
    				dm.name AS documentName AS documentPersonManagerName,
    				dm.code AS documentCode AS documentPersonManagerCode,
    				pm.documentNumber AS personManagerDocumentNumber,
    				pm.birthDate AS personManagerBirthDate,
    				pm.address AS personManagerAddress,
    				pm.email AS personManagerEmail,
    				pm.emailConfirmed AS personManagerEmailConfirmed,
    				pm.phone AS personManagerPhone,
    				pm.phoneConfirmed AS personManagerPhoneConfirmed,
    				pm.age AS personManagerAge
		FROM Operator AS o
		INNER JOIN Person AS p ON o.personId = p.id
		INNER JOIN Cuadrille AS q ON o.cuadrilleId = q.id
		INNER JOIN manager AS m ON q.managerId = m.id
		INNER JOIN person AS pm ON m.personId = pm.id
		INNER JOIN document AS d ON p.documentId = d.id
""";

    public static final String UPDATE = """
            UPDATE Operator
            SET person = ?,
                cuadrille = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Operator
            WHERE id = ?
            """;
}

