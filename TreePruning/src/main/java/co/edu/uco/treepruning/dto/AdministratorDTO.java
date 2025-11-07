package co.edu.uco.treepruning.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class AdministratorDTO {

    private UUID id;
    private String username;
    private String email;
    private boolean emailConfirmed;
    private String mobilePhone;
    private boolean mobilePhoneConfirmed;

    public AdministratorDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setUsername(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setMobilePhone(TextHelper.getDefault());
        setMobilePhoneConfirmed(false);
    }

    public AdministratorDTO(final UUID id) {
        setId(id);
        setUsername(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setMobilePhone(TextHelper.getDefault());
        setMobilePhoneConfirmed(false);
    }

    public AdministratorDTO(final UUID id, final String username, final String email, final boolean emailConfirmed,
                            final String mobilePhone, final boolean mobilePhoneConfirmed) {
        setId(id);
        setUsername(username);
        setEmail(email);
        setEmailConfirmed(emailConfirmed);
        setMobilePhone(mobilePhone);
        setMobilePhoneConfirmed(mobilePhoneConfirmed);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = TextHelper.getDefaultWithTrim(username);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(final String mobilePhone) {
        this.mobilePhone = TextHelper.getDefaultWithTrim(mobilePhone);
    }

    public boolean isMobilePhoneConfirmed() {
        return mobilePhoneConfirmed;
    }

    public void setMobilePhoneConfirmed(final boolean mobilePhoneConfirmed) {
        this.mobilePhoneConfirmed = mobilePhoneConfirmed;
    }
}

