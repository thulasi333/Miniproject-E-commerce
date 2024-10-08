package com.project;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//		WebElement account = driver.findElement(By.xpath("//a[text()=\"Create an Account\"]"));  //create account
//		account.click();
//		WebElement firstname = driver.findElement(By.id("firstname"));
//		firstname.sendKeys("Thulasi");
//		WebElement lastname = driver.findElement(By.id("lastname"));
//		lastname.sendKeys("Padmanaban");
//		WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
//		email.sendKeys("thulasi@gmail.com");
//		WebElement password = driver.findElement(By.id("password"));
//		password.sendKeys("Thulasi@19");
//		WebElement confirm = driver.findElement(By.id("password-confirmation"));
//		confirm.sendKeys("Thulasi@19");
//		WebElement createbutton = driver.findElement(By.xpath("//button[@title=\"Create an Account\"]"));
//		createbutton.click();
//		if(password.equals(confirm)) {
//			System.out.println("Password set Successfully");
//		}
//		else {
//			System.out.println("invalid password");
//		}
		
		WebElement signin = driver.findElement(By.xpath("//li[@class=\"authorization-link\"]"));//sign in
		signin.click();
		WebElement email1 = driver.findElement(By.xpath("//input[@type=\"email\"]"));
		email1.sendKeys("thulasi@gmail.com");
		WebElement password1 = driver.findElement(By.name("login[password]"));
		password1.sendKeys("Thulasi@19");
		WebElement submit = driver.findElement(By.id("send2"));
		submit.click();
		System.out.println("Successfully Login");
		
		Actions action = new Actions(driver);                                               //STEP3 ACTION
    	WebElement men = driver.findElement(By.id("ui-id-5"));
		action.moveToElement(men).build().perform();
		WebElement top = driver.findElement(By.id("ui-id-17"));
		action.moveToElement(top).build().perform();
		WebElement shirt = driver.findElement(By.id("ui-id-20"));
		shirt.click();
		
		WebElement sort = driver.findElement(By.id("sorter"));                              //DROP-DOWN
		Select sortby = new Select(sort);
		sortby.selectByIndex(2);
	
		WebElement shopping = driver.findElement(By.xpath("//div[text()=\"Material\"]"));    //STEP4 ACTION
		action.moveToElement(shopping).click().build().perform();
		WebElement  hemp = driver.findElement(By.xpath("//a[contains(text(),'Hemp')]"));
		action.moveToElement(hemp).build().perform();
		
//		action.click(hemp).build().perform();
		action.contextClick(hemp).build().perform();                                        //STEP5
		 Robot newtab = new Robot();                                                         //ROBOT                                  
		 newtab.keyPress(KeyEvent.VK_DOWN);
    	 newtab.keyRelease(KeyEvent.VK_DOWN);
    	 newtab.keyPress(KeyEvent.VK_ENTER);
		 newtab.keyRelease(KeyEvent.VK_ENTER);
		 
		 String parentWindow = driver.getWindowHandle();                                   //WINDOWHANDLE
		  System.out.println("parentid" + parentWindow);
		  
		   Set<String> windows = driver.getWindowHandles();
		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));        //Explicitly wait
		    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		    
		    for(String child : windows) {
		    	if (!parentWindow.equalsIgnoreCase(child))
		    	{
		    		driver.switchTo().window(child);
		    		
		    	}
		    }
		    Thread.sleep(3000);
		      
		   WebElement hoodie = driver.findElement(By.className("product-item-info"));
		   hoodie.click(); 
		   WebElement selectsize = driver.findElement(By.xpath("//div[@option-id=\"168\"]"));
		   selectsize.click();
		   WebElement greencolor = driver.findElement(By.xpath("//div[@option-label=\"Green\"]"));
		   greencolor.click();
		   System.out.println(greencolor);
		   WebElement qty =driver.findElement(By.xpath("//input[@id=\"qty\"]"));
		   qty.clear();
		   Thread.sleep(3000);
		   qty.sendKeys("4");
		   WebElement addtocart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
		   action.click(addtocart).build().perform();
		   driver.switchTo().window(parentWindow);
		   driver.navigate().back();
		   WebElement clear = driver.findElement(By.xpath("//span[text()=\"Clear All\"]"));
		   action.click(clear).build().perform();
		   
		   WebElement hoodie2 = driver.findElement(By.xpath("//img[@alt=\"Oslo Trek Hoodie\"]"));
		   hoodie2.click();
		   WebElement sizel = driver.findElement(By.xpath("//div[@option-id=\"169\"]"));
		   sizel.click();
		   WebElement redcolor = driver.findElement(By.xpath("//div[@option-label=\"Red\"]"));
		   redcolor.click();
		   WebElement addtocart1 = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
		   action.click(addtocart1).build().perform();
		   
		   WebElement cart = driver.findElement(By.xpath("//span[contains(text(),\"My Cart\")]"));
		   cart.click();
		   WebElement edit = driver.findElement(By.className("//span[contains(text(),'View and Edit Cart']"));
		   edit.click();
//		   WebElement qty1 = driver.findElement(By.xpath("//input[@name=\"qty\"]"));
		  List<WebElement>qty1=driver.findElements(By.xpath("//input[@name=\"qty\"]"));
		  for(WebElement quantity:qty1) {
			  quantity.clear();
			   Thread.sleep(3000);
			   quantity.sendKeys("2");
		  }
		   
		   WebElement update = driver.findElement(By.className("action update"));
		   update.click();
		   
		   WebElement proceed = driver.findElement(By.className("action primary checkout"));
		   proceed.click();
		   Thread.sleep(3000);
		   
		   
		   WebElement street = driver.findElement(By.xpath("//input[@name='street[0]']"));
		   street.sendKeys("Gandhi street");
		   WebElement city = driver.findElement(By.xpath("//input[@name=\"city\"]"));
		   city.sendKeys("Chennai");
		   WebElement region = driver.findElement(By.id("XHF9BLS"));
		   Select select = new Select(region);
		   select.selectByVisibleText("TamilNadu");
		   WebElement postal = driver.findElement(By.xpath("//input[@name=\"postcode\"]"));
		   postal.sendKeys("600200");
		   WebElement country = driver.findElement(By.xpath("//input[@name='country_id']"));
		   Select select1 =new Select(country);
		   select1.selectByVisibleText("India");
		   WebElement phone = driver.findElement(By.xpath("//input[@name=\"telephone\"]"));
		   phone.sendKeys("6543216767");
		   WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
		   next.click();
		   WebElement place = driver.findElement(By.xpath("//span[contains(text(),'Place Order')]"));
		   place.click();
		   Thread.sleep(5000);
		   TakesScreenshot shot = (TakesScreenshot) driver;
		   File source = shot.getScreenshotAs(OutputType.FILE);
			File destination = new File("C:\\Users\\acer\\eclipse-workspace\\July1\\src\\com\\project\\Screenshot\\shot.png");
			FileHandler.copy(source, destination);
			}
		
	}


