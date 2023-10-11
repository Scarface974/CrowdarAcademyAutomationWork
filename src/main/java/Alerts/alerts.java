package Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public class alerts {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://practice.automationtesting.in/";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chrome.exe");

        WebDriver driver = new ChormeDriver();

        driver.get(url);

        List<WebElement> buttons = driver.findElements(By.xpath("//*[@id=\"dismiss-button\"]/div/svg"));

        Thread.sleep(2000);
        buttons.get(0).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }



}
