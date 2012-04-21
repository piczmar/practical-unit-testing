package practicalunittesting.ch6;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

public class BookAssert extends GenericAssert<BookAssert, Book> {

	public BookAssert(Book actual) {
		super(BookAssert.class, actual);
	}

	public static BookAssert assertThat(Book actual) {
		return new BookAssert(actual);
	}

	public BookAssert hasTitle(String title) {
		isNotNull();
		String errorMessage = String.format("Expected book title <%s> but was <%s>", title, actual.getTitle());
		Assertions.assertThat(actual.getTitle()).overridingErrorMessage(errorMessage).isEqualTo(title);
		return this;
	}
}
