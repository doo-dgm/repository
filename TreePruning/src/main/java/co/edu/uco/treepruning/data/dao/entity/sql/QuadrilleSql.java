package co.edu.uco.treepruning.data.dao.entity.sql;

public final class QuadrilleSql {

    public static final String CREATE = """
            INSERT INTO Quadrille (
                id,
                quadrilleName,
                managerId
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
			    q.id AS quadrilleId,
			    q.quadrilleName,
			    m.id AS managerId,
			    p.id AS personId,
			    p.firstName,
				p.middleName,
			    p.surname,
				p.secondSurname,
				d.id AS documentId,
				d.id AS documentName,
				d.id AS documentCode,
				p.documentNumber,
				p.birthDate,
				p.address,
				p.email,
				p.emailConfirmed,
				p.phone,
				p.phoneConfirmed,
				p.age
			FROM quadrille AS q
			INNER JOIN manager AS m ON q.managerId = m.id
			INNER JOIN person AS p ON m.personId = p.id
			INNER JOIN document AS d ON p.documentId = d.id
            """;

    public static final String UPDATE = """
            UPDATE Quadrille
            SET name = ?,
                manager = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Quadrille
            WHERE id = ?
            """;
}

