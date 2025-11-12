package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[.='My Account']")
	WebElement msgHeading;

	@FindBy(xpath="(//a[.='Logout'])[1]")
	WebElement lnkLogout;

	public boolean isMyPageExists()
	{
		try {
		return(msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	public void clickLogout() {
		lnkLogout.click();
	}


}
