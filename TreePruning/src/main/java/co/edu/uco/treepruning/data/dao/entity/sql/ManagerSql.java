package co.edu.uco.treepruning.data.dao.entity.sql;

public final class ManagerSql {

    public static final String CREATE = """
            INSERT INTO Manager (
                id,
                person
            )
            VALUES (?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT
                m.id as managerId,
                p.id AS personId,
                p.firstName AS personFirstName, 
                p.middleName AS personMiddleName,
                p.surname AS personSurname,
                p.secondSurname AS personSecondSurname,
                d.id as documentId,
                d.name AS documentName,
                d.code AS documentCode,
                p.documentNumber AS personDocumentNumber,
                p.birthDate AS personBirthDate,
                p.address AS personAddress,
                p.email AS personEmail,
                p.emailConfirmed AS personEmailConfirmed,
                p.phone AS personPhone,
                p.phoneConfirmed AS personPhoneConfirmed,
                p.age AS personAge
            FROM Manager AS m
            INNER JOIN Person AS p ON m.personId = p.id
            INNER JOIN Document AS d ON p.documentId = d.id
            """;

    public static final String UPDATE = """
            UPDATE Manager
            SET person = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Manager
            WHERE id = ?
            """;
}

