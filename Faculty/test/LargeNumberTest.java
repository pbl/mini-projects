 package test;


import junit.framework.TestCase;
import faculty.LargeNumber;

public class LargeNumberTest extends TestCase{

	public void testAddWithBiggerValue() {
		testAdd("234", "1235123");
		testAdd("1", "2");
		testAdd("0", "1");
		testAdd("0", "123123123");
		testAdd("97979", "123123123");
		testAdd("97979", "9495");
		testAdd("123", "123123123");
		testAdd("97979", "8080808");
		testAdd("19238484", "123123123");
		testAdd("98980", "202039");
	}
	
	public void testAddZeroZero(){
		testAdd("0", "0");
	}
	public void testAddZeroOne(){
		testAdd("0", "1");
	}
	public void testAddZeroBigNbr(){
		testAdd("0", "1123321313");
	}
	public void testAddBigAndBig(){
		testAdd("90809898", "292374659");
	}
	public void testAddBigAndSmall(){
		testAdd("982", "12393716");
	}

	public void testMultZeroAndOne(){
		testMult("0", "1");
		testMult("1", "0");
	}
	
	public void testMultZeroAndZero(){
		testMult("0", "0");
	}
	
	public void testMultZeroAndBig(){
		testMult("0", "19292");
	}
	
	public void testMultOneAndBig(){
		testMult("1", "19292");
	}
	
	public void testMultBigAndBig(){
		testMult("96968", "19292");
	}
	
	public void testMultBigAndSmall(){
		testMult("96968", "19");
	}
	
	public void testFacultyZero(){
		testFaculty(0);
	}	
	
	public void testFacultyOne(){
		testFaculty(1);
	}	
	
	public void testFacultyFive(){
		testFaculty(5);
	}
	
	public void testFacultyTen(){
		testFaculty(10);
	}	
	
	private void testAdd(String number, String otherNumber) {
		assertEquals(String.valueOf(Integer.parseInt(number)+Integer.parseInt(otherNumber)), LargeNumber.add(number, otherNumber));
	}
	
	private void testMult(String number, String otherNumber) {
		assertEquals(String.valueOf(Integer.parseInt(number)*Integer.parseInt(otherNumber)), LargeNumber.mult(number, otherNumber));
	}
	
	private static int faculty(int n){
		if(n == 0){
			return 1;
		}
		return n*faculty(n-1);
	}
	
	private void testFaculty(int number) {
		String n = String.valueOf(number);
		int result = faculty(number);
		assertEquals(String.valueOf(result), LargeNumber.faculty(n));
	}
}
