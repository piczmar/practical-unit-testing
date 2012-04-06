package practicalunittesting.ch6_7;


public class IdGenerator {

	private Long id = System.currentTimeMillis();
	public Long nextId() {
		return id++;
	}

}
