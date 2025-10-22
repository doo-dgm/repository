package co.edu.uco.treepruning.data.dao.entity.sql;

public final class PQRSql {

    public static final String CREATE = """
            INSERT INTO PQR (
                id,
                date,
                status,
                risk,
                sector,
                person,
                photoRecord
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                p.id,
                p.date,
                p.status,
                p.risk,
                s.id AS sectorId,
                s.name AS sectorName,
                per.id AS personId,
                per.firstName AS personFirstName,
                per.lastName AS personLastName,
                p.photoRecord
            FROM PQR AS p
            INNER JOIN Sector AS s ON p.sector = s.id
            INNER JOIN Person AS per ON p.person = per.id
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                p.id,
                p.date,
                p.status,
                p.risk,
                s.id AS sectorId,
                s.name AS sectorName,
                per.id AS personId,
                per.firstName AS personFirstName,
                per.lastName AS personLastName,
                p.photoRecord
            FROM PQR AS p
            INNER JOIN Sector AS s ON p.sector = s.id
            INNER JOIN Person AS per ON p.person = per.id
            WHERE (? IS NULL OR p.status LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR p.risk LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR s.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR per.firstName LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                p.id,
                p.date,
                p.status,
                p.risk,
                s.id AS sectorId,
                s.name AS sectorName,
                per.id AS personId,
                per.firstName AS personFirstName,
                per.lastName AS personLastName,
                p.photoRecord
            FROM PQR AS p
            INNER JOIN Sector AS s ON p.sector = s.id
            INNER JOIN Person AS per ON p.person = per.id
            WHERE p.id = ?
            """;

    public static final String UPDATE = """
            UPDATE PQR
            SET date = ?,
                status = ?,
                risk = ?,
                sector = ?,
                person = ?,
                photoRecord = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM PQR
            WHERE id = ?
            """;
}

