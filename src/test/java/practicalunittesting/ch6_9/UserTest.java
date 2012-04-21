package practicalunittesting.ch6_9;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fest.assertions.Assertions;
import org.fest.assertions.Index;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;

public class UserTest {

	@Test
	public void shouldGetPhoneNumbers() {
		User user = new User();
		user.addPhone("324333444");

		Collection<String> phones = user.getPhones();

		assertThat(phones).isNotNull();
		assertThat(user.getPhones()).contains("324333444");

	}

	@Test
	public void twoSetsAreEqualIfTheyHaveSameObjects() {
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		s1.add("a1");
		s1.add("a2");
		s2.add("a2");
		s2.add("a1");

		Assert.assertEquals(s1, s2);

	}

	@Test
	public void twoListAreEqualInOrder() {
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		l1.add("a1");
		l1.add("a2");
		l2.add("a2");
		l2.add("a1");

		Assert.assertEqualsNoOrder(l1.toArray(), l2.toArray());

	}

	@Test
	public void twoListsAreEqualIfTheyHaveSameNumberOfElementsAndSameOrder() {
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		l1.add("a2");
		l1.add("a1");
		l2.add("a2");
		l2.add("a1");

		ReflectionAssert.assertReflectionEquals(l1, l2);
	}

	@Test
	public void twoListsAreEqualIfTheyHaveSameNumberOfElementsAndAnyOrder() {
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		l1.add("a1");
		l1.add("a2");
		l2.add("a2");
		l2.add("a1");

		ReflectionAssert.assertReflectionEquals(l1, l2, ReflectionComparatorMode.LENIENT_ORDER);
	}
	
	@Test
	public void festCollectionSupport() {
		List<String> l1 = new ArrayList<String>();
		l1.add("a1");
		l1.add("a2");
		
		Assertions.assertThat(l1).isNotNull().containsExactly("a1","a2");
	}
	
	@Test
	public void festCollectionSupport2() {
		List<String> l1 = new ArrayList<String>();
		l1.add("a1");
		l1.add("a2");
		l1.add("c2");
		java.util.Hashtable t = null;
		Assertions.assertThat(l1).isNotNull().isNotEmpty().contains("a2", Index.atIndex(1)).excludes("c1");
	}
}
