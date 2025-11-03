package co.edu.uco.treepruning.data.dao.entity.sql;

public final class RiskSql {

    public static final String CREATE = """
            INSERT INTO Risk (
                id,
                name
            )
            VALUES (?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                r.id AS riskId,
                r.name AS riskName
            FROM risk AS r
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

