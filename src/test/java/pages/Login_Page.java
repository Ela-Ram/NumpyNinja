package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Login_Page {
	
	WebDriver driver;
	
	@FindBy(className ="btn")public WebElement getStdButton;
	@FindBy(linkText="Sign in")public	 WebElement signInButton;
	@FindBy(id="id_username")public WebElement usernameField;
	@FindBy(id="id_password")public WebElement passwordField;
	@FindBy(xpath="//input[@type='submit']")public WebElement loginButton;
	@FindBy(xpath="//div[@class='alert alert-primary']")public WebElement invalidcredAlert;
	@FindBy(xpath="//div[@class='alert alert-primary']")public WebElement loginalert;
	@FindBy(linkText ="Sign out") WebElement logoutButton;
	
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signinPage() {
		getStdButton.click();	
	}
	
	public String PageTitle() {
		return driver.getTitle();	
	}
	
	public String errmsg(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
    return (String)js.executeScript("return arguments[0].validationMessage;",element);
    }
	
   public void emptyPassword(String username) {
	usernameField.sendKeys(username);
   }
   
   public void emptyUsername(String password) {
	passwordField.sendKeys(password);
   }	
   
   public void Credentials(String username, String password) {
	usernameField.sendKeys(username);
	passwordField.sendKeys(password);
   }
    public void CurrentUrl() {
    	//String url = ConfigReader.getProperty("URL");
    	String url = common.ConfigReader.getProperty("URL");
    	String curUrl =driver.getCurrentUrl();
    	System.out.println("Current URL :" +curUrl);
    	Assert.assertEquals(url, curUrl);
    }
   
}




















/* public  String url() {
String url = PropertyFileReader.getProperty("dsAlgoSign.URL");
String currenturl = driver.getCurrentUrl();
if(!currenturl.equals(url))
{
throw new AssertionError("User is not in sign in page");						
}
return currenturl;		
} 

public String gturrentUrl() {
return driver.getCurrentUrl();
}
public String alert() {
Alert alert =driver.switchTo().alert();
String alertmsg =alert.getText();

return alertmsg;
}*/


	


