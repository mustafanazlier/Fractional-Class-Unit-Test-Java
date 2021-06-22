/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FractionalUnitTest;

    
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FractionalUnitTest {

	@Test
	void isNaNTest() {
	   assertEquals(Fractional.NotANumber, new Fractional(0, 0).toString());
	}

	@Test
	void signTest() {
	   assertEquals(0, new Fractional(0, 0).sign());  //NaN
       assertEquals(0, new Fractional(0, 10).sign());  //zero doesn't have a sign
	   assertEquals(+1, new Fractional(10, 0).sign()); //+inf case
	   assertEquals(-1, new Fractional(-10, 0).sign());//-inf case
	   
	   assertEquals(+1, new Fractional(1328, 840).sign());  //Random tests
       assertEquals(-1, new Fractional(13434, -848).sign());  
	   
	}
	@Test
	void GCDTest() {
		
		assertEquals(0, new Fractional(0, 0).gcd()); //NaN case of GCD
		assertEquals(0, new Fractional(+10, 0).gcd()); //+inf case for GCD
		assertEquals(0, new Fractional(-10, 0).gcd()); //-inf case for GCD
		
		assertEquals(6, new Fractional(54, 24).gcd());  //Switching the numbers should 
		assertEquals(6, new Fractional(24, 54).gcd()); //not effect the GCD
		
		
		assertEquals(6, new Fractional(54, 24).gcd());    //Sign change should not effect
		assertEquals(6, new Fractional(54, -24).gcd());   //the GCD
		assertEquals(6, new Fractional(-54, 24).gcd());   
		assertEquals(6, new Fractional(-54, -24).gcd()); 
		
		
	}
	
	
	 @Test
 void testIsInfinity() {

		assertEquals(true, new Fractional(54, 0).isInfinity()); //+infinity
		assertEquals(true, new Fractional(-54, 0).isInfinity()); //-infinity
         
		assertEquals(false, new Fractional(0,54).isInfinity()); //False cases
		assertEquals(false, new Fractional(0,-54).isInfinity()); 
		assertEquals(false, new Fractional(54,-21).isInfinity());
	}
	
	 @Test
		public void testEquals() {

	    assertEquals(true, new Fractional(0, 1).equals(new Fractional(0, 54))); //0 case
		
	    assertEquals(true, new Fractional(54, 2).equals(new Fractional(27, 1)));//Random tests
		assertEquals(true, new Fractional(54, 2).equals(new Fractional(-108, -4)));
		assertEquals(true, new Fractional(54, -2).equals(new Fractional(-216, 8)));
		assertEquals(true, new Fractional(-54, 2).equals(new Fractional(432, -16)));
		}
	 
	 
	 
	@Test
	 void testSimplify(){
		assertEquals(null, new Fractional(0, 0).simplify()); //NaN null case
		assertEquals(null, new Fractional(+10, 0).simplify()); //+inf null case 
		assertEquals(null, new Fractional(-10, 0).simplify()); //-inf null case
		
		assertEquals("8/1", new Fractional(64, 8).simplify().fract); //Basic Simplifications 
		assertEquals("-2/1", new Fractional(-10, 5).simplify().fract);
		assertEquals("29/2", new Fractional(58, 4).simplify().fract); 
		assertEquals("-16/-1", new Fractional(-48, -3).simplify().fract); 
		assertEquals("51/-2", new Fractional(+102, -4).simplify().fract); 
	 
		
	}
	
	@Test
	 void testSignType2(){
		assertEquals(0, new Fractional(0, 0).sign(0, 0));  //NaN
	    assertEquals(0, new Fractional(0, 10).sign(0, 10));  //zero doesn't have a sign
		assertEquals(+1, new Fractional(10, 0).sign(10, 0)); //+infinity case
		assertEquals(-1, new Fractional(-10, 0).sign(-10, 0));//-infinity case
		   
		assertEquals(+1, new Fractional(1328, 840).sign(1328, 840));  //Random tests
	    assertEquals(-1, new Fractional(13434, -848).sign(13434, -848));  
		
	}
	
	@Test
	public void testToString() {

		assertEquals(Fractional.NotANumber, new Fractional(0, 0).toString()); // NaN case
		assertEquals(Fractional.PositiveInfinity, new Fractional(+100, 0).toString());//+infinity
        assertEquals(Fractional.NegativeInfinity, new Fractional(-100, 0).toString());//-infinity

		assertEquals("29/2", new Fractional(29, 2).toString()); //Random tests
		assertEquals("-31/3", new Fractional(-31, 3).toString());
		assertEquals("101/-4", new Fractional(101, -4).toString());
		assertEquals("-61/-4", new Fractional(-61, -4).toString());
	}
	
	
	
	
	
	
	
	
}
