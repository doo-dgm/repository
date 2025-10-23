package co.edu.uco.treepruning.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class ProgrammingDomain extends Domain {

    private LocalDate initialDate;
    private int frequencyMonths;
    private int quantity;

    public ProgrammingDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setInitialDate(LocalDate.now());
        setFrequencyMonths(0);
        setQuantity(0);
    }
    
    public ProgrammingDomain(UUID id) {
    	super(id);
        setInitialDate(LocalDate.now());
        setFrequencyMonths(0);
        setQuantity(0);
    }


    public ProgrammingDomain(final UUID id, final LocalDate initialDate, final int frequencyMonths, final int quantity) {
        super(id);
        setInitialDate(initialDate);
        setFrequencyMonths(frequencyMonths);
        setQuantity(quantity);
    }

    public static ProgrammingDomain create(final UUID id, final LocalDate initialDate, final int frequencyMonths, final int quantity) {
        return new ProgrammingDomain(id, initialDate, frequencyMonths, quantity);
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    private void setInitialDate(final LocalDate initialDate) {
        this.initialDate = ObjectHelper.getDefault(initialDate, LocalDate.now());
    }

    public int getFrequencyMonths() {
        return frequencyMonths;
    }

    private void setFrequencyMonths(final int frequencyMonths) {
        this.frequencyMonths = frequencyMonths < 0 ? 0 : frequencyMonths;
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(final int quantity) {
        this.quantity = quantity < 0 ? 0 : quantity;
    }
}

