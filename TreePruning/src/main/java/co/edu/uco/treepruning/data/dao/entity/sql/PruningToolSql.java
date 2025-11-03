package co.edu.uco.treepruning.data.dao.entity.sql;

public final class PruningToolSql {

    public static final String CREATE = """
            INSERT INTO PruningTool (
                id,
                pruning,
                tool
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                pt.id,
                p.id AS pruningId,
                p.plannedDate AS pruningPlannedDate,
                p.executedDate AS pruningExecutedDate,
                t.id AS toolId,
                t.name AS toolName,
                t.description AS toolDescription
            FROM PruningTool AS pt
            INNER JOIN Pruning AS p ON pt.pruning = p.id
            INNER JOIN Tool AS t ON pt.tool = t.id
            """;


    public static final String UPDATE = """
            UPDATE PruningTool
            SET pruning = ?,
                tool = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM PruningTool
            WHERE id = ?
            """;
}

