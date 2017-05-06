import org.junit.Test;
import org.junit.Assert;

public class TestsLIS {
	@Test
	public void testSuite() {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		Assert.assertEquals(3, lis.getSubsequence(new int[]{1,2,3}));
		Assert.assertEquals(3, lis.getSubsequence(new int[]{3,7,5,6,2}));
	}
}
