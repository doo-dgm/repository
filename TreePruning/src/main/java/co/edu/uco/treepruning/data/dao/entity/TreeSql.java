package co.edu.uco.treepruning.data.dao.entity;

public final class TreeSql {

    public static final String CREATE = """
            INSERT INTO Tree (
                id,
                longitude,
                latitude,
                species,
                sector
            )
            VALUES (?, ?, ?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                t.id,
                t.longitude,
                t.latitude,
                f.id AS speciesId,
                f.scientificName AS speciesScientificName,
                f.commonName AS speciesCommonName,
                s.id AS sectorId,
                s.name AS sectorName,
                m.id AS municipalityId,
                m.name AS municipalityName,
                st.id AS stateId,
                st.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Tree AS t
            INNER JOIN Family AS f ON t.species = f.id
            INNER JOIN Sector AS s ON t.sector = s.id
            INNER JOIN Municipality AS m ON s.municipality = m.id
            INNER JOIN State AS st ON m.state = st.id
            INNER JOIN Country AS c ON st.country = c.id
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                t.id,
                t.longitude,
                t.latitude,
                f.id AS speciesId,
                f.scientificName AS speciesScientificName,
                f.commonName AS speciesCommonName,
                s.id AS sectorId,
                s.name AS sectorName,
                m.id AS municipalityId,
                m.name AS municipalityName,
                st.id AS stateId,
                st.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Tree AS t
            INNER JOIN Family AS f ON t.species = f.id
            INNER JOIN Sector AS s ON t.sector = s.id
            INNER JOIN Municipality AS m ON s.municipality = m.id
            INNER JOIN State AS st ON m.state = st.id
            INNER JOIN Country AS c ON st.country = c.id
            WHERE (? IS NULL OR f.scientificName LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR f.commonName LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR s.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR m.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR st.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR c.name LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                t.id,
                t.longitude,
                t.latitude,
                f.id AS speciesId,
                f.scientificName AS speciesScientificName,
                f.commonName AS speciesCommonName,
                s.id AS sectorId,
                s.name AS sectorName,
                m.id AS municipalityId,
                m.name AS municipalityName,
                st.id AS stateId,
                st.name AS stateName,
                c.id AS countryId,
                c.name AS countryName
            FROM Tree AS t
            INNER JOIN Family AS f ON t.species = f.id
            INNER JOIN Sector AS s ON t.sector = s.id
            INNER JOIN Municipality AS m ON s.municipality = m.id
            INNER JOIN State AS st ON m.state = st.id
            INNER JOIN Country AS c ON st.country = c.id
            WHERE t.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Tree
            SET longitude = ?,
                latitude = ?,
                species = ?,
                sector = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Tree
            WHERE id = ?
            """;
}

