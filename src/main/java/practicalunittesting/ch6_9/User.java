package practicalunittesting.ch6_9;

import java.util.ArrayList;
import java.util.Collection;

public class User {

	private Collection<String> phones = new ArrayList<String>();
	public Collection<String> getPhones() {
		return phones;
	}

	public  void addPhone(String phone) {
		phones.add(phone);
	}
}
