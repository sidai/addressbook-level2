package seedu.addressbook.data.tag;

/*
 * Represents an adding or deleting of a tag for a specific person that happened during that session
 */
public class Tagging {
	
	private String tagAction;
	
	public Tagging(String tagAction) {
		setTagAction(tagAction);
	}
	
	public void setTagAction(String tagAction) {
		this.tagAction = tagAction;
	}
	
	public String getTagAction() {
		return tagAction;
	}
}