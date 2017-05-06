import org.junit.Test;
import org.junit.Assert;

public class TestsInterleave {
	@Test
	public void testSuite() {
		Interleave il = new Interleave();
		Assert.assertEquals(true, il.isInterleaved("xxx", "yyy", "xyxyxy"));
		Assert.assertEquals(true, il.isInterleaved("xxx", "yyy", "xxxyyy"));
		Assert.assertEquals(true, il.isInterleaved("yyy", "xxx", "yyxxyx"));
		Assert.assertEquals(true, il.isInterleaved("hope", "fully", "hopefully"));
		Assert.assertEquals(true, il.isInterleaved("aabcc", "dbbca", "aadbbcbcac"));
		Assert.assertEquals(false, il.isInterleaved("xxx", "yyy", "abc"));
		Assert.assertEquals(false, il.isInterleaved("xxy", "yxx", "xxyyyxx"));
		Assert.assertEquals(false, il.isInterleaved("crash", "dash", "ash"));
		Assert.assertEquals(false, il.isInterleaved("x", "y", "xyxy"));
		Assert.assertEquals(false, il.isInterleaved("ONE", "TWO", "THREE"));
	}
}
