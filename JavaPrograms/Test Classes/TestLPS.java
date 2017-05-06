import org.junit.Test;
import org.junit.Assert;

public class TestLPS {
	@Test
	public void testSuite() {
		LongestPalindromicSubstring ps = new LongestPalindromicSubstring();
		Assert.assertEquals("kayak", ps.lps("kayak"));
		Assert.assertEquals("a", ps.lps("a"));
		Assert.assertEquals("tattarrattat", ps.lps("tattarrattat"));
		Assert.assertEquals("racecar", ps.lps("paddingracecarpadding"));
		Assert.assertEquals("racecar", ps.lps("racecarkayak"));
		Assert.assertEquals(null, ps.lps("no"));
	}
}
