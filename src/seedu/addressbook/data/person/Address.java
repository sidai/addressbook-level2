package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, some unit, some postal code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Address format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_SPLIT_REGEX = ",";
    public static final String ADDRESS_VALIDATION_REGEX = Block.BLOCK_VALIDATION_REGEX + ADDRESS_SPLIT_REGEX 
    					+ Street.STREET_VALIDATION_REGEX + ADDRESS_SPLIT_REGEX + Unit.UNIT_VALIDATION_REGEX 
    					+ ADDRESS_SPLIT_REGEX + PostalCode.POSTALCODE_VALIDATION_REGEX;

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = address;
        String[] addressInputByUsers = address.split(ADDRESS_SPLIT_REGEX);
        block = new Block(addressInputByUsers[0], isPrivate);
        street = new Street(addressInputByUsers[1], isPrivate);
        unit = new Unit(addressInputByUsers[2], isPrivate);
        postalCode = new PostalCode(addressInputByUsers[3], isPrivate);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}