package testautomation.framework;

/**
 * 
 */


import java.io.File;
import java.io.FileOutputStream;


import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;




/**
 * @author Compro
 *
 */
public class CaptureScreenshot {

	/**
	 * @param args
	 */
	

	
	public static void takeScreenshot(RemoteWebDriver driver,String methodname) {
		
		
		
		try{

		System.out.println("inside capscreen");
		WebDriver augmentedDriver = new Augmenter().augment(driver);		
		String ss = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.BASE64).toString();



		String logTime = getTime();
		
		File f = new File("C:\\Selenium_Test\\"+methodname+"\\");
		try{
		if(f.mkdir())
		System.out.println("Directory Created");
		else
		System.out.println("Directory is not created");
		}catch(Exception e){
		e.printStackTrace();
		} 
		
		FileOutputStream fos = new FileOutputStream (new File(f +"\\"+ logTime +".png"));
		
		 fos.write(Base64.decodeBase64(ss));
		 fos.close();
		 System.out.println("exiting inside capscreen");
		
		}
		
		catch(Exception e)
		{
			System.out.println("Screen Capture Error");
			e.printStackTrace();
		}


	}
	
	private  final static String getTime(  )   {  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss" ) ;  
        df.setTimeZone( TimeZone.getTimeZone( "IST" )  ) ;  
          
          
        return ( df.format( new Date(  )  )  ) ;  
    }  

}
