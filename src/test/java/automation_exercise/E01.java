package automation_exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class E01 {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }


    @Test
    public void RegisterUser(){
        //Test Case 1: Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Alex", Keys.TAB,"alex@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Mustafa", Keys.TAB,"mustafadaggg44@gmail.com","330217");

        WebElement day =    driver.findElement(By.xpath("//select[@id='days']"));
        Select dayDropDown = new Select(day);
        dayDropDown.selectByVisibleText("3");

        WebElement month =    driver.findElement(By.xpath("//select[@id='months']"));
        Select monthDropDown = new Select(month);
        monthDropDown.selectByVisibleText("March");

        WebElement year =    driver.findElement(By.xpath("//select[@id='years']"));
        Select yearDropDown = new Select(year);
        yearDropDown.selectByVisibleText("1991");


        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();


        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Mustafa",Keys.TAB,
                "DAG",Keys.TAB,"ABC",Keys.TAB,"OGR",Keys.TAB,"MAH");

        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select countryDropDown = new Select(country);
        countryDropDown.selectByVisibleText("Canada");

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Mersin",Keys.TAB,"Tarsus",
                Keys.TAB,"3333",Keys.TAB,"0552");


        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@*='btn btn-primary']")).click();

        //16. Verify that 'Logged in as username' is visible
        driver.navigate().back();
        driver.navigate().forward();
        List<WebElement> webElements = driver.findElements(By.xpath("//*[@class='nav navbar-nav']"));
        WebElement son=   webElements.get(webElements.size()-1);
        Assert.assertTrue(son.isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//*[@*='btn btn-primary']")).click();


    }

    @After
    public void tearDown(){
        driver.close();
    }


}
