package co.edu.uco.treepruning.data.dao.entity.sql;

public final class AdministratorSql {

    public static final String CREATE = """
            INSERT INTO Administrator (
                id,
                username,
                email,
                emailConfirmed,
                mobilePhone,
                mobilePhoneConfirmed
            )
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    public static final String FIND_BY_FILTER = """
		SELECT
		    a.id AS administratorId,
		    a.username AS administratorUsername,
		    a.email AS administratorEmail,
		    a.emailConfirmed AS administratorEmailConfirmed,
		    a.phone AS administratorMobilePhone,
		    a.phoneConfirmed AS administratorMobilePhoneConfirmed
		FROM Administrator AS a
    		""";

    public static final String UPDATE = """
            UPDATE Administrator
            SET
                username = ?,
                email = ?,
                emailConfirmed = ?,
                mobilePhone = ?,
                mobilePhoneConfirmed = ?
            WHERE id = ?
            """;

    public static final String DELETE = """
            DELETE
            FROM Administrator
            WHERE id = ?
            """;
}
