import org.junit.Test;
import org.junit.Assert;

public class TestsTextJustify {
	public void testSuite() {
		TextJustification tj = new TextJustification();
		Assert.assertEquals("yo yo yo",
							tj.justify(new String[]{"yoyoyo"},
									2));
	}
}
