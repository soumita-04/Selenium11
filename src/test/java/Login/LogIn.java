package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
import java.util.Set;

public class LogIn {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.findElement(By.xpath("(//a[@title='Login'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("8420019635");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")).click();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the OTP: ");
        String otp = scanner.nextLine();
        scanner.close();

        List<WebElement> otpInputs = driver.findElements(By.cssSelector("input.r4vIwl.IX3CMV"));

        for (int i = 0; i < otp.length(); i++) {
            otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }

        Thread.sleep(10000);


        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Iphone 16");
        driver.findElement(By.xpath("//button[@aria-label='Search for Products, Brands and More']")).click();


        String mainPage = driver.getWindowHandle();
        System.out.println("Main page" + mainPage);
        driver.findElement(By.xpath("(//a[contains(@href, '/p/')])[2]")).click();


        Set<String> allPages = driver.getWindowHandles();
        for (String page : allPages) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
            }
        }
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Deliver Here']")));
        driver.findElement(By.xpath("//button[text()='Deliver Here']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2));
        driver.findElement(By.xpath("//button[text()='CONTINUE']\")\n")).click();
        WebElement cardNumber = wait.until(ExpectedConditions.elementToBeClickable(By.name("cardNumber")));
        cardNumber.sendKeys("1234 5678 9012 3456");

        WebElement expiryDate = driver.findElement(By.name("expiry"));
        expiryDate.sendKeys("12/26");

        WebElement cvv = driver.findElement(By.name("cvv"));
        cvv.sendKeys("123");


    }

}
//*[@id="to-payment"]/button