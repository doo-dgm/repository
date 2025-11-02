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
                q.id,
                q.quadrilleName,
                m.managerId,
                p.id AS personId,
                p.firstName,
                p.secondName,
                p.lastName,
                p.secondLastName
            FROM Quadrille AS q
            INNER JOIN Manager AS m ON q.manager_id = m.id
            INNER JOIN Person AS p ON m.person = p.id
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

