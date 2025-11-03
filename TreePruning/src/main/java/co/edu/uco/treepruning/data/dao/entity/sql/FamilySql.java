package co.edu.uco.treepruning.data.dao.entity.sql;

public final class FamilySql {

    public static final String CREATE = """
            INSERT INTO Family (
                id,
                scientificName,
                commonName
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT
                f.id AS familyId,
                f.scientificName AS familyScientificName,
                f.commonName AS familyCommonName
            FROM Family AS f
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

