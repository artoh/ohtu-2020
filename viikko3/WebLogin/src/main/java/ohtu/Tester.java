package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {
    
    private static void succesfullLogin(WebDriver driver) {
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);        
    }
    

        private static void wrongPasswordLogin(WebDriver driver) {
        
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);        
    } 
        
        private static void addUser(WebDriver driver) {
        
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);


Random r = new Random();
    
element = driver.findElement(By.name("username"));
element.sendKeys("mikko"+r.nextInt(100000));        
        
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("pekka");        
        element = driver.findElement(By.name("signup"));        
        sleep(2);
        element.submit();

        sleep(3);        
    }   
        
    private static void logoutAfterRegistration(WebDriver driver) {
         WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
                sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4567");

           // Tester.succesfullLogin(driver);
           // Tester.wrongPasswordLogin(driver);
           Tester.addUser(driver);
           Tester.logoutAfterRegistration(driver);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
