import org.junit.Test;
import org.junit.Assert;

public class TestsMatrix {
	@Test
	public void testSuite() {
		Matrix m = new Matrix();
		Assert.assertEquals(3, m.subMatrix(new int[][]{
											{1,1,1},
			 								{1,1,1},
			 								{1,1,1}},3,3));
		Assert.assertEquals(1, m.subMatrix(new int[][]{
											{0,0,0},
											{0,1,0},
											{0,0,0}},3,3));
		
		Assert.assertEquals(0, m.subMatrix(new int[][]{
											{0,0,0},
											{0,0,0},
											{0,0,0}},3,3));
		
		Assert.assertEquals(2, m.subMatrix(new int[][]{
											{0,1,0,1},
											{0,1,1,0},
											{1,1,1,0}},3,4));
		
		Assert.assertEquals(4, m.subMatrix(new int[][]{
											{0,1,0,1,0,1}, 
											{1,0,1,1,1,1},
											{0,1,1,1,1,1}, 
											{0,0,1,1,1,1},
											{1,1,1,1,1,1}},5,6));
	}
}
