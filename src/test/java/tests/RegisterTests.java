package tests;

import org.testng.annotations.Test;
import pages.RegisterPage;
import tests.BaseTest;
import utils.ExtentReports.ExtentTestManager;


public class RegisterTests extends BaseTest {
    @Test(priority = 0, description = "User can sign up successfully an account on Zinio system.")
    public void positiveRegisterTest () throws InterruptedException{
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("User can sign up successfully an account on Zinio system.");

        //*************PAGE INSTANTIATIONS*************
        RegisterPage registerPage = new RegisterPage(driver,wait);

        //*************PAGE METHODS********************
        // Go to Register Page
        registerPage.goToRegisterPage();
        registerPage.signUpAnAccount("testUser15@email.com","12345678","12345678");
        registerPage.clickOnSignUpButton();
        Thread.sleep(5000);

    }
    @Test(priority = 1, description = "invalid register scenario with wrong email")
    public void invalidRegisterWrongEmail () throws InterruptedException{
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("invalid register scenario with wrong email");

        //*************PAGE INSTANTIATIONS*************
        RegisterPage registerPage = new RegisterPage(driver,wait);

        //*************PAGE METHODS********************
        // Go to Register Page
        registerPage.goToRegisterPage();
        registerPage.signUpAnAccount("kuyiuhhkhkhkj","12345678","12345678");

        registerPage.verifySignUpEmail("The E-mail is incorrect");
        Thread.sleep(5000);

    }
    @Test (priority = 2, description = "invalid register scenario with all fields are blank")
    public void invalidRegisterBlankCase () throws InterruptedException{
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("invalid register scenario with all fields are blank");
        //*************PAGE INSTANTIATIONS*************
        RegisterPage registerPage = new RegisterPage(driver,wait);

        //*************PAGE METHODS********************
        // Go to Register Page
        registerPage.goToRegisterPage();
        registerPage.signUpAnAccount("","","");
        registerPage.verifySignUpEmail("The E-mail is incorrect");
        Thread.sleep(5000);
    }
    @Test(priority = 3, description = "invalid register scenario with already existed email")
    public void invalidRegisterExistedEmail () throws InterruptedException{
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("invalid register scenario with already existed email");

        //*************PAGE INSTANTIATIONS*************
        RegisterPage registerPage = new RegisterPage(driver,wait);

        //*************PAGE METHODS********************
        // Go to Register Page
        registerPage.goToRegisterPage();
        registerPage.signUpAnAccount("testUser05@email.com","12345678","12345678");
        registerPage.clickOnSignUpButton();
        //Thread.sleep(10000);
        registerPage.verifyExistSignUpEmail("A user with the email address you entered already exists. Please try entering a different email address.");
        Thread.sleep(5000);

    }
}
