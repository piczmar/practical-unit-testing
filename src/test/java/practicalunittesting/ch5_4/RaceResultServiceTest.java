package practicalunittesting.ch5_4;

import static org.mockito.Mockito.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RaceResultServiceTest {

	private RaceResultService service;
	private Client client1;
	private Client client2;
	private Message message;

	@BeforeMethod
	public void setUp() {
		service = new RaceResultService();
		client1 = mock(Client.class);
		client2 = mock(Client.class);
		message = mock(Message.class);
	}

	@Test
	public void notSubscribedClientsShouldNotGetMessage() {

		service.send(message);

		verify(client1, never()).receive(message);
		verify(client1, never()).receive(message);
	}

	@Test
	public void subscribedClientShouldGetMessage() {

		service.addSubscriber(client1);
		service.send(message);

		verify(client1).receive(message);
	}

	@Test
	public void allSubscribedClientsShouldGetMessage() {

		service.addSubscriber(client1);
		service.addSubscriber(client2);
		service.send(message);

		verify(client1).receive(message);
		verify(client1).receive(message);
	}

	@Test
	public void shouldSendOnlyOneMessageToMultiSubscriber() {
		final int wantedNumberOfInvocations = 1;

		service.addSubscriber(client1);
		service.addSubscriber(client1);
		service.send(message);

		verify(client1, times(wantedNumberOfInvocations)).receive(message);
	}

	@Test
	public void unsubscribedClientShouldNotGetMessage() {

		service.addSubscriber(client1);
		service.removeSubscriber(client1);
		service.send(message);

		verify(client1, never()).receive(message);
	}

}
