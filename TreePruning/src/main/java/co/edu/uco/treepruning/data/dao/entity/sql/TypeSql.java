package co.edu.uco.treepruning.data.dao.entity.sql;

public final class TypeSql {

    public static final String CREATE = """
            INSERT INTO Type (
                id,
                name
            )
            VALUES (?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                id,
                name
            FROM Type
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                id,
                name
            FROM Type
            WHERE (? IS NULL OR name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                id,
                name
            FROM Type
            WHERE id = ?
            """;

    public static final String UPDATE = """
            UPDATE Type
            SET name = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Type
            WHERE id = ?
            """;
}

