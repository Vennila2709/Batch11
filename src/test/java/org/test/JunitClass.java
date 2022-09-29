package org.test;

import java.util.Date;

import org.base.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class JunitClass extends BaseClass {
	
	@BeforeClass
	public static void beforeClass() {
		browserLaunch("\\driver\\chromedriver");
		urlLaunch("https://facebook.com");
	}
	
	@Before
	public  void beforeMethod() {
		Date d=new Date();
		System.out.println(d);
	}
	
	@After
	public void afterMethod() {
		Date d=new Date();
		System.out.println(d);
	}
	
	@Test
	public  void test1() {
		WebElement element=driver.findElement(By.xpath(""));
		Assert.assertTrue("Title is displayed",isDisplayed(element));
		
	}
	
	@Test
	public  void test2() {
		Assert.assertEquals("Facebook",getTitle());
		
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}

}
