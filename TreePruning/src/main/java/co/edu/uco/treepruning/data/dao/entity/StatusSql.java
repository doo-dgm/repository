package co.edu.uco.treepruning.data.dao.entity;

public final class StatusSql {

    public static final String CREATE = """
            INSERT INTO Status (
                id,
                name
            )
            VALUES (?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                s.id,
                s.name
            FROM Status AS s
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                s.id,
                s.name
            FROM Status AS s
            WHERE (? IS NULL OR s.name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                s.id,
                s.name
            FROM Status AS s
            WHERE s.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Status
            SET name = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Status
            WHERE id = ?
            """;
}
