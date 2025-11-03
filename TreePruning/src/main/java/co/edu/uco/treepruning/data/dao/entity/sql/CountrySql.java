package co.edu.uco.treepruning.data.dao.entity.sql;

public final class CountrySql {

    public static final String CREATE = """
            INSERT INTO Country (
                id,
                name
            )
            VALUES (?, ?)
            """;


    public static final String FIND_BY_FILTER = """
            SELECT
                c.id as countryId,
                c.name AS countryName
            FROM Country AS c
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

