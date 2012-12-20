package testautomation.framework;

/**
 * 
 */


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Compro
 *
 */

public class LogGenerator {
	
	static Logger logger = null;

	/**
	 * @param args
	 */
	public LogGenerator(RemoteWebDriver driver) {
		
		
		try{
			
		System.out.println("inside lg");	
		logger = Logger.getLogger(RemoteWebDriver.class.getName());
		
String logTime = getTime();
		
		File f = new File("C:\\Selenium_log\\");
		try{
		if(f.mkdir())
		System.out.println("Directory Created");
		else
		System.out.println("Directory is not created");
		}catch(Exception e){
		e.printStackTrace();
		} 
		
			
	    Handler handler = new FileHandler(f +"\\"+ logTime +"TestCase_logs.log", true);
	    Formatter newFormatter = new SimpleFormatter();
	    handler.setLevel(Level.INFO);
	    handler.setFormatter(newFormatter);
	    logger.addHandler(handler);	   
	    driver.setLogLevel(Level.INFO);
	    
//	    RemoteWebDriver.setLogLevel(Level.INFO);
	    
	    
	    
	    System.out.println("exiting inside lg");
		}
		
		catch(Exception e)
		{
			System.out.println("Logger Error");
			e.printStackTrace();
		}
		
	}

	
	public static void addLog(Level level, String Msg)
	{
		//logger.log(Level.INFO, "mymsg");
		logger.log(level, Msg);
	}
	
	public void exitlog(LogGenerator logger){
		logger.exiting(this.getClass(), "Mylog");
	}
	
	private void exiting(Class<? extends LogGenerator> class1, String string) {
		// TODO Auto-generated method stub
		
	}


	private  final static String getTime(  )   {  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss" ) ;  
        df.setTimeZone( TimeZone.getTimeZone( "IST" )  ) ;  
          
          
        return ( df.format( new Date(  )  )  ) ;  
    }  
}
