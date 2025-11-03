package co.edu.uco.treepruning.data.dao.entity.sql;

public final class ToolSql {

    public static final String CREATE = """
            INSERT INTO Tool (
                id,
                name,
                description
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                t.id AS toolId,
                t.name AS toolName,
                t.description AS toolDescription
            FROM Tool AS t
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

