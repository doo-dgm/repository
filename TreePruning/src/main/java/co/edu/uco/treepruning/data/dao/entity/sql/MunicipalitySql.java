package co.edu.uco.treepruning.data.dao.entity.sql;

public final class MunicipalitySql {

    public static final String CREATE = """
            INSERT INTO Municipality (
                id,
                name,
                stateId
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                m.id AS municipalityId,
                m.name AS municipalityName,
                s.id AS stateId,
                s.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Municipality AS m
            INNER JOIN State AS s ON m.stateId = s.id
            INNER JOIN Country AS c ON s.countryId = c.id
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

