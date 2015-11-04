package barban;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class NewsletterServiceTest {

	public static List<Newsletter> newsletters = new ArrayList<>();
	public static List<Recipient> recipients = new ArrayList<>();
	public static final String[] subjects = { "Finance", "Healthcare", "IT", "Education", "Entertainment", "Politics",
			"Sports" };
	public static final String[] names = { "Ivan", "Petr", "Sidor" };
	public static final String[] surnames = { "Ivanov", "Petrov", "Sidorov" };

	@Before
	public void initRecipients() {
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < surnames.length; j++) {
				recipients.add(new Recipient(names[i], surnames[j], names[i] + "@" + surnames[j]));
			}
		}
	}

	@Before
	public void initNewsletters() {
		for (int i = 0; i < subjects.length; i++) {
			newsletters.add(new Newsletter(subjects[i], recipients.subList(i, recipients.size())));
		}
	}

	@Test
	public void getAllUniqueEmailsTest() {
		assertEquals(names.length * surnames.length, NewsletterService.getAllUniqueEmails(newsletters).size());
	}

	@Test
	public void getAllSubjectsByRecipient() {
		assertEquals(subjects.length,
				NewsletterService.getAllSubjectsByEmail(newsletters, names[0] + "@" + surnames[0]));
	}

}
