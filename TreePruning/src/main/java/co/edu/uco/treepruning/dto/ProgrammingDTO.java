package co.edu.uco.treepruning.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class ProgrammingDTO {

    private UUID id;
    private LocalDate initialDate;
    private int frequencyMonths;
    private int amount;

    public ProgrammingDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setInitialDate(DateHelper.getDateHelper().getDefault());
        setFrequencyMonths(0);
        setAmount(0);
    }

    public ProgrammingDTO(final UUID id) {
        setId(id);
        setInitialDate(DateHelper.getDateHelper().getDefault());
        setFrequencyMonths(0);
        setAmount(0);
    }

    public ProgrammingDTO(final UUID id, final LocalDate initialDate, final int frequencyMonths, final int amount) {
        setId(id);
        setInitialDate(initialDate);
        setFrequencyMonths(frequencyMonths);
        setAmount(amount);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(final LocalDate initialDate) {
        this.initialDate = DateHelper.getDateHelper().getDefault(initialDate);
    }

    public int getFrequencyMonths() {
        return frequencyMonths;
    }

    public void setFrequencyMonths(final int frequencyMonths) {
        this.frequencyMonths = frequencyMonths;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }
}

