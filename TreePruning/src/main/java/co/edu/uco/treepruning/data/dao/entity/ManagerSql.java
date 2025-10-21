package co.edu.uco.treepruning.data.dao.entity;

public final class ManagerSql {

    public static final String CREATE = """
            INSERT INTO Manager (
                id,
                person
            )
            VALUES (?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT
                m.id,
                p.id AS personId,
                p.firstName,
                p.lastName
            FROM Manager AS m
            INNER JOIN Person AS p ON m.person = p.id
            """;

    public static final String FIND_BY_FILTER = """
            SELECT
                m.id,
                p.id AS personId,
                p.firstName,
                p.lastName
            FROM Manager AS m
            INNER JOIN Person AS p ON m.person = p.id
            WHERE (? IS NULL OR p.firstName LIKE CONCAT('%', ?, '%'))
              OR (? IS NULL OR p.lastName LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT
                m.id,
                p.id AS personId,
                p.firstName,
                p.lastName
            FROM Manager AS m
            INNER JOIN Person AS p ON m.person = p.id
            WHERE m.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Manager
            SET person = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Manager
            WHERE id = ?
            """;
}

