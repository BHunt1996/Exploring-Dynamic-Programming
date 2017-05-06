import org.junit.Test;
import org.junit.Assert;

public class TestsEditDistance {
	@Test
	public void testSuite() {
		EditDistance ed = new EditDistance();
		Assert.assertEquals(0, ed.editDistance("same", "same"));
		Assert.assertEquals(1, ed.editDistance("same", "sames"));
		Assert.assertEquals(1, ed.editDistance("cheap", "heap"));
		Assert.assertEquals(2, ed.editDistance("keep", "sleep"));
		Assert.assertEquals(3, ed.editDistance("kitten", "sitting"));
		Assert.assertEquals(5, ed.editDistance("abcde", "fghij"));
		Assert.assertEquals(1, ed.editDistance("hihello", "hi hello"));
		Assert.assertEquals(5, ed.editDistance("Intention", "Execution"));
		Assert.assertEquals(3, ed.editDistance("MART", "KARMA"));
		Assert.assertEquals(4, ed.editDistance("123 abc", "231 cba"));
	}
}
