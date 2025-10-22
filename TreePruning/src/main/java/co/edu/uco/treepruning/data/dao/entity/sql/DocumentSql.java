package co.edu.uco.treepruning.data.dao.entity.sql;

public final class DocumentSql {

    public static final String CREATE = """
            INSERT INTO Document (
                id,
                name
            )
            VALUES (?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT
                d.id,
                d.name
            FROM Document AS d
            """;

    public static final String FIND_BY_FILTER = """
            SELECT
                d.id,
                d.name
            FROM Document AS d
            WHERE (? IS NULL OR d.name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT
                d.id,
                d.name
            FROM Document AS d
            WHERE d.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Document
            SET
                name = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Document
            WHERE id = ?
            """;
}

