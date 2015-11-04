package barban;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

public class NewsletterService {

	public static Collection<String> getAllUniqueEmails(Collection<Newsletter> newsletters) {
		return FluentIterable.from(newsletters).transformAndConcat(new Function<Newsletter, Collection<Recipient>>() {

			@Override
			public Collection<Recipient> apply(Newsletter input) {
				return input.getRecipients();
			}
		}).transform(new Function<Recipient, String>() {

			@Override
			public String apply(Recipient input) {
				return input.getEmail();
			}
		}).toSet();
	}

	public static Collection<String> getAllSubjectsByEmail(List<Newsletter> newsletters, final String email) {
		return FluentIterable.from(newsletters).filter(new Predicate<Newsletter>() {

			@Override
			public boolean apply(Newsletter newsletter) {
				return FluentIterable.from(newsletter.getRecipients()).anyMatch(new Predicate<Recipient>() {

					@Override
					public boolean apply(Recipient recipient) {
						return Objects.equal(email, recipient.getEmail());
					}
				});
			}
		}).transform(new Function<Newsletter, String>() {

			@Override
			public String apply(Newsletter input) {
				return input.getSubject();
			}
		}).toSet();
	}

}
