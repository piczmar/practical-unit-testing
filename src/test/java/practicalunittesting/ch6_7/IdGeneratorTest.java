package practicalunittesting.ch6_7;

import static org.fest.assertions.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;
@Test
public class IdGeneratorTest {

	private Set<Long> ids = new HashSet<Long>(100);
	private IdGenerator idGenerator = new IdGenerator();

	/**
	 * Execute this method in 7 parallel threads, each 100 times
	 */
	@Test(threadPoolSize = 7, invocationCount = 100)
	public void shouldGenerateUniqueIds() {

		assertThat(ids.add(idGenerator.nextId())).isTrue();
	}

}
