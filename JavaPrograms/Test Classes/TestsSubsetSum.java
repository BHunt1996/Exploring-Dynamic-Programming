import org.junit.Test;
import org.junit.Assert;

public class TestsSubsetSum {
	@Test
	public void testSuite() {
		SubsetSum ss = new SubsetSum();
		Assert.assertEquals(true, ss.subsetSum(new int[]{1,2,3}, 5));
		Assert.assertEquals(true, ss.subsetSum(new int[]{1,2,3}, 3));
		Assert.assertEquals(false, ss.subsetSum(new int[]{1,2,3}, 10));
		Assert.assertEquals(true, ss.subsetSum(new int[]{100,200}, 300));
		Assert.assertEquals(true, ss.subsetSum(new int[]{100,200}, 100));
	}
}
