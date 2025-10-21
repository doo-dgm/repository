package co.edu.uco.treepruning.data.dao.entity;

public final class PersonSql {

    public static final String CREATE = """
            INSERT INTO Person (
                id,
                firstName,
                middleName,
                lastName,
                secondLastName,
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

    public static final String FIND_ALL = """
            SELECT 
                id,
                firstName,
                middleName,
                lastName,
                secondLastName,
                document,
                documentNumber,
                birthDate,
                address,
                email,
                emailConfirmed,
                phone,
                phoneConfirmed,
                age
            FROM Person
            """;

    public static final String FIND_BY_FILTER = """
            SELECT 
                id,
                firstName,
                middleName,
                lastName,
                secondLastName,
                document,
                documentNumber,
                birthDate,
                address,
                email,
                emailConfirmed,
                phone,
                phoneConfirmed,
                age
            FROM Person
            WHERE (? IS NULL OR firstName LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR lastName LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR documentNumber LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR email LIKE CONCAT('%', ?, '%'))
            """;

    public static final String FIND_BY_ID = """
            SELECT 
                id,
                firstName,
                middleName,
                lastName,
                secondLastName,
                document,
                documentNumber,
                birthDate,
                address,
                email,
                emailConfirmed,
                phone,
                phoneConfirmed,
                age
            FROM Person
            WHERE id = ?
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

