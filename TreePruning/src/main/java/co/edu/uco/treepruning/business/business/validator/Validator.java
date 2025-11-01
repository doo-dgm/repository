package co.edu.uco.treepruning.business.business.validator;

public interface Validator<T> {
	void validate(Object... data);
}
