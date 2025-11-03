package co.edu.uco.treepruning.data.dao.entity.sql;

public final class StateSql {

    public static final String CREATE = """
            INSERT INTO State (
                id,
                name,
                countryId
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                st.id AS stateId,
                st.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM State AS st
            INNER JOIN Country AS c ON st.countryId = c.id
            """;


    public static final String UPDATE = """
            UPDATE State
            SET name = ?,
                countryId = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM State
            WHERE id = ?
            """;
}
