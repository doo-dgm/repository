package co.edu.uco.treepruning.data.dao.entity.sql;

public final class ProgrammingSql {

    public static final String CREATE = """
            INSERT INTO Programming (
                id,
                initial_date,
                frequency_months,
                amount
            )
            VALUES (?, ?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                p.id,
                p.initial_date,
                p.frequency_months,
                p.amount
            FROM Programming AS p
            """;


    public static final String UPDATE = """
            UPDATE Programming
            SET initial_date = ?,
                frequency_months = ?,
                amount = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Programming
            WHERE id = ?
            """;
}

