package practicalunittesting.ch6_6;

import java.util.Map;

public interface UserDAO {
	User getUser(int id);

	User getUserByProperties(Map properties);

	User getUserByNameAndSurname(String name, String surname);
}
