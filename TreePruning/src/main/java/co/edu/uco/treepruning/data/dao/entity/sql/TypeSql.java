package co.edu.uco.treepruning.data.dao.entity.sql;

public final class TypeSql {

    public static final String CREATE = """
            INSERT INTO Type (
                id,
                name
            )
            VALUES (?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                t.id AS typeId,
                t.name AS typeName
            FROM Type AS t
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

