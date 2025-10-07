package co.edu.uco.treepruning.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class PersonDTO {

    private UUID id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private DocumentDTO document;
    private String documentNumber;
    private LocalDate birthDate;
    private String address;
    private String email;
    private boolean emailConfirmed;
    private String phone;
    private boolean phoneConfirmed;
    private int age;

    public PersonDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstLastName(TextHelper.getDefault());
        setSecondLastName(TextHelper.getDefault());
        setDocument(null);
        setDocumentNumber(TextHelper.getDefault());
        setBirthDate(LocalDate.now());
        setAddress(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setPhone(TextHelper.getDefault());
        setPhoneConfirmed(false);
        setAge(0);
    }

    public PersonDTO(final UUID id) {
        setId(id);
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstLastName(TextHelper.getDefault());
        setSecondLastName(TextHelper.getDefault());
        setDocument(null);
        setDocumentNumber(TextHelper.getDefault());
        setBirthDate(LocalDate.now());
        setAddress(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setPhone(TextHelper.getDefault());
        setPhoneConfirmed(false);
        setAge(0);
    }

    public PersonDTO(final UUID id, final String firstName, final String secondName, final String firstLastName,
                     final String secondLastName, final DocumentDTO document, final String documentNumber,
                     final LocalDate birthDate, final String address, final String email, final boolean emailConfirmed,
                     final String phone, final boolean phoneConfirmed, final int age) {
        setId(id);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstLastName(firstLastName);
        setSecondLastName(secondLastName);
        setDocument(document);
        setDocumentNumber(documentNumber);
        setBirthDate(birthDate);
        setAddress(address);
        setEmail(email);
        setEmailConfirmed(emailConfirmed);
        setPhone(phone);
        setPhoneConfirmed(phoneConfirmed);
        setAge(age);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
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

    public String getFirstLastName() {
        return TextHelper.getDefaultWithTrim(firstLastName);
    }

    public void setFirstLastName(final String firstLastName) {
        this.firstLastName = TextHelper.getDefaultWithTrim(firstLastName);
    }

    public String getSecondLastName() {
        return TextHelper.getDefaultWithTrim(secondLastName);
    }

    public void setSecondLastName(final String secondLastName) {
        this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
    }

    public DocumentDTO getDocument() {
        return document;
    }

    public void setDocument(final DocumentDTO document) {
        this.document = document == null ? new DocumentDTO() : document;
    }

    public String getDocumentNumber() {
        return TextHelper.getDefaultWithTrim(documentNumber);
    }

    public void setDocumentNumber(final String documentNumber) {
        this.documentNumber = TextHelper.getDefaultWithTrim(documentNumber);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = birthDate == null ? LocalDate.now() : birthDate;
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

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getPhone() {
        return TextHelper.getDefaultWithTrim(phone);
    }

    public void setPhone(final String phone) {
        this.phone = TextHelper.getDefaultWithTrim(phone);
    }

    public boolean isPhoneConfirmed() {
        return phoneConfirmed;
    }

    public void setPhoneConfirmed(boolean phoneConfirmed) {
        this.phoneConfirmed = phoneConfirmed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
