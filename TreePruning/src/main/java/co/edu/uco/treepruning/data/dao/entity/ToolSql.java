package co.edu.uco.treepruning.data.dao.entity;

public final class ToolSql {

    public static final String CREATE = """
            INSERT INTO Tool (
                id,
                name,
                description
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                t.id,
                t.name,
                t.description
            FROM Tool AS t
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                t.id,
                t.name,
                t.description
            FROM Tool AS t
            WHERE (? IS NULL OR t.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR t.description LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                t.id,
                t.name,
                t.description
            FROM Tool AS t
            WHERE t.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Tool
            SET name = ?,
                description = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Tool
            WHERE id = ?
            """;
}

