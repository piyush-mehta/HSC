package testautomation.testcases;




import static org.junit.Assert.*;
//import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import java.util.logging.Level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import testautomation.framework.CaptureScreenshot;
import testautomation.framework.LogGenerator;
import testautomation.framework.SetupDriver;


import org.junit.Assume.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

//@RunWith(Parameterized.class)
//public class MultiBrowserTests {
//		
//	
//	private String browser;
//	private String version;
//	private String os;
////	@RunWith(Parameterized.class)
////	public class TestGoogleBase extends SeleneseTestBase {
//	   
//	public MultiBrowserTests(String abc,String a,String b){
//	   System.out.println(abc);
//		browser=abc;
//		version = a;
//		os = b;
//		
//		
//	  }
//		 
//		 
//		 
//		 
//	  @Parameters
//	   public static Collection<Object[]> data() {
//	   
////	    Object[][] data = new Object[][] {{"opera", "11", "WINDOWS"},{"firefox", "13", "WINDOWS"}};
//		   Object[][] data = new Object[][] {{"firefox", "17", "WINDOWS"}};
//	 // Object[][] data = new Object[][] { { 0 } };
//	 return Arrays.asList(data);
//
//	   }
//	
//	
//		
//		private RemoteWebDriver driver = null;
//		
//		
//	   Process process=null;
//		
//		@Before
//		public void setUp() 
//		{
//		
//			
//			SetupDriver swd = new SetupDriver(browser);
//			driver = swd.setDriver();
//			
//			TestRecorder.StartRecorder();
//			
//
//			LogGenerator lg = new LogGenerator(driver);
//			
//			
//		}
//
//			
//
//				
//		@After
//		public void tearDown() throws Exception 
//		{
//			//SetupDriver.exit();
//			TestRecorder.StopRecorder();
//			driver.quit();
//			
//			System.out.println("Driver ShutDown");
////			process.destroy();
//		}
//				

@RunWith(Parameterized.class)
public class MultiBrowserTests {
	
	
	
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
		
	public static int index=0;
	private String browserchoice;
	


//	@RunWith(Parameterized.class)
//	public class TestGoogleBase extends SeleneseTestBase {
	   
	public MultiBrowserTests(String opt){
		//index++;
		browserchoice=opt;
		 // System.out.println("index"+index);

	  // System.out.println("opt"+opt);
	  }
		 
 
		 
	  @Parameters
	   public static Collection<Object[]> data() {
	   
	    //Object[][] data = new Object[][] {{"1"},{"2"},{"3"}};
		   Object[][] data = new Object[][] {{"1"}};
	    return Arrays.asList(data);

	   }
	
	
		
		private RemoteWebDriver driver = null;
		
		
	   Process process=null;
		
		@Before
		public void setUp() 
		{
		
			
			SetupDriver swd = new SetupDriver(browserchoice);
			driver = swd.setDriver();
			driver.manage().window().maximize();
			System.out.println("ss");
			Assume.assumeTrue(swd.valid==true);
			System.out.println("after assume");
			LogGenerator lg = new LogGenerator(driver);
			
			
		}
				
		@After
		public void tearDown() throws Exception 
		{
			//SetupDriver.exit();
			if(driver!=null)
			driver.quit();
			
			System.out.println("Driver ShutDown");
			//process.destroy();
		}
				


		@Ignore
		@Test
		public void TestCase_001() throws Exception  {
			
			
			
			LogGenerator.addLog(Level.INFO, "Starting Test Case_001");
		
		 	driver.get("http://www.google.com");			
			// Find the text input element by its name
			WebElement element = driver.findElement(By.name("q"));			
			element.sendKeys("Selenium");		
			element.submit();

//	     	synchronized (driver)
//			{
//				driver.wait(12000);
//			}
	     	String name= (new Exception().getStackTrace()[0].getMethodName());
	     	CaptureScreenshot.takeScreenshot(driver, name);			 
			assertEquals("1selenium - Google Search", driver.getTitle());
			
			LogGenerator.addLog(Level.INFO, "Completing Test Case_001");
		
		
		}
			
		@Ignore
		@Test
		public void TestCase_002() throws Exception  {
			
			
			
			LogGenerator.addLog(Level.INFO, "Starting Test Case_002");
			
			
			driver.get("http://www.google.com");	
		 	String name= (new Exception().getStackTrace()[0].getMethodName());
		 	CaptureScreenshot.takeScreenshot(driver, name);	
		 	
			// Find the text input element by its name
			WebElement element = driver.findElement(By.name("q"));			
			element.sendKeys("Junit");		
			element.submit();
			
			
	     	synchronized (driver)
			{
				driver.wait(12000);
			}
	    	
	     	LogGenerator.addLog(Level.INFO, "my info message in test case 002");
	     	
	     	CaptureScreenshot.takeScreenshot(driver,name);			 
			//assertEquals("junit - Google Search", driver.getTitle());
			
			LogGenerator.addLog(Level.INFO, "Completing Test Case_002");
		
		}
		
		@Ignore
		@Test
	public void TestCase_003() throws Exception{
		
			
			LogGenerator.addLog(Level.INFO, "Starting Test Case_003");
	driver.get("http://grader3/ui/pctlogin.aspx");

	assertEquals("Project Creation Tool", driver.getTitle());
	String name= (new Exception().getStackTrace()[0].getMethodName());
	CaptureScreenshot.takeScreenshot(driver,name);	
	driver.switchTo().frame(0);
	driver.findElement(By.id("UserNameTextBox")).clear();
	driver.findElement(By.id("UserNameTextBox")).sendKeys("qa");
	driver.findElement(By.id("PasswordTextBox")).clear();
	driver.findElement(By.id("PasswordTextBox")).sendKeys("qa");
	driver.findElement(By.id("LoginButton")).click();
	driver.findElement(By.id("CreateProj")).click();
	driver.findElement(By.id("NameInput")).clear();
	driver.findElement(By.id("NameInput")).sendKeys("New Project 19 July");
	driver.findElement(By.id("DescriptionInput")).clear();
	driver.findElement(By.id("DescriptionInput")).sendKeys("Test Project");
	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	assertEquals("Project Creation Tool", driver.getTitle());
	assertEquals("Project Creation Tool", driver.getTitle());
	driver.findElement(By.id("LogOut_Link")).click();
	assertEquals("Project Creation Tool", driver.getTitle());
	
		}
		
		@Ignore
		@Test
		public void TestCase_004() throws Exception{
	
			
			
			LogGenerator.addLog(Level.INFO, "Starting Test Case_004");
			driver.get("http://myitlabgrader.com/html5/SIMFrame.html");
			assertEquals("SIMs Demo", driver.getTitle());
			synchronized (driver)
			{
				driver.wait(12000);
			}
			System.out.println("test1");

			
			WebElement we  = driver.findElement(By.cssSelector("#msword > img"));
			
			Actions action = new Actions(driver);
			action.doubleClick(we);
			action.perform();
		
			synchronized (driver)
			{
				driver.wait(6000);
			}
			String name= (new Exception().getStackTrace()[0].getMethodName());
			CaptureScreenshot.takeScreenshot(driver,name);

			synchronized (driver)
			{
				driver.wait(1200);
			}

			driver.findElement(By.cssSelector("span.ribbon-title.testfileID")).click();
			
			action.moveByOffset(0,82);
			action.perform();
			action.click();
			action.perform();
			
			
			
			we=driver.findElement(By.xpath("//div[@id='9']/div/div[3]/div/div[2]/div[8]/img"));
			action.doubleClick(we);
			action.perform();

		}
		
				@Ignore
				@Test
				public void TestCase_005() throws Exception{
			
					
					
					LogGenerator.addLog(Level.INFO, "Starting Test Case_004");
					driver.get("http://myitlabgrader.com/HTML5/SIMFrame.html");
					//assertEquals("SIMs Demo", driver.getTitle());
					synchronized (driver)
					{
						driver.wait(12000);
					}
					System.out.println("test1");

					
					WebElement we  = driver.findElement(By.cssSelector("#msword > img"));
					
					Actions action = new Actions(driver);
					action.doubleClick(we);
					action.perform();
				
					synchronized (driver)
					{
						driver.wait(12000);
					}
					
					
						
					String name= (new Exception().getStackTrace()[0].getMethodName());
					CaptureScreenshot.takeScreenshot(driver,name);

					synchronized (driver)
					{
						driver.wait(6000);
					}

					driver.findElement(By.cssSelector("span.ribbon-title.IDFileTab")).click();
					
					driver.findElement(By.xpath("html/body/div/div/div[3]/div/div/div/div/div[3]/div/div/div[4]")).click();
					
					
					driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div[3]/div/div[4]/div[3]/p[5]/img")).click();
					
					we=driver.findElementByXPath("/html/body/div/div/div[6]/div/div[2]/div/div/div[3]/div/div[2]/div[8]/img");
					
					action.doubleClick(we);
					action.perform();

				}
				
				@Ignore
				@Test
				public void TestCase_00X() throws Exception {
					LogGenerator.addLog(Level.INFO, "Starting Test Case_00X");
					driver.get("http://myitlabgrader.com/HTML5/SIMFrame.html");
					synchronized (driver)
					{
						driver.wait(6000);
					}

					driver.findElement(By.id("viewallbutton")).click();
					driver.findElement(By.xpath("//div[@id='ViewAllDlg']/div/table/tbody/tr[5]/td[2]")).click();
					driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
					driver.findElement(By.xpath("//div[@class='excelWorkBook']/div/div/div[2]/ul[3]/li[2]/div")).click();

					    ((JavascriptExecutor)driver).executeScript("$('div#12_selectionBorder1.selectionBorderDiv').dblclick();")  ;
//					    ((JavascriptExecutor)driver).executeScript("$('div#12_selectionBorder1.selectionBorderDiv').focus();")  ;
					    
					    driver.findElement(By.xpath("//*[@id='12_editableDiv1']/div")).sendKeys("Semester 1");
//					driver.findElement(By.xpath("//div[@class='excelWorkBook']/div/div/div[2]/ul[3]/li[4]/div")).click();
					    
					    driver.findElement(By.xpath("//*[@id='12_editableDiv1']/div")).sendKeys(Keys.RETURN);
					    
//					 ((JavascriptExecutor)driver).executeScript("$('div#12_editableDiv1').keypress(function (e){if(e.keyCode == 13) });")  ;
					 synchronized (driver)
						{
							driver.wait(6000);
						}
					 String name= (new Exception().getStackTrace()[0].getMethodName());
						CaptureScreenshot.takeScreenshot(driver,name);
						
		}
//				@Ignore
				@Test
				public void testCase4() throws Exception {
					driver.get("http://myitlabgrader.com/HTML5/SIMFrame.html");
					synchronized (driver) {
						driver.wait(12000);
						
					}
					driver.findElement(By.id("viewallbutton")).click();
					driver.findElement(By.xpath("//div[@id='ViewAllDlg']/div/table/tbody/tr[2]/td[2]")).click();
//					driver.findElement(By.cssSelector("td.DatagridSelectedTD")).click();
					driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
					synchronized (driver) 
					{
						driver.wait(18000);
						
					}
					
					//Select Option A in Q#1
					
					driver.findElement(By.cssSelector("p.MsoNormal > span")).click();
	
//					WebElement flash4 = driver.findElement(By.cssSelector("p.MsoNormal"));
//					
//
//
//					JavascriptExecutor js4 = (JavascriptExecutor) driver;
//					js4.executeScript( "document.getElementById('MsoNormal').select();", flash4);
//					System.out.println("a"+flash4);
//					synchronized (driver) 
					{
						driver.wait(6000);
						
					}				
//					
//					driver.findElement(By.className("MsoNormal"));
//					
//					String s = driver .findElement(By.xpath("//div[@class='contentHolder']/p[@class='MsoNormal]")).getText().toString();
//					
//					((JavascriptExecutor)driver).executeScript("$('p#MsoNormal').select();", s)  ;
//					String flash = driver.findElement(By.xpath("//div[@class='contentHolder']/p[@class='MsoNormal]")).getText().toString();
//					JavascriptExecutor js = (JavascriptExecutor) driver;
//					js.executeScript( "arguments[0].select();", flash);
					
//					driver.findElement(By.cssSelector("contentHolder")).
					driver.findElement(By.cssSelector("#Bold > img.topMargin")).click();
					driver.findElement(By.xpath("//div[@id='Align Center']/img")).click();
					driver.findElement(By.id("ButtonDivFontTheme1")).click();
					driver.findElement(By.xpath("//div[@id='mcs_container_FontSize']/div/div/div/div[7]")).click();
				}

				
}

