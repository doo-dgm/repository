package co.edu.uco.treepruning.data.dao.entity;

public final class SectorSql {

    public static final String CREATE = """
            INSERT INTO Sector (
                id,
                name,
                municipality
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                s.id,
                s.name,
                m.id AS municipalityId,
                m.name AS municipalityName,
                st.id AS stateId,
                st.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Sector AS s
            INNER JOIN Municipality AS m ON s.municipality = m.id
            INNER JOIN State AS st ON m.state = st.id
            INNER JOIN Country AS c ON st.country = c.id
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                s.id,
                s.name,
                m.id AS municipalityId,
                m.name AS municipalityName,
                st.id AS stateId,
                st.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Sector AS s
            INNER JOIN Municipality AS m ON s.municipality = m.id
            INNER JOIN State AS st ON m.state = st.id
            INNER JOIN Country AS c ON st.country = c.id
            WHERE (? IS NULL OR s.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR m.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR st.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR c.name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                s.id,
                s.name,
                m.id AS municipalityId,
                m.name AS municipalityName,
                st.id AS stateId,
                st.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Sector AS s
            INNER JOIN Municipality AS m ON s.municipality = m.id
            INNER JOIN State AS st ON m.state = st.id
            INNER JOIN Country AS c ON st.country = c.id
            WHERE s.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Sector
            SET name = ?,
                municipality = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Sector
            WHERE id = ?
            """;
}

