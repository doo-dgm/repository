package co.edu.uco.treepruning.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;

public final class ProgrammingEntity {

    private UUID id;
    private LocalDate initialDate;
    private int frequencyMonths;
    private int quantity;

    public ProgrammingEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setInitialDate(LocalDate.now());
        setFrequencyMonths(0);
        setQuantity(0);
    }

    public ProgrammingEntity(final UUID id) {
        setId(id);
        setInitialDate(LocalDate.now());
        setFrequencyMonths(0);
        setQuantity(0);
    }

    public ProgrammingEntity(final UUID id, final LocalDate initialDate, final int frequencyMonths, final int quantity) {
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
        this.initialDate = ObjectHelper.getDefault(initialDate, LocalDate.now());
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

