package co.edu.uco.treepruning.data.dao.entity;

public final class OperatorSql {

    public static final String CREATE = """
            INSERT INTO Operator (
                id,
                person,
                cuadrille
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                o.id,
                p.id AS personId,
                p.name AS personName,
                p.lastName AS personLastName,
                q.id AS cuadrilleId,
                q.name AS cuadrilleName
            FROM Operator AS o
            INNER JOIN Person AS p ON o.person = p.id
            INNER JOIN Cuadrille AS q ON o.cuadrille = q.id
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                o.id,
                p.id AS personId,
                p.name AS personName,
                p.lastName AS personLastName,
                q.id AS cuadrilleId,
                q.name AS cuadrilleName
            FROM Operator AS o
            INNER JOIN Person AS p ON o.person = p.id
            INNER JOIN Cuadrille AS q ON o.cuadrille = q.id
            WHERE (? IS NULL OR p.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR p.lastName LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR q.name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                o.id,
                p.id AS personId,
                p.name AS personName,
                p.lastName AS personLastName,
                q.id AS cuadrilleId,
                q.name AS cuadrilleName
            FROM Operator AS o
            INNER JOIN Person AS p ON o.person = p.id
            INNER JOIN Cuadrille AS q ON o.cuadrille = q.id
            WHERE o.id = ?
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

