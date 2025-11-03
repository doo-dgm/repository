package co.edu.uco.treepruning.data.dao.entity.sql;

public final class PQRSql {

    public static final String CREATE = """
            INSERT INTO PQR (
                id,
                date,
                statusId,
                personId,
                sectorId,
                riskId,
                photoRecord
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
			SELECT
				pq.id as pqrId,
				pq.date AS pqrDate,
				sts.id AS statusId,
				sts.name AS statusName,
				pe.id as personPQRId,
				pe.firstName AS personPQRFirstName, 
				pe.middleName AS personPQRMiddleName,
				pe.surname AS personPQRSurname,
				pe.secondSurname AS personPQRSecondSurname,
				do.id as documentPersonPQRId,
				do.name AS documentPersonPQRName,
				do.code AS documentPersonPQRCode,
				pe.documentNumber AS personPQRDocumentNumber,
				pe.birthDate AS personPQRBirthDate,
				pe.address AS personPQRAddress,
				pe.email AS personPQREmail,
				pe.emailConfirmed AS personPQREmailConfirmed,
				pe.phone AS personPQRPhone,
				pe.phoneConfirmed AS personPQRPhoneConfirmed,
				pe.age AS personPQRAge,
				se.id AS sectorId,
				se.name AS sectorName,
				mu.id AS municipalityId,
				mu.name AS municipalityName,
				st.id AS stateId,
				st.name AS stateName,
				c.id AS countryId,
				c.name AS countryName,
				ri.id AS riskId,
				ri.name AS riskName,
				pq.photographicRecordPath AS pqrPhotographicRecordPath
				FROM pqr AS pq
			INNER JOIN status AS sts ON pq.statusId = sts.id
			INNER JOIN person AS pe ON pq.personId = pe.id
			INNER JOIN risk AS ri ON pq.riskId = ri.id
			INNER JOIN document AS do ON pe.documentId = do.id
			INNER JOIN sector AS se ON pq.sectorId = se.id
			INNER JOIN municipality AS mu ON se.municipalityId = mu.id
			INNER JOIN state AS st ON mu.stateId = st.id
			INNER JOIN country AS c ON st.countryId = c.id
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

