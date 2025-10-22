package co.edu.uco.treepruning.data.dao.entity.sql;

public final class ProgrammingSql {

    public static final String CREATE = """
            INSERT INTO Programming (
                id,
                startDate,
                frequencyMonths,
                amount
            )
            VALUES (?, ?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                p.id,
                p.startDate,
                p.frequencyMonths,
                p.amount
            FROM Programming AS p
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                p.id,
                p.startDate,
                p.frequencyMonths,
                p.amount
            FROM Programming AS p
            WHERE (? IS NULL OR p.startDate = ?)
              AND (? IS NULL OR p.frequencyMonths = ?)
              AND (? IS NULL OR p.amount = ?)
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                p.id,
                p.startDate,
                p.frequencyMonths,
                p.amount
            FROM Programming AS p
            WHERE p.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Programming
            SET startDate = ?,
                frequencyMonths = ?,
                amount = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Programming
            WHERE id = ?
            """;
}

