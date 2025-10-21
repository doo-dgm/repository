package co.edu.uco.treepruning.data.dao.entity;

public final class FamilySql {

    public static final String CREATE = """
            INSERT INTO Family (
                id,
                scientificName,
                commonName
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT
                f.id,
                f.scientificName,
                f.commonName
            FROM Family AS f
            """;

    public static final String FIND_BY_FILTER = """
            SELECT
                f.id,
                f.scientificName,
                f.commonName
            FROM Family AS f
            WHERE (? IS NULL OR f.scientificName LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR f.commonName LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT
                f.id,
                f.scientificName,
                f.commonName
            FROM Family AS f
            WHERE f.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Family
            SET
                scientificName = ?,
                commonName = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Family
            WHERE id = ?
            """;
}

