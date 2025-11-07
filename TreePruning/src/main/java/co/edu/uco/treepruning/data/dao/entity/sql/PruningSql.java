package co.edu.uco.treepruning.data.dao.entity.sql;

public final class PruningSql {

    public static final String CREATE = """
            INSERT INTO Pruning (
                id,
                statusId,
                plannedDate,
                executedDate,
                treeId,
                quadrilleId,
                typeId,
                pqrId,
                photographicReportPath,
                observations
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = 
"""
		SELECT
			pru.id AS pruningId,
			sts.id AS statusPruningId,
			sts.name AS statusPruningName,
			pru.plannedDate AS pruningPlannedDate,
			pru.executedDate AS pruningExecutedDate,
			tre.id AS treeId,
			tre.longitude AS treeLongitude,
			tre.latitude AS treeLatitude,
			fam.id AS familyId,
			fam.scientificName AS familyScientificName,
			fam.commonName AS familyCommonName,
			sec.id AS sectorTreeId,
			sec.name AS sectorTreeName,
			mun.id AS municipalityTreeId,
			mun.name AS municipalityTreeName,
			sta.id AS stateTreeId,
			sta.name AS stateTreeName,
			cou.id AS countryTreeId,
			cou.name AS countryTreeName,
			pro.id AS programmingId,
			pro.initialDate AS programmingInitialDate,
			pro.frequencyMonths AS programmingFrequencyMonths,
			pro.amount AS programmingAmount
			qua.id AS quadrilleId,
			qua.quadrilleName AS quadrilleName,
			man.id AS managerPruningId,
			per.id AS personManagerId,
			per.firstName AS personManagerFirstName,
			per.middleName AS personManagerMiddleName,
			per.surname AS personManagerSurname,
			per.secondSurname AS personManagerSecondSurname,
			doc.id AS documentManagerId,
			doc.name AS documentPersonManagerName,
			doc.code AS documentPersonManagerCode,
			per.documentNumber AS personManagerDocumentNumber,
			per.birthDate AS personManagerBirthDate,
			per.address AS personManagerAddress,
			per.email AS personManagerEmail,
			per.emailConfirmed AS personManagerEmailConfirmed,
			per.phone AS personManagerPhone,
			per.phoneConfirmed AS personManagerPhoneConfirmed,
			per.age AS personManagerAge,
			typ.id AS typeId,
			typ.name AS typeName,
			pqr.id AS pqrId,
			pqr.date AS pqrDate,
			stsp.id as statusPQRId,
			stsp.name AS statusPQRName, 
			perq.id AS personPQRId,
			perq.firstName AS personPQRFirstName,
			perq.middleName AS personPQRMiddleName,
			perq.surname AS personPQRSurname,
			perq.secondSurname AS personPQRSecondSurname,
			docp.id AS documentPersonPQRId,
			docp.name AS documentPersonPQRName,
			docp.code AS documentPersonPQRCode,
			perq.documentNumber AS personPQRDocumentNumber,
			perq.birthDate AS personPQRBirthDate,
			perq.address AS personPQRAddress,
			perq.email AS personPQREmail,
			perq.emailConfirmed AS personPQREmailConfirmed,
			perq.phone AS personPQRPhone,
			perq.phoneConfirmed AS personPQRPhoneConfirmed,
			perq.age AS personPQRAge,
			secp.id AS sectorPQRId,
			secp.name AS sectorPQRName,
			munp.id AS municipalityPQRId,
			munp.name AS municipalityPQRName,
			stap.id AS statePQRId,
			stap.name AS statePQRName,
			coup.id AS countryPQRId,
			coup.name AS countryPQRName,
			risp.id AS riskId,
			risp.name AS riskName,
			pqr.photographicRecordPath AS pqrPhotographicRecordPath,                
			pru.photographicReportPath AS pruningPhotographicReportPath,
			pru.observations AS pruningObservations
		FROM Pruning AS pru
		INNER JOIN Status AS sts ON pru.statusId = sts.id
		INNER JOIN Tree AS tre ON pru.treeId = tre.id
		INNER JOIN programming AS pro ON tre.programmingId = pro.id
		INNER JOIN Family AS fam ON tre.familyId = fam.id
		INNER JOIN Sector AS sec ON tre.sectorId = sec.id
		INNER JOIN Municipality AS mun ON sec.municipalityId = mun.id
		INNER JOIN State AS sta ON mun.stateId = sta.id
		INNER JOIN Country AS cou ON sta.countryId = cou.id
		INNER JOIN Quadrille AS qua ON pru.quadrilleId = qua.id
		INNER JOIN manager AS man ON qua.managerId = man.id
		INNER JOIN person AS per ON man.personId = per.id
		INNER JOIN document AS doc ON per.documentId = doc.id
		INNER JOIN type AS typ ON pru.typeId = typ.id
		LEFT JOIN pqr AS pqr ON pru.pqrId = pqr.id
		INNER JOIN status AS stsp ON pqr.statusId = stsp.id
		INNER JOIN person AS perq ON pqr.personId = perq.id
		INNER JOIN document AS docp ON perq.documentId = docp.id
		INNER JOIN sector AS secp ON pqr.sectorId = secp.id
		INNER JOIN Municipality AS munp ON secp.municipalityId = munp.id
		INNER JOIN State AS stap ON munp.stateId = stap.id
		INNER JOIN Country AS coup ON stap.countryId = coup.id
		INNER JOIN risk AS risp ON pqr.riskId = risp.id
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
                photographicReportPath = ?,
                observations = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Pruning
            WHERE id = ?
            """;
}
