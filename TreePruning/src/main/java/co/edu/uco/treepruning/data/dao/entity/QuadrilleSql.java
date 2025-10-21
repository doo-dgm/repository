package co.edu.uco.treepruning.data.dao.entity;

public final class QuadrilleSql {

    public static final String CREATE = """
            INSERT INTO Quadrille (
                id,
                name,
                manager
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                q.id,
                q.name AS quadrilleName,
                m.id AS managerId,
                p.id AS personId,
                p.firstName,
                p.secondName,
                p.lastName,
                p.secondLastName
            FROM Quadrille AS q
            INNER JOIN Manager AS m ON q.manager = m.id
            INNER JOIN Person AS p ON m.person = p.id
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                q.id,
                q.name AS quadrilleName,
                m.id AS managerId,
                p.id AS personId,
                p.firstName,
                p.secondName,
                p.lastName,
                p.secondLastName
            FROM Quadrille AS q
            INNER JOIN Manager AS m ON q.manager = m.id
            INNER JOIN Person AS p ON m.person = p.id
            WHERE (? IS NULL OR q.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR p.firstName LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR p.lastName LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                q.id,
                q.name AS quadrilleName,
                m.id AS managerId,
                p.id AS personId,
                p.firstName,
                p.secondName,
                p.lastName,
                p.secondLastName
            FROM Quadrille AS q
            INNER JOIN Manager AS m ON q.manager = m.id
            INNER JOIN Person AS p ON m.person = p.id
            WHERE q.id = ?
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

