package co.edu.uco.treepruning.data.dao.entity.sql;

public final class CountrySql {

    public static final String CREATE = """
            INSERT INTO Country (
                id,
                name
            )
            VALUES (?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT
                c.id,
                c.name
            FROM Country AS c
            """;

    public static final String FIND_BY_FILTER = """
            SELECT
                c.id,
                c.name
            FROM Country AS c
            WHERE (? IS NULL OR c.name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT
                c.id,
                c.name
            FROM Country AS c
            WHERE c.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Country
            SET
                name = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Country
            WHERE id = ?
            """;
}

