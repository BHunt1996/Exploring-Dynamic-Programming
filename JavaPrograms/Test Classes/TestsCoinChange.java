import org.junit.Test;
import org.junit.Assert;

public class TestsCoinChange {
	@Test
	public void testSuite() {
		CoinChange cc = new CoinChange();
	    Assert.assertEquals(1, cc.minCoins(1, new int[]{1}));
	    Assert.assertEquals(5, cc.minCoins(10, new int[]{2}));
	    Assert.assertEquals(20, cc.minCoins(100, new int[]{5}));
	    Assert.assertEquals(2, cc.minCoins(10, new int[]{5,5}));
	    Assert.assertEquals(2, cc.minCoins(5, new int[]{1,2,3}));
	    Assert.assertEquals(4, cc.minCoins(10, new int[]{3,2,1}));
	    Assert.assertEquals(2, cc.minCoins(10, new int[]{2,3,5,6}));
	    Assert.assertEquals(3, cc.minCoins(17, new int[]{2,3,5,6}));
	    Assert.assertEquals(6, cc.minCoins(99, new int[]{1,2,5,10,20,50}));
	    Assert.assertEquals(9, cc.minCoins(999, new int[]{1,2,5,10,20,50, 
	    		 										   100,200, 500}));
	}
}
