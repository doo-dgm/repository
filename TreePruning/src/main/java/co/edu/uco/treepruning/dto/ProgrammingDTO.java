package co.edu.uco.treepruning.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class ProgrammingDTO {

    private UUID id;
    private LocalDate initialDate;
    private int frequencyMonths;
    private int quantity;

    public ProgrammingDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setInitialDate(LocalDate.now());
        setFrequencyMonths(0);
        setQuantity(0);
    }

    public ProgrammingDTO(final UUID id) {
        setId(id);
        setInitialDate(LocalDate.now());
        setFrequencyMonths(0);
        setQuantity(0);
    }

    public ProgrammingDTO(final UUID id, final LocalDate initialDate, final int frequencyMonths, final int quantity) {
        setId(id);
        setInitialDate(initialDate);
        setFrequencyMonths(frequencyMonths);
        setQuantity(quantity);
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
        this.initialDate = initialDate == null ? LocalDate.now() : initialDate;
    }

    public int getFrequencyMonths() {
        return frequencyMonths;
    }

    public void setFrequencyMonths(final int frequencyMonths) {
        this.frequencyMonths = frequencyMonths;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}

