package com.goibibo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CountOfIndigoFlights {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com");
		
	WebElement from = driver.findElement(By.id("gosuggest_inputSrc"));
	from.sendKeys("Pune");

		Select select = new Select(from);
		select.selectByIndex(0);

	//	WebElement to = driver.findElement(By.id("gosuggest_inputDest"));
	//	Select select1 = new Select(to);
	//	select1.selectByValue("Nagpur");

		

	}

}
