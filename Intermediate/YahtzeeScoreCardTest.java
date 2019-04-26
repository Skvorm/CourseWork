
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class YahtzeeScoreCardTest {
	YahtzeeScoreCard y;
	@Before
	public void setUp() throws Exception {
	y = new YahtzeeScoreCard();
	
	}

	@Test
	public void setTest() {
		y.setAce(5);
		assertEquals(y.getAce(),5);
	}
	@Test
	public void getUpperTotalTest(){
	y.setAce(5);
	y.calcUpperTotal();
    assertEquals(y.scoreAce(),5);
	}
	@Test
	public void isFullTest()
	{y.setAce(3);
	y.setTwo(2);
	assertTrue(y.isFullHouse());
	
	}
	@Test
	public void isSmStraightTest()
	{
		y.setAce(1);
		y.setTwo(1);
		y.setThree(1);
		y.setFour(1);
		assertTrue(y.isSmStr());
	}
	@Test
	public void isLgStraightTest()
	{
		y.setAce(1);
		y.setTwo(1);
		y.setThree(1);
		y.setFour(1);
		y.setFive(1);
		assertTrue(y.isLgStr());
	}
	@Test
	public void isLgStraightTest2()
	{
		y.setTwo(1);
		y.setThree(1);
		y.setFour(1);
		y.setFive(1);
		y.setSix(1);
		assertTrue(y.isLgStr());
	}
	@Test
	public void isLgStraightTest3()
	{
		y.setAce(5);
		assertFalse(y.isLgStr());
	}
	@Test
	public void isTripleTest()
	{ y.setAce(3);
	  assertTrue(y.isTriple());
		
	}
	@Test
	public void isQuadTest()
	{
		y.setAce(4);
		assertTrue(y.isQuad());
	}
	@Test
	public void yahtzeeTest()
	{
		y.setAce(5);
		assertTrue(y.isYahtzee());
	}
	@Test 
	public void getLowerTotalTest()
	{
	  y.setLowerTotal(50);
	   assertEquals(y.getLowerTotal(),50);
	}
	@Test
	public void getUpperTotalTest2()
	{
	  y.setUpperTotal(50);;
	   assertEquals(y.getUpperTotal(),50);
	}
	
}


