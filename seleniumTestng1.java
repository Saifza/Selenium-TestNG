package seleniumTestng;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleniumTestng1 {
	

	//import org.apache.bcel.internal.generic.Select;



	
	   WebDriver driver;
		
	   //Launch browser before any method.
	   @BeforeMethod
		public void launchbrowser() {
			 System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");	 
	        driver= new ChromeDriver();
	        driver.get("https://letskodeit.teachable.com/p/practice");
	    	
	    	 driver.manage().window().maximize();
	}

	    
	   
	   
	  
	 //Radio Button testing
	  @Test (priority=1, groups= {"sanity","smoke"})
		
	 
	  public void radiobuttonTesting() {
		   
		 
			 driver.manage().window().maximize();
			  WebElement benzradio= driver.findElement(By.id("benzradio"));
			  WebElement bmwradio= driver.findElement(By.id("bmwradio"));
			  WebElement hondaradio= driver.findElement(By.id("hondaradio"));
			  benzradio.click();
			  bmwradio.click();
			  hondaradio.click();
		//	  driver.close();
	   }
	   
	 //Checkbox testing 
		@Test (priority=2, groups= {"sanity","smoke"})
		public void checkboxTesting() {
			  
			  
			
			  WebElement checkboxbenz=driver.findElement(By.id("benzcheck"));
			     checkboxbenz.click();
			     WebElement checkboxbmw=driver.findElement(By.id("bmwcheck"));
			     checkboxbmw.click(); 
			//     driver.close();
			}
		
		//Switch To Alert (accept and dismiss) testing
		@Test (priority=3, groups= {"sanity","smoke"})
		public void alertTesting() throws InterruptedException {
		
			 
		     driver.findElement(By.id("name")).sendKeys("send alert");
		     driver.findElement(By.id("alertbtn")).click();
		     Thread.sleep(2000);
		     driver.switchTo().alert().accept();
		    
		     driver.findElement(By.id("name")).sendKeys("send alert");
		     Thread.sleep(2000);
		     driver.findElement(By.id("confirmbtn")).click();
		     Thread.sleep(2000);
		     driver.switchTo().alert().dismiss();	
		  //   driver.close();
			
		}
		// Element Displayed (Hide and Show) testing
		@Test (priority=4, groups= {"sanity","smoke"})
		public void hideshowTesting() throws InterruptedException {
			
			
		     String displaystring="hideshow text";
		    driver.findElement(By.id("displayed-text")).sendKeys(displaystring);
		    Thread.sleep(2000);
	   	   driver.findElement(By.id("hide-textbox")).click();
		    Boolean yesorno=driver.findElement(By.id("displayed-text")).isDisplayed();
		    if (yesorno==false){
		    	System.out.println("Hide button working");
		 }
		   driver.findElement(By.id("show-textbox")).click();
		   Boolean yesorno1=driver.findElement(By.id("displayed-text")).isDisplayed();
		   
		   if (yesorno1==true){
		   	System.out.println("Show button working");
	//	   	driver.close();
		}	
			
		}
		
		//Mouse hover testing
		@Test (priority=5, groups= {"sanity"})
		
		public void mousehoverTesting() throws InterruptedException {
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)");
			   Actions act=new Actions(driver);
			   act.moveToElement(driver.findElement(By.id("mousehover"))).perform();
			   Thread.sleep(2000);
			 //press top and the top portion of the page becomes visible
			   driver.findElement(By.xpath("//div[@class=\"mouse-hover-content\"]//a[1] ")).click();
			 String stringtest=driver.findElement(By.xpath("//*[@id=\"block-1069048\"]/div/div/div/h1")).getText();
			   AssertJUnit.assertEquals(stringtest, "Practice Page");
			   
			   js.executeScript("window.scrollBy(0,1000)"); 
			   act.moveToElement(driver.findElement(By.id("mousehover"))).perform();
			   Thread.sleep(2000);
			 //press reload and the page reloads
			   driver.findElement(By.xpath("//div[@class=\"mouse-hover-content\"]//a[2] ")).click();
			   AssertJUnit.assertEquals(stringtest, "Practice Page");
			//   driver.close();
		}
		//Select testing
		@Test (priority=6)
		public void selectTesting() throws InterruptedException {
			
			
			 WebElement carselect=driver.findElement(By.id("carselect"));
			 Select select= new Select(carselect);
			 select.selectByIndex(1);
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].setAttribute('style', 'background: tomato; border: 5px steelblue;');", carselect);
			 select.selectByIndex(2);
		 js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 5px steelblue;');", carselect);
			 select.selectByIndex(0);
//			 js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 5px steelblue;');", carselect);
			 
			 
			// Multiple Select Example testing
			 WebElement multisel=driver.findElement(By.id("multiple-select-example"));
			 Select multiselect=new Select(multisel);
			 multiselect.selectByIndex(0);
			 multiselect.selectByVisibleText("Peach");
			 Thread.sleep(2000);
		     multiselect.deselectByIndex(0);
		     multiselect.selectByIndex(0);
		     multiselect.selectByVisibleText("Orange");
		    // driver.close();
		}
		
		
		
		// Mouse hover testing 2
		@Test (priority=7, groups= {"smoke"})
		public void mousehoverTesting2() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)");
			   Actions act=new Actions(driver);
			   act.moveToElement(driver.findElement(By.id("mousehover"))).perform();
			   Thread.sleep(2000);
			   driver.findElement(By.xpath("//div[@class=\"mouse-hover-content\"]//a[1] ")).click();
			   
			   
			   String tablecourse=driver.findElement(By.xpath("//table[@id=\"product\"]//tr[2]//td[2]")).getText();
			   
			   System.out.println(tablecourse);
			     String tableval="35";
			   driver.findElement(By.xpath("//table[@id=\"product\"]//tr[2]//td[3]")).getText();
			   System.out.println(driver.findElement(By.xpath("//table[@id=\"product\"]//tr[2]//td[3]")).getText());
			   System.out.println(driver.findElement(By.xpath("//table[@id=\"product\"]//tr[2]//td[3]")).getText());
			  AssertJUnit.assertEquals(driver.findElement(By.xpath("//table[@id=\"product\"]//tr[2]//td[3]")).getText(), tableval);
			   
			  js.executeScript("window.scrollBy(0,1000)");
		//	  driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
			  driver.switchTo().frame(0);
			  driver.findElement(By.xpath("//div[@class=\"navbar navbar-fedora navbar-fixed-top is-at-top bs-docs-nav is-not-signed-in\"][@id=\"navbar\"]/div/div/button")).click();

//			  
			    WebElement login=driver.findElement(By.xpath("//a[@class=\"navbar-link fedora-navbar-link\"]"));

	              WebElement prac=driver.findElement(By.xpath("//a[@class=\"fedora-navbar-link navbar-link\"]"));		  
			  //		  
			  js.executeScript("arguments[0].setAttribute('style', 'background: tomato; border: 5px solid red;');", prac); 
			  js.executeScript("arguments[0].setAttribute('style', 'background: steelblue; border: 5px green;');", login);
			  
		
		}
		
		
		 @AfterMethod
		 
		 public void closebrowser() {
			 
			 driver.close();
		
		
		
		
		 }
		
		
	   }
		
		


