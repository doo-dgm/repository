package co.edu.uco.treepruning.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class ProgrammingDomain extends Domain {

    private LocalDate initialDate;
    private int frequencyMonths;
    private int amount;

    public ProgrammingDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setInitialDate(DateHelper.getDateHelper().getDefault());
        setFrequencyMonths(0);
        setAmount(0);
    }
    
    public ProgrammingDomain(UUID id) {
    	super(id);
        setInitialDate(DateHelper.getDateHelper().getDefault());
        setFrequencyMonths(0);
        setAmount(0);
    }


    public ProgrammingDomain(final UUID id, final LocalDate initialDate, final int frequencyMonths, final int amount) {
        super(id);
        setInitialDate(initialDate);
        setFrequencyMonths(frequencyMonths);
        setAmount(amount);
    }

    public static ProgrammingDomain create(final UUID id, final LocalDate initialDate, final int frequencyMonths, final int quantity) {
        return new ProgrammingDomain(id, initialDate, frequencyMonths, quantity);
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    private void setInitialDate(final LocalDate initialDate) {
        this.initialDate = DateHelper.getDateHelper().getDefault(initialDate);
    }

    public int getFrequencyMonths() {
        return NumericHelper.getDefaultInt(frequencyMonths);
    }

    private void setFrequencyMonths(final int frequencyMonths) {
        this.frequencyMonths = Math.max(NumericHelper.getDefaultInt(frequencyMonths), 0);
    }

    public int getAmount() {
        return NumericHelper.getDefaultInt(amount);
    }

    private void setAmount(final int amount) {
        this.amount = Math.max(NumericHelper.getDefaultInt(amount), 0);
    }
}

