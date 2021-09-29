package utility;


import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumOperation
{
	  
	
      public  static WebDriver driver=null;
      
       public static  Hashtable<String,Object> outputParameters=new  Hashtable<String,Object>();
 
  	//open browser
  	public static Hashtable<String,Object> browserLaunch(Object[] inputParameters)
  	{		
  		
  		try
  		{          
  		  String strBroserName=(String)inputParameters[0];
  		  String webDriverExePath=(String)inputParameters[1];
  		                 
  	  if(strBroserName.equalsIgnoreCase("Chrome"))
  			  {
 		           		       
  				  System.setProperty("webdriver.chrome.driver",webDriverExePath);			
  					 driver=new ChromeDriver();
  				  driver.manage().window().maximize();
  				  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  			  }
  	  else if(strBroserName.equalsIgnoreCase("FF"))
  			  {
  				  System.setProperty("webdriver.gecko.driver",webDriverExePath);			
  					 driver=new FirefoxDriver();
  				  driver.manage().window().maximize();
  				  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  			  }	
  	 
  	  outputParameters.put("STATUS", "PASS");
  	  outputParameters.put("MESSAGE", "Action: BrowserLaunch, Input Given :" +inputParameters[0].toString() );
  	  
  	  
  		}
  		catch(Exception e)
  		{
  		  System.out.println(e);
  		 outputParameters.put("STATUS", "FAIL");
  	  	  outputParameters.put("MESSAGE", "Action: BrowserLaunch, Input Given :" +inputParameters[0].toString() );
  		}
  		
  		return outputParameters;
  	}
  	
  	//openApplication
  	public static Hashtable<String,Object> openApplication(Object[] inputParameters)
  	{
  		try{
  		  		
  			String url=(String)inputParameters[0];
  		driver.get(url);
  		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
  		 outputParameters.put("STATUS", "PASS");
  	  	  outputParameters.put("MESSAGE", "Action: openApplication, Input Given :" +inputParameters[0].toString() );
  		}catch(Exception e)
  		{
  			 System.out.println(e);
  			 outputParameters.put("STATUS", "FAIL");
  	  	  	  outputParameters.put("MESSAGE", "Action: openApplication, Input Given :" +inputParameters[0].toString() );
  		}
  		return outputParameters;	
  	}
  	
  	//sendKey 
  	public static Hashtable<String,Object> sendKey(Object[] inputParameters)
  	{
  		try
  		{
  		String xpath1=(String)inputParameters[0];
  		String value1=(String)inputParameters[1];
  		
  		driver.findElement(By.xpath(xpath1)).sendKeys(value1);
  		
  		
  		
  		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  	
  		 outputParameters.put("STATUS", "PASS");
 	  	  outputParameters.put("MESSAGE", "Action: sendKey, Input Given :" +inputParameters[1].toString() );
  		}catch(Exception e)
  		{
  			System.out.println(e);
  			 outputParameters.put("STATUS", "FAIL");
  	 	  	  outputParameters.put("MESSAGE", "Action: sendKey, Input Given :" +inputParameters[1].toString() );
  		}
  		return outputParameters;  		
  	}
  	
  	//dropdown
  	public static Hashtable<String,Object> dropdown(Object[] inputParameters)
  	{
  		try{
  		String xpath1=(String)inputParameters[0];
  		String value=(String)inputParameters[1];
  		
  		Select sel=new Select(driver.findElement(By.xpath(xpath1)));
  		
  		sel.selectByVisibleText(value);
  		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  		 
  		 outputParameters.put("STATUS", "PASS");
	  	  outputParameters.put("MESSAGE", "Action: dropDown, Input Given :" +inputParameters[1].toString() );	
  		
  		}catch(Exception e)
  		{
  			System.out.println(e);
  			 outputParameters.put("STATUS", "PASS");
  		  	  outputParameters.put("MESSAGE", "Action: dropDown, Input Given :" +inputParameters[1].toString() );	
  		}
  		return outputParameters; 		
  	}
  	
  //click
  	public static Hashtable<String,Object> click(Object[] inputParameters)
  	{
  		try{
  		String xpath=(String)inputParameters[0];	
  		driver.findElement(By.xpath(xpath)).click();
  		
  		Thread.sleep(5000);
  		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  		 
  		 outputParameters.put("STATUS", "PASS");
  	  	 outputParameters.put("MESSAGE", "Action:click,Input Given: " +inputParameters[0].toString() );
  		}catch(Exception e)
  		{
  			 outputParameters.put("STATUS", "FAIL");
  	  	  	 outputParameters.put("MESSAGE", "Action:click,Input Given: " +inputParameters[0].toString() );
  		}
  		return outputParameters;
  	}
  	
      
	
	
	
	public static Hashtable<String,Object> mouseOver(Object[]inputParameters)
	{
		try
		{
		String elexpath=(String)inputParameters[0];
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath(elexpath));
		act.moveToElement(ele).build().perform();
		System.out.println("Successfully moved to given element");
		Thread.sleep(1000);
		 outputParameters.put("STATUS", "PASS");
	  	  outputParameters.put("MESSAGE", "Action: mouseOver, Input Given :" +inputParameters[0].toString() );	
	
		}
		catch(Exception e)
		{
			System.out.println(e);
			outputParameters.put("STATUS", "FAIL");
		  	  outputParameters.put("MESSAGE", "Action: mouseOver, Input Given :" +inputParameters[0].toString() );	
		}
		return outputParameters;	
	}
	
	
	
	public static Hashtable<String,Object> validation(Object[] inputParameters)
  	{
  		try{
  		String given=(String)inputParameters[0];
  		String xpath=(String)inputParameters[1];
  		
  		String text=driver.findElement(By.xpath(xpath)).getText();
  		
  		if(text.equalsIgnoreCase(given))
  		{
  			System.out.println("Test Case pass");
  			
  			outputParameters.put("STATUS", "PASS");
  	  	  outputParameters.put("MESSAGE", "Action: validation, Input Given :" +inputParameters[0].toString() );	
  		}else
  		{
  			System.out.println("Test Case Fail");
  			outputParameters.put("STATUS", "FAIL");
    	  	  outputParameters.put("MESSAGE", "Action: validation, Input Given :" +inputParameters[0].toString() );	
  		}
  		}catch(Exception e)
  		{
  			 System.out.println(e);
  			System.out.println("Test Case Fail");
  			outputParameters.put("STATUS", "FAIL");
    	  	  outputParameters.put("MESSAGE", "Action: validation, Input Given :" +inputParameters[0].toString() );	
  		}
  		
  		
  		return outputParameters; 		
  	}
	
	
	
	public static Hashtable<String,Object> closeBrowserWindow() throws InterruptedException
	{
		//Thread.sleep(5000);
		driver.close();
		
		return outputParameters;
	}
	
	
}