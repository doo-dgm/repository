package co.edu.uco.treepruning.data.dao.entity;

public final class MunicipalitySql {

    public static final String CREATE = """
            INSERT INTO Municipality (
                id,
                name,
                state
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                m.id,
                m.name,
                s.id AS stateId,
                s.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Municipality AS m
            INNER JOIN State AS s ON m.state = s.id
            INNER JOIN Country AS c ON s.country = c.id
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                m.id,
                m.name,
                s.id AS stateId,
                s.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Municipality AS m
            INNER JOIN State AS s ON m.state = s.id
            INNER JOIN Country AS c ON s.country = c.id
            WHERE (? IS NULL OR m.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR s.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR c.name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                m.id,
                m.name,
                s.id AS stateId,
                s.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Municipality AS m
            INNER JOIN State AS s ON m.state = s.id
            INNER JOIN Country AS c ON s.country = c.id
            WHERE m.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Municipality
            SET name = ?,
                state = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Municipality
            WHERE id = ?
            """;
}

