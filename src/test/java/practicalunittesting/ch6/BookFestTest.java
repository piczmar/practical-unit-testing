package practicalunittesting.ch6;

import static org.fest.assertions.Assertions.*;
import static practicalunittesting.ch6.BookAssert.*;

import static org.mockito.Mockito.*;
import org.testng.annotations.Test;

public class BookFestTest {

	@Test
	public void shouldHaveTitle() {
		final String ANY_BOOK_TITLE = "Any tite";
		Book book = new Book(ANY_BOOK_TITLE);

		assertThat(book).hasTitle(ANY_BOOK_TITLE);

	}
	
}
