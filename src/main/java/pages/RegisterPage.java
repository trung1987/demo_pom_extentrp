package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage extends BasePage {

    //*********Constructor*********
    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    //*********Page Variables*********
    String registerLink = "https://www-sbx-web.zinio.com/sign-up";

    //*********Web Elements*********
    String signUpEmail = "//*[@id='signUp-email']";
    String signUpPass = "//*[@id='signUp-password']";
    String signUpConfirmPass = "//*[@id='signUp-confirmPassword']";
    String signUpButton = "//*[@id='signUp-submit']";

    String errorMsgEmailXpath = "//*[@class='ErrorMessage']/span[contains(text(),'The E-mail is incorrect')]";
    String errorMsgPassXpath = "//*[@class='ErrorMessage']/span[contains(text(),'Passwords cannot contain blank spaces.)]";
    String errorMsgPassNotMatch = "//*[@class='ErrorMessage']/span[contains(text(),'The passwords do not match.')]";
    //String errorMsgDuplicatedEmail = "//*[@id='Login-error']/h6[@class='Login-errorTitle' or text()='Error']";
    String errorMsgDuplicatedEmail = "//*[@id='Login-error']/p[@class='Login-errorMessage' or text()='A user with the email address you entered already exists. Please try entering a different email address.']";


    //*********Page Methods*********

    //Go to Register page
    public void goToRegisterPage (){
        driver.get(registerLink);
    }
    public void signUpAnAccount (String Email, String Pass, String confirmPass){

        writeText(By.xpath(signUpEmail),Email);
        writeText(By.xpath(signUpPass),Pass);
        writeText(By.xpath(signUpConfirmPass),confirmPass);

    }
    public void clickOnSignUpButton(){
        click(By.xpath(signUpButton));
    }
    public void verifySignUpEmail(String expectedText){
        Assert.assertEquals(readText(By.xpath(errorMsgEmailXpath)),expectedText);
    }
    public void verifyExistSignUpEmail(String expectedText){
        Assert.assertEquals(readText(By.xpath(errorMsgDuplicatedEmail)),expectedText);

    }
}
