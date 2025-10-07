package co.edu.uco.treepruning.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.NumericHelper;

public final class PersonDomain extends Domain {
    
    private String firstName;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private DocumentDomain document;
    private String documentNumber;
    private LocalDate birthDate;
    private String address;
    private String email;
    private boolean emailConfirmed;
    private String mobilePhone;
    private boolean mobilePhoneConfirmed;
    private int age;

    public PersonDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setLastName(TextHelper.getDefault());
        setSecondLastName(TextHelper.getDefault());
        setDocument(new DocumentDomain());
        setDocumentNumber(TextHelper.getDefault());
        setBirthDate(LocalDate.now());
        setAddress(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setMobilePhone(TextHelper.getDefault());
        setMobilePhoneConfirmed(false);
        setAge(NumericHelper.getDefaultInt());
    }

    public PersonDomain(final UUID id) {
        super(id);
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setLastName(TextHelper.getDefault());
        setSecondLastName(TextHelper.getDefault());
        setDocument(new DocumentDomain());
        setDocumentNumber(TextHelper.getDefault());
        setBirthDate(LocalDate.now());
        setAddress(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setMobilePhone(TextHelper.getDefault());
        setMobilePhoneConfirmed(false);
        setAge(NumericHelper.getDefaultInt());
    }

    public PersonDomain(final UUID id, final String firstName, final String secondName, final String lastName,
                        final String secondLastName, final DocumentDomain document, final String documentNumber,
                        final LocalDate birthDate, final String address, final String email, final boolean emailConfirmed,
                        final String mobilePhone, final boolean mobilePhoneConfirmed, final int age) {
        super(id);
        setFirstName(firstName);
        setSecondName(secondName);
        setLastName(lastName);
        setSecondLastName(secondLastName);
        setDocument(document);
        setDocumentNumber(documentNumber);
        setBirthDate(birthDate);
        setAddress(address);
        setEmail(email);
        setEmailConfirmed(emailConfirmed);
        setMobilePhone(mobilePhone);
        setMobilePhoneConfirmed(mobilePhoneConfirmed);
        setAge(age);
    }

    public String getFirstName() {
        return TextHelper.getDefaultWithTrim(firstName);
    }

    public void setFirstName(final String firstName) {
        this.firstName = TextHelper.getDefaultWithTrim(firstName);
    }

    public String getSecondName() {
        return TextHelper.getDefaultWithTrim(secondName);
    }

    public void setSecondName(final String secondName) {
        this.secondName = TextHelper.getDefaultWithTrim(secondName);
    }

    public String getLastName() {
        return TextHelper.getDefaultWithTrim(lastName);
    }

    public void setLastName(final String lastName) {
        this.lastName = TextHelper.getDefaultWithTrim(lastName);
    }

    public String getSecondLastName() {
        return TextHelper.getDefaultWithTrim(secondLastName);
    }

    public void setSecondLastName(final String secondLastName) {
        this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
    }

    public DocumentDomain getDocument() {
        return document;
    }

    public void setDocument(final DocumentDomain document) {
        this.document = ObjectHelper.isNull(document) ? new DocumentDomain() : document;
    }

    public String getDocumentNumber() {
        return TextHelper.getDefaultWithTrim(documentNumber);
    }

    public void setDocumentNumber(final String documentNumber) {
        this.documentNumber = TextHelper.getDefaultWithTrim(documentNumber);
    }

    public LocalDate getBirthDate() {
        return ObjectHelper.getDefault(birthDate, LocalDate.now());
    }

    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = ObjectHelper.getDefault(birthDate, LocalDate.now());
    }

    public String getAddress() {
        return TextHelper.getDefaultWithTrim(address);
    }

    public void setAddress(final String address) {
        this.address = TextHelper.getDefaultWithTrim(address);
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

    public int getAge() {
        return NumericHelper.getDefaultInt(age);
    }

    public void setAge(final int age) {
        this.age = NumericHelper.getDefaultInt(age);
    }
}
