package co.edu.uco.treepruning.data.dao.entity;

public final class StateSql {

    public static final String CREATE = """
            INSERT INTO State (
                id,
                name,
                country
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                st.id,
                st.name,
                c.id AS countryId,
                c.name AS countryName
            FROM State AS st
            INNER JOIN Country AS c ON st.country = c.id
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                st.id,
                st.name,
                c.id AS countryId,
                c.name AS countryName
            FROM State AS st
            INNER JOIN Country AS c ON st.country = c.id
            WHERE (? IS NULL OR st.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR c.name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                st.id,
                st.name,
                c.id AS countryId,
                c.name AS countryName
            FROM State AS st
            INNER JOIN Country AS c ON st.country = c.id
            WHERE st.id = ?
            """;

    public static final String UPDATE = """
            UPDATE State
            SET name = ?,
                country = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM State
            WHERE id = ?
            """;
}
