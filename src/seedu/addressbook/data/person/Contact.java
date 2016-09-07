package seedu.addressbook.data.person;

/**
 * Checks the information stored is private or not in the address book.
 */

public class Contact {
	 private boolean isPrivate;
	 
	 public boolean isPrivate() {
	      return isPrivate;
	 }
	 
	 public void setPrivate(boolean isPrivate) {
	      this.isPrivate = isPrivate;
	 }
}