/*						    		Placing Order using Automation
 * Key Learnings: 
 * 				Adding the product using search bar
 * 				Adding the product using Navigation
 * 				Handling the pops
 * 				LogIn as a Guest User
 * 				Checkout the product
 * 				Handling the dropdowns
 */

//importing the java and selenium libraries
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

//Declaring a class to place an order
public class AddtoCart {

	//Declaring the main method
    public static void main(String[] args) {
    	
    	//Setting Chrome driver for this project -> since I am using chrome as my browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RuchitaDas\\Documents\\java\\Project\\Starting\\src\\drivers\\chromedriver.exe");
        
        //creating an object for 
        WebDriver driver = new ChromeDriver();
     
        //Wait for load the pages -> implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //Maximize the screen
        driver.manage().window().maximize();
        
        //Open the Website (Navigation)
        driver.get("https://sandbox.omnireach.in/yacceleratorstorefront?site=electronics&clear=true");
        
        //Search bar functionality -> Ex: Webcam
        //Clicking enter button
        driver.findElement(By.id("js-site-search-input")).sendKeys("Webcam" + Keys.RETURN);
        
        //Scrolling the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[normalize-space()='QuickCam for Notebooks Pro']")));
        
        //selecting the desire product -> Ex: QuickCam for Notebooks Pro
        driver.findElement(By.xpath("//a[normalize-space()='QuickCam for Notebooks Pro']")).click();
        
        //Adding the quantities
        int i=5;
        while(i>1) {
        driver.findElement(By.cssSelector("button[class='btn btn-default js-qty-selector-plus'] span[class='glyphicon glyphicon-plus']")).click();
        i--;
        }
        
        //Add the product from PDP page
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block js-add-to-cart js-enable-btn btn-icon glyphicon-shopping-cart']")).click();
        
        //Proceed to Cart Page
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-block add-to-cart-button']")).click();
        
        //Continue Shopping
        driver.findElement(By.xpath("//div[@class='cart__actions border']//button[@class='btn btn-default btn-block btn--continue-shopping js-continue-shopping-button'][normalize-space()='Continue Shopping']")).click();
        
        //Add another product from mega navigation
        driver.findElement(By.xpath("//a[@title='Camera Accessories & Supplies']")).click();
        
        //Scroll and select the item
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[normalize-space()='DTC-1000 Component Cable']")));
        
        //Adding the product from PLP page
        driver.findElement(By.xpath("//form[@id='addToCartForm768108']//button[@type='submit']")).click();
        
        //Proceed to Cart page
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-block add-to-cart-button']")).click();
        
        
        //Proceed to Checkout page
        driver.findElement(By.cssSelector("div[class='cart__actions border'] button[class='btn btn-primary btn-block btn--continue-checkout js-continue-checkout-button']")).click();
        
        //Login as a guest user
        driver.findElement(By.id("guest.email")).sendKeys("test@test.com");
        driver.findElement(By.id("guest.confirm.email")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//button[normalize-space()='Check Out as a Guest']")).click();
        
        //Shipping Address Page
        //Scroll to the "Country Address" dropdown
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("address.country")));
        
        //Click the "Country Address" dropdown and select "Germany"
        driver.findElement(By.id("address.country")).click();
        driver.findElement(By.xpath("//option[normalize-space()='Germany']")).click();
        
        //Filling the details for shipping address page
        driver.findElement(By.id("address.firstName")).sendKeys("Test");
        driver.findElement(By.id("address.surname")).sendKeys("Test");
        driver.findElement(By.id("address.line1")).sendKeys("testing purpose");
        driver.findElement(By.id("address.townCity")).sendKeys("test");
        driver.findElement(By.id("address.postcode")).sendKeys("12345");
        driver.findElement(By.id("addressSubmit")).click();
        
        //Shipping Method page
        driver.findElement(By.id("deliveryMethodSubmit")).click();
        
        //Billing Page
        //Scrolling and selecting a card type
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("card_cardType")));
        driver.findElement(By.xpath("//option[normalize-space()='Mastercard']")).click();
        
        //Adding the account number
        driver.findElement(By.id("card_accountNumber")).sendKeys("5555555555554444");
        
        //Scrolling and select the "Expiry Month"
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("ExpiryMonth")));
        Select expiryMonth = new Select(driver.findElement(By.id("ExpiryMonth")));
        expiryMonth.selectByVisibleText("05"); // Selecting May
        
        //Scrolling and select the "Expiry Year"
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("ExpiryYear")));
        Select expiryYear = new Select(driver.findElement(By.id("ExpiryYear")));
        expiryYear.selectByVisibleText("2025"); // Selecting 2040
        
        //Adding other details
        driver.findElement(By.id("card_cvNumber")).sendKeys("789");
        driver.findElement(By.id("useDeliveryAddress")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block submit_silentOrderPostForm checkout-next']")).click();
        
        //Close the browser
        driver.quit();
    }
}
