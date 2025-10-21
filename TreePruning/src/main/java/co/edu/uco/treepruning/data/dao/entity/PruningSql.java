package co.edu.uco.treepruning.data.dao.entity;

public final class PruningSql {

    public static final String CREATE = """
            INSERT INTO Pruning (
                id,
                status,
                plannedDate,
                executedDate,
                tree,
                cuadrille,
                type,
                pqr,
                programming,
                photoRecord,
                observations
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static final String FIND_ALL = """
            SELECT 
                p.id,
                p.status,
                s.name AS statusName,
                p.plannedDate,
                p.executedDate,
                t.id AS treeId,
                t.scientificName AS treeScientificName,
                q.id AS cuadrilleId,
                q.name AS cuadrilleName,
                ty.id AS typeId,
                ty.name AS typeName,
                pq.id AS pqrId,
                pq.date AS pqrDate,
                pr.id AS programmingId,
                pr.startDate AS programmingStartDate,
                p.photoRecord,
                p.observations
            FROM Pruning AS p
            INNER JOIN Status AS s ON p.status = s.id
            INNER JOIN Tree AS t ON p.tree = t.id
            INNER JOIN Quadrille AS q ON p.cuadrille = q.id
            INNER JOIN Type AS ty ON p.type = ty.id
            INNER JOIN PQR AS pq ON p.pqr = pq.id
            INNER JOIN Programming AS pr ON p.programming = pr.id
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                p.id,
                p.status,
                s.name AS statusName,
                p.plannedDate,
                p.executedDate,
                t.id AS treeId,
                t.scientificName AS treeScientificName,
                q.id AS cuadrilleId,
                q.name AS cuadrilleName,
                ty.id AS typeId,
                ty.name AS typeName,
                pq.id AS pqrId,
                pq.date AS pqrDate,
                pr.id AS programmingId,
                pr.startDate AS programmingStartDate,
                p.photoRecord,
                p.observations
            FROM Pruning AS p
            INNER JOIN Status AS s ON p.status = s.id
            INNER JOIN Tree AS t ON p.tree = t.id
            INNER JOIN Quadrille AS q ON p.cuadrille = q.id
            INNER JOIN Type AS ty ON p.type = ty.id
            INNER JOIN PQR AS pq ON p.pqr = pq.id
            INNER JOIN Programming AS pr ON p.programming = pr.id
            WHERE (? IS NULL OR s.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR t.scientificName LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR q.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR ty.name LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR p.plannedDate = ?)
              AND (? IS NULL OR p.executedDate = ?)
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                p.id,
                p.status,
                s.name AS statusName,
                p.plannedDate,
                p.executedDate,
                t.id AS treeId,
                t.scientificName AS treeScientificName,
                q.id AS cuadrilleId,
                q.name AS cuadrilleName,
                ty.id AS typeId,
                ty.name AS typeName,
                pq.id AS pqrId,
                pq.date AS pqrDate,
                pr.id AS programmingId,
                pr.startDate AS programmingStartDate,
                p.photoRecord,
                p.observations
            FROM Pruning AS p
            INNER JOIN Status AS s ON p.status = s.id
            INNER JOIN Tree AS t ON p.tree = t.id
            INNER JOIN Quadrille AS q ON p.cuadrille = q.id
            INNER JOIN Type AS ty ON p.type = ty.id
            INNER JOIN PQR AS pq ON p.pqr = pq.id
            INNER JOIN Programming AS pr ON p.programming = pr.id
            WHERE p.id = ?
            """;

    public static final String UPDATE = """
            UPDATE Pruning
            SET status = ?,
                plannedDate = ?,
                executedDate = ?,
                tree = ?,
                cuadrille = ?,
                type = ?,
                pqr = ?,
                programming = ?,
                photoRecord = ?,
                observations = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Pruning
            WHERE id = ?
            """;
}
