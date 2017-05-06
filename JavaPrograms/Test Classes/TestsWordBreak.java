import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;

public class TestsWordBreak {
	@Test
	public void testSuite() {
		WordBreak wb = new WordBreak();
		Set<String> h = new HashSet<String>(Arrays.asList("hello", "dog", 
											"cat", "and"));

		Assert.assertEquals("hello hello", wb.wordBreak("hellohello",h));
		Assert.assertEquals("hello dog and cat", wb.wordBreak("hellodogandcat",h));
	}
}
