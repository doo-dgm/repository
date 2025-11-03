package co.edu.uco.treepruning.data.dao.entity.sql;

public final class StatusSql {

    public static final String CREATE = """
            INSERT INTO status (
                id,
                name
            )
            VALUES (?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                s.id AS statusId,
                s.name AS statusName
            FROM status AS s
            """;

    public static final String UPDATE = """
            UPDATE Status
            SET name = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM status
            WHERE id = ?
            """;
}
