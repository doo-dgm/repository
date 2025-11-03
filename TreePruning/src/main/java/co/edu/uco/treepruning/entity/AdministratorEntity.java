package co.edu.uco.treepruning.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class AdministratorEntity {

    private UUID id;
    private String username;
    private String email;
    private boolean emailConfirmed;
    private boolean emailConfirmedIsDefaultvalue;
    private String mobilePhone;
    private boolean mobilePhoneConfirmed;
    private boolean mobilePhoneConfirmedIsDefaultvalue;

    public AdministratorEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setUsername(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultvalue(true);
        setMobilePhone(TextHelper.getDefault());
        setMobilePhoneConfirmed(false);
        setMobilePhoneConfirmedIsDefaultvalue(true);
    }

    public AdministratorEntity(final UUID id) {
        setId(id);
        setUsername(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultvalue(true);
        setMobilePhone(TextHelper.getDefault());
        setMobilePhoneConfirmed(false);
        setMobilePhoneConfirmedIsDefaultvalue(true);
    }

    public AdministratorEntity(final UUID id, final String username, final String email,
                               final boolean emailConfirmed, final String mobilePhone, final boolean mobilePhoneConfirmed) {
        setId(id);
        setUsername(username);
        setEmail(email);
        setEmailConfirmed(emailConfirmed);
        setEmailConfirmedIsDefaultvalue(false);
        setMobilePhone(mobilePhone);
        setMobilePhoneConfirmed(mobilePhoneConfirmed);
        setMobilePhoneConfirmedIsDefaultvalue(false);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getUsername() {
        return TextHelper.getDefaultWithTrim(username);
    }

    public void setUsername(final String username) {
        this.username = TextHelper.getDefaultWithTrim(username);
    }

    public String getEmail() {
        return TextHelper.getDefaultWithTrim(email);
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
    
    public boolean isEmailConfirmedIsDefaultvalue() {
		return emailConfirmedIsDefaultvalue;
	}
    
    private void setEmailConfirmedIsDefaultvalue(final boolean emailConfirmedIsDefaultvalue) {
    	this.emailConfirmedIsDefaultvalue = emailConfirmedIsDefaultvalue;
    }

    public String getMobilePhone() {
        return TextHelper.getDefaultWithTrim(mobilePhone);
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
    
    public boolean isMobilePhoneConfirmedIsDefaultvalue() {
    	return mobilePhoneConfirmedIsDefaultvalue;
    }
    
    private void setMobilePhoneConfirmedIsDefaultvalue(final boolean mobilePhoneConfirmedIsDefaultvalue) {
		this.mobilePhoneConfirmedIsDefaultvalue = mobilePhoneConfirmedIsDefaultvalue;
	}
}

