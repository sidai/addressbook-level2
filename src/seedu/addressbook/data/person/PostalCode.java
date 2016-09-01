package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's postal code in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */
public class PostalCode {

    public static final String EXAMPLE = "119242";
    public static final String MESSAGE_POSTALCODE_CONSTRAINTS = "Postal code must be a number.";
    public static final String POSTALCODE_VALIDATION_REGEX = "\\d+";
    		
    public final String value;
    private boolean isPrivate;


    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code string is invalid.
     */
    public PostalCode(String postalCode, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidPostalCode(postalCode)) {
            throw new IllegalValueException(MESSAGE_POSTALCODE_CONSTRAINTS);
        }
        this.value = postalCode;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTALCODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}