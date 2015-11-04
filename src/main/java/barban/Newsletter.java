package barban;

import java.util.List;

public class Newsletter {

	private String subject;
	private List<Recipient> recipients;

	public Newsletter() {
	}
	
	

	public Newsletter(String subject, List<Recipient> recipients) {
		this.subject = subject;
		this.recipients = recipients;
	}



	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Recipient> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<Recipient> recipients) {
		this.recipients = recipients;
	}
	
	

}
