package co.edu.uco.treepruning.data.dao.entity;

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

    public static final String FIND_ALL = """
            SELECT
                a.id,
                a.username,
                a.email,
                a.emailConfirmed,
                a.mobilePhone,
                a.mobilePhoneConfirmed
            FROM Administrator AS a
            """;

    public static final String FIND_BY_FILTER = """
            SELECT
                a.id,
                a.username,
                a.email,
                a.emailConfirmed,
                a.mobilePhone,
                a.mobilePhoneConfirmed
            FROM Administrator AS a
            WHERE (? IS NULL OR a.username LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR a.email LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR a.email_confirmed = ?)
              AND (? IS NULL OR a.mobile_phone LIKE CONCAT('%', ?, '%'))
              AND (? IS NULL OR a.mobile_phone_confirmed = ?)
            """;

    public static final String FIND_BY_ID = """
            SELECT
                a.id,
                a.username,
                a.email,
                a.emailConfirmed,
                a.mobilePhone,
                a.mobilePhoneConfirmed
            FROM Administrator AS a
            WHERE a.id = ?
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
