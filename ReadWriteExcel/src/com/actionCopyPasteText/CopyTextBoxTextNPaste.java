package com.actionCopyPasteText;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CopyTextBoxTextNPaste {
	
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///C:/Downloaded%20Programs/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
        WebElement elm1 = driver.findElement(By.id("email"));
        WebElement elm2 = driver.findElement(By.id("password"));
        Actions actions = new Actions(driver); 
      
       	actions.sendKeys(elm1, "Vanita").doubleClick().keyDown(Keys.CONTROL).sendKeys("C").build().perform();
        actions.click(elm2).keyDown(Keys.CONTROL).sendKeys("V").build().perform();
    //    actions.keyUp(Keys.CONTROL).build().perform();  //no need to write build().perform() on above 2 lines if we write at this line
        
        String str = elm2.getText();
        System.out.println(str);			//not printing on console

   //     driver.close();

   
	}

}
