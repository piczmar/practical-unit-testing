package practicalunittesting.ch6_6;

import static org.hamcrest.Matchers.hasEntry;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.*;
import org.testng.annotations.Test;

public class UserDAOTest {

	@Test
	public void shouldGetUsers() {
		UserDAO userDao = mock(UserDAO.class);
		User user = new User();

		when(userDao.getUser(anyInt())).thenReturn(user);

		assertEquals(userDao.getUser(1), user);
		assertEquals(userDao.getUser(2), user);
		assertEquals(userDao.getUser(3), user);

		verify(userDao, times(3)).getUser(anyInt());
	}
	
	@Test
	public void shouldGetUsersByNameAndSurname() {
		UserDAO userDao = mock(UserDAO.class);
		User user = new User();

		when(userDao.getUserByNameAndSurname(anyString(), anyString())).thenReturn(user);

		assertEquals(userDao.getUserByNameAndSurname("some str","some other str"), user);

		//This exception may occur if matchers are combined with raw values:
		//verify(userDao).getUserByNameAndSurname(anyString(),"this shouuld use matcher instead");
		verify(userDao).getUserByNameAndSurname(anyString(),anyString());
	}

	@Test
	public void testwithHamcrestMatchers() {
		UserDAO userDao = mock(UserDAO.class);
		User user = new User();

		when(userDao.getUserByProperties(argThat(hasEntry("id", "2")))).thenReturn(user);

		assertThat(userDao.getUserByProperties(new HashMap<String,String>())).isNull();

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "2");

		assertThat(userDao.getUserByProperties(map)).isEqualTo(user);
	}
}
