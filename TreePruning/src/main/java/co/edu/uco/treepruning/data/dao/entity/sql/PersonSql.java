package co.edu.uco.treepruning.data.dao.entity.sql;

public final class PersonSql {

    public static final String CREATE = """
            INSERT INTO Person (
                id,
                firstName,
                middleName,
                surname,
                secondSurname,
                document,
                documentNumber,
                birthDate,
                address,
                email,
                emailConfirmed,
                phone,
                phoneConfirmed,
                age
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                p.id as personId,
                p.firstName AS personFirstName, 
                p.middleName AS personMiddleName,
                p.surname AS personSurname,
                p.secondSurname AS personSecondSurname,
                d.documentId as documentId,
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
            FROM Person as p
            INNER JOIN Document AS d ON p.documentId = d.id
            """;

    public static final String UPDATE = """
            UPDATE Person
            SET firstName = ?,
                middleName = ?,
                lastName = ?,
                secondLastName = ?,
                document = ?,
                documentNumber = ?,
                birthDate = ?,
                address = ?,
                email = ?,
                emailConfirmed = ?,
                phone = ?,
                phoneConfirmed = ?,
                age = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Person
            WHERE id = ?
            """;
}

