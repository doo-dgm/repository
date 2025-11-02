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
                p.id,
                p.firstName,
                p.middleName,
                p.surname,
                p.secondSurname,
                d.id as documentId,
                p.documentNumber,
                p.birthDate,
                p.address,
                p.email,
                p.emailConfirmed,
                p.phone,
                p.phoneConfirmed,
                p.age
            FROM Person as p
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

