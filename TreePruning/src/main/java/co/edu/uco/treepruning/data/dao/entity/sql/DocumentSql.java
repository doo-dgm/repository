package co.edu.uco.treepruning.data.dao.entity.sql;

public final class DocumentSql {

    public static final String CREATE = """
            INSERT INTO Document (
                id,
                name,
                code
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT
                d.id AS documentId,
                d.name AS documentName,
                d.code AS documentCode
            FROM Document AS d
            """;


    public static final String UPDATE = """
            UPDATE Document
            SET
                name = ?
                code = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Document
            WHERE id = ?
            """;
}

