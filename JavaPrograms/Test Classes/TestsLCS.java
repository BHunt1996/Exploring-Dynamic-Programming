import org.junit.Test;
import org.junit.Assert;

public class TestsLCS {
	@Test
	public void testSuite() {
		LongestCommonSubsequence sub = new LongestCommonSubsequence();
		Assert.assertEquals(0, sub.getSubsequence("abc", "xyz"));
		Assert.assertEquals(1, sub.getSubsequence("abc", "b"));
		Assert.assertEquals(2, sub.getSubsequence("abc", "ab"));
		Assert.assertEquals(3, sub.getSubsequence("abc", "abc"));
		Assert.assertEquals(4, sub.getSubsequence("abcdefg", "azcyexg"));
		Assert.assertEquals(4, sub.getSubsequence("AMERICA", "AUSTRALIA"));
		Assert.assertEquals(1, sub.getSubsequence("123456", "654321"));
	}
}
