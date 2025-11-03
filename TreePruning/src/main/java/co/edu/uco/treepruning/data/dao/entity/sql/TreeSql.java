package co.edu.uco.treepruning.data.dao.entity.sql;

public final class TreeSql {

    public static final String CREATE = """
            INSERT INTO Tree (
                id,
                longitude,
                latitude,
                familyId,
                sectorId
            )
            VALUES (?, ?, ?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                t.id AS treeId,
                t.longitude AS treeLongitude,
                t.latitude AS treeLatitude,
                f.id AS familyId,
                f.scientificName AS familyScientificName,
                f.commonName AS familyCommonName,
                s.id AS sectorTreeId,
                s.name AS sectorTreeName,
                m.id AS municipalityTreeId,
                m.name AS municipalityTreeName,
                st.id AS stateTreeId,
                st.name AS stateTreeName,
                c.id AS countryTreeId,
                c.name AS countryTreeName
            FROM Tree AS t
            INNER JOIN Family AS f ON t.familyId = f.id
            INNER JOIN Sector AS s ON t.sectorId = s.id
            INNER JOIN Municipality AS m ON s.municipalityId = m.id
            INNER JOIN State AS st ON m.stateId = st.id
            INNER JOIN Country AS c ON st.countryId = c.id
            """;

    public static final String UPDATE = """
            UPDATE tree
            SET longitude = ?,
                latitude = ?,
                familyId = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM tree
            WHERE id = ?
            """;
}

