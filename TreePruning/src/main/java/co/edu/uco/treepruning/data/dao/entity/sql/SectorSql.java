package co.edu.uco.treepruning.data.dao.entity.sql;

public final class SectorSql {

    public static final String CREATE = """
            INSERT INTO Sector (
                id,
                name,
                municipalityId
            )
            VALUES (?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                s.id AS sectorId,
                s.name AS sectorName,
                m.id AS municipalityId,
                m.name AS municipalityName,
                st.id AS stateId,
                st.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Sector AS s
            INNER JOIN Municipality AS m ON s.municipalityId = m.id
            INNER JOIN State AS st ON m.stateId = st.id
            INNER JOIN Country AS c ON st.countryId = c.id
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

