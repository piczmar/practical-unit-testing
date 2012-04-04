package practicalunittesting.ch5_3;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.testng.annotations.Test;

public class MessangerTest {

	private static final String ANY_MESSAGE = "Test message";
	private static final String ANY_MAIL = "someone@mail.com";

	@Test
	public void shouldSendEMail() {
		// given
		TemplateEngine templateEngine = mock(TemplateEngine.class);
		MailServer mailServer = mock(MailServer.class);
		Client client = mock(Client.class);
		Template template = mock(Template.class);

		// when
		when(client.getEMail()).thenReturn(ANY_MAIL);
		when(templateEngine.prepareMessage(template, client)).thenReturn(ANY_MESSAGE);

		Messanger messanger = new Messanger(templateEngine, mailServer);
		messanger.sendMessage(client, template);

		verify(mailServer).send(ANY_MAIL, ANY_MESSAGE);

		// TODO: Note that although tested methods contain empty bodies our test
		// succeeds, how's that? Does it make sense?

	}
}
