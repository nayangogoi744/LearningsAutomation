package com.testtalks.karatedemo.MavenProjectSelenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssert {

	/*@Test
	public void hardAssert(){
		System.out.println("Before HARD Assert");
		Assert.assertEquals(12, 13);
		System.out.println("After HARD Assert");
	}
	
	@Test
	public void softAssert(){
		SoftAssert softassert = new SoftAssert();
		System.out.println("Before SOFT Assert");
		softassert.assertEquals(12, 13,"Please review your expected and actual values");
		System.out.println("After SOFT Assert");
		softassert.assertAll();
		
	}*/
	
	@Test
	public void softAssertionTest(){
	   
	   //Creating softAssert object
	   SoftAssert softAssert = new SoftAssert();
	   
	   //Assertion failing
	   softAssert.fail("Failing first assertion");
	   System.out.println("Failing 1");
	   
	   //Assertion failing
	   softAssert.fail("Failing second assertion");
	   System.out.println("Failing 2");

	   //Assertion passing
	   softAssert.assertEquals(1, 1, "Passing third assertion");
	   System.out.println("Passing 3");

	   //Collates the assertion results and marks test as pass or fail
	   softAssert.assertAll();
	}
}
