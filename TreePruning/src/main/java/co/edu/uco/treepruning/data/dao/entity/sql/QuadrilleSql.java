package co.edu.uco.treepruning.data.dao.entity.sql;

public final class QuadrilleSql {

    public static final String CREATE = """
            INSERT INTO Quadrille (
                id,
                name,
                managerId
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = 
		"""
		SELECT
	q.id AS quadrilleId,
	q.quadrilleName AS quadrilleName,
	m.id AS managerId,
	p.id AS personId,
	p.firstName AS personFirstName,
	p.middleName AS personMiddleName,
	p.surname AS personSurname,
	p.secondSurname AS personSecondSurname,
	d.id AS documentId,
	d.name AS documentName,
	d.code AS documentCode,
	p.documentNumber AS personDocumentNumber,
	p.birthDate AS personBirthDate,
	p.address AS personAddress,
	p.email AS personEmail,
	p.emailConfirmed AS personEmailConfirmed,
	p.phone AS personPhone,
	p.phoneConfirmed AS personPhoneConfirmed,
	p.age AS personAge
FROM quadrille AS q
LEFT JOIN manager AS m ON q.managerId = m.id
LEFT JOIN person AS p ON m.personId = p.id
LEFT JOIN document AS d ON p.documentId = d.id
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

