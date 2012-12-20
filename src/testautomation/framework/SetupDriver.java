package testautomation.framework;

/**
 * 
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.thoughtworks.selenium.SeleneseTestBase;

/**
 * @author Compro
 *
 */



public class SetupDriver 
{
	private String browseropt;

	public SetupDriver(String browserchoice)
	{	
		//System.out.println(browserchoice);
			browseropt=browserchoice;}

	/**
	 * @param args
	 */
	
	private  RemoteWebDriver driver = null;
	private  DesiredCapabilities capabilities;
	private StringBuffer verificationErrors = new StringBuffer();
	private String cloudTestURL;
	private  String browserName = null;
	private  String browserVersion = null;
	private  String os = null;
	private String baseURL;
	public boolean valid=true;
	BufferedWriter out;
	
//	public static void exit() {
//	    try {
//	        driver.quit();
//	        System.out.println("Exiting");
//	    } catch (Exception e) {
//	    }
//	    driver = null;
//	    }
	
	 public RemoteWebDriver setDriver() {
		
		
		 
		try
		{
			
			//System.out.println("1 inside Driver Setup");
			
			/**
			 * Configure Cloud/VM Test Tool
			 */	
			Properties userCredentials = new Properties();
			Properties environmentProperties = new Properties();

			
		userCredentials.load(this.getClass().getClassLoader().
				getResourceAsStream("vmtesttool.properties"));
//		getResourceAsStream("config/vmtesttool.properties"));
		//userCredentials.load(this.getClass().getClassLoader().
			//getResourceAsStream("config/cloudtesttool.properties"));
		environmentProperties.load(this.getClass().getClassLoader().
			getResourceAsStream("testenvironment.properties"));
//		getResourceAsStream("config/testenvironment.properties"));
	
		System.out.println("2 inside Driver Setup");
		
				cloudTestURL = userCredentials.getProperty("remoteServerURL");
				baseURL = userCredentials.getProperty("baseURL");
				
				browserName = environmentProperties.getProperty("browser"+browseropt);
				browserVersion = environmentProperties.getProperty("version"+browseropt);
				os = environmentProperties.getProperty("os"+browseropt);
				
				
				
				
				
				System.out.println(browserName);
				System.out.println(browserVersion);
				System.out.println(os);
				//browserName = environmentProperties.getProperty("browser");
				//browserVersion = environmentProperties.getProperty("version");
				//os = environmentProperties.getProperty("os");
			
				/**
				 * Configure browser
				 */	
				
				
				
				
				
				
				if((browserName!=null) && (browserName.equalsIgnoreCase("firefox")))
		    		{capabilities = DesiredCapabilities.firefox();
					}
		    	else if((browserName!=null) && (browserName.equalsIgnoreCase("iexplorer")))
		    		{capabilities = DesiredCapabilities.internetExplorer();
		    		}
		    		else if(((browserName!=null) && (browserName.equalsIgnoreCase("opera"))))
		    		{capabilities = DesiredCapabilities.opera();
		    		}
		    	else if((browserName!=null && browserName.equalsIgnoreCase("chrome")))
		    		capabilities = DesiredCapabilities.chrome();
		    	else if((browserName!=null && browserName.equalsIgnoreCase("iPhone")))
		    		capabilities = DesiredCapabilities.iphone();
		    	else if((browserName!=null && browserName.equalsIgnoreCase("android")))
		    		capabilities = DesiredCapabilities.android();
		    	
		    	else
		    		{valid=false;
		    		System.out.println("No such browserName");
		    		}
				/**
				 * Configure browser Version
				 */		
				if((browserName!=null))
						capabilities.setVersion(browserVersion);
				
				System.out.println("3 inside Driver Setup");
				/**
				 * Configure OS
				 */	
				
				if(os!=null && os.equalsIgnoreCase("WINDOWS"))
					capabilities.setPlatform(Platform.WINDOWS);
		    	else if(os!=null && os.equalsIgnoreCase("LINUX"))
		    		capabilities.setPlatform(Platform.LINUX);
		    	else if(os!=null && os.equalsIgnoreCase("VISTA"))
		    		capabilities.setPlatform(Platform.VISTA);
		    	else if(os!=null && os.equalsIgnoreCase("MAC"))
		    		capabilities.setPlatform(Platform.MAC);
		    	else if(os!=null && os.equalsIgnoreCase("ANDROID"))
		    		capabilities.setPlatform(Platform.ANDROID);
		    	else
		    		System.out.println("No such os");
				
				if((browserName!=null))
					capabilities.setCapability("name", "Running Selenium Tests in SauceLabs");
				
				System.out.println("inter");
				
				System.out.println(browserVersion + os + browserName);
				
				System.out.println("inter...2");
			    /**
			     * 
			     * 
			     */
				if((browserName!=null))
				{
					
					
					driver = new RemoteWebDriver(new URL(cloudTestURL),capabilities);	    
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				}
			    
			    System.out.println("exiting driver setup"); 

			
			    
		}
		catch (NullPointerException ex)
		{
//			valid=false;
			System.out.println(browseropt+"invalid: exiting driver setup"); 
		}
		catch(Exception eta){
			System.out.println("Driver Setup Error");
		    eta.printStackTrace();
		}
		
		return driver;

	
	}

	
	 
	}

