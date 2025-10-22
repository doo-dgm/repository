package co.edu.uco.treepruning.data.dao.entity.sql;

public final class RiskSql {

    public static final String CREATE = """
            INSERT INTO Risk (
                id,
                name
            )
            VALUES (?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                r.id,
                r.name
            FROM Risk AS r
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                r.id,
                r.name
            FROM Risk AS r
            WHERE (? IS NULL OR r.name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                r.id,
                r.name
            FROM Risk AS r
            WHERE r.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Risk
            SET name = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Risk
            WHERE id = ?
            """;
}

