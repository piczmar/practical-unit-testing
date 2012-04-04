package practicalunittesting.ch5_3;

public class Messanger {
	private TemplateEngine templateEngine;
	private MailServer mailServer;

	public Messanger(TemplateEngine templateEngine, MailServer mailServer) {
		this.templateEngine = templateEngine;
		this.mailServer = mailServer;
	}

	/**
	 * This method is problematic to test as it only delegates operations, it
	 * neither change state of input objects nor returns any result
	 * 
	 */
	public void sendMessage(Client client, Template template) {
		String message = templateEngine.prepareMessage(template, client);
		mailServer.send(client.getEMail(), message);
	}
}
