package practicalunittesting.ch5_4;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultService {

	private Collection<Client> subscribers = new HashSet<Client>();

	public void addSubscriber(Client client) {
		subscribers.add(client);
	}

	public void send(Message message) {
		for (Client client : subscribers) {
			client.receive(message);
		}

	}

	public void removeSubscriber(Client client) {
		subscribers.remove(client);
	}
}
