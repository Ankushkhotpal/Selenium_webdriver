/*
 * Created by	: Ankush Khotpal
 * Created on	: 24/12/2016
 * Purpose		: Script for automating the ftcash payment page Functionality. 
 */

package com.org.ftcash;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App {

	public static WebDriver driver;
	
	
	public static void main(String[] args)throws Exception  
	{
		//STEP 1
				//Setting up Webdriver properties 
				driver = new ChromeDriver();
				
		//STEP 2
				//For URL Input in Browser window
				String Link =("https://www.ftcash.com/app/pay/store/nomisma");
				driver.get(Link);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		//STEP 3
				//Maximize browser window
				driver.manage().window().maximize();
				
				try 
				{
		//STEP 4
				// For 1st page General Information
					//for Text input
					String Name = "Ankush";
					driver.findElement(By.id("name")).sendKeys(Name);
					Thread.sleep(1000);
					String Email = "ankush.khotpal@gmail.com";
					driver.findElement(By.id("email")).sendKeys(Email);
					Thread.sleep(1000);
					String Mobile = "9035237738";
					driver.findElement(By.id("mobile")).sendKeys(Mobile);
					Thread.sleep(1000);
					String Amount = "10";
					driver.findElement(By.id("amount")).sendKeys(Amount);
					Thread.sleep(1000);
					String CarNumber = "MH01BT0738";
					driver.findElement(By.id("description")).sendKeys(CarNumber);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(1000);		
					//For proceed to Pay button action
					driver.findElement(By.xpath(".//*[@id='step1']/div/div")).click();
					driver.findElement(By.xpath(".//*[@id='step1']/div/div/button")).click();
					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//Thread.sleep(1000);
				
				
		//STEP 5
				//For 2nd offers page
					
				/*  //For Promo Code Input 
				 * 	String promoCode = "ftcash";
					driver.findElement(By.id("code")).sendKeys(promoCode); */
					Thread.sleep(1200);
					
					//For proceed to pay button action
					driver.findElement(By.xpath(".//*[@id='step2']/div/div/div/div")).click();
					//Thread.sleep(1200);
					driver.findElement(By.linkText("Proceed to pay")).click();
					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//Thread.sleep(1000);
					
					
		//STEP 6
				//For 3rd payment page

					//For Credit Card Radio Button Selection
					String Rdclass = "div[id='error-radio']";
					driver.findElement(By.cssSelector(Rdclass)).click();
					
					driver.findElement(By.xpath(".//*[@id='error-radio']/div[1]/label/span[1]")).click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
		/* For Credit Card Credential*/
					//For Card Name Text Input Box
					String CardName = "ANKUSH V KHOTPAL";
					String Cla = "input[id='cc_name']";
					driver.findElement(By.cssSelector(Cla)).click();
					driver.findElement(By.cssSelector(Cla)).sendKeys(CardName);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//For Card Number Input Box
					String CardNo = "5126520161571729";
					String Cno = "input[id='checkout_card_number']";
					driver.findElement(By.cssSelector(Cno)).sendKeys(CardNo);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//For MONTH Drop List 
					String DropList = ".//*[@id='card-form']/div[4]/div[1]/div/div[1]/select";
					Select monthlist= new Select(driver.findElement(By.xpath(DropList)));
					
					monthlist.selectByIndex(1);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					monthlist.selectByValue("Dec");
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//For YEAR Drop List
					String DropListID = "years_pop";
					Select expYear = new Select(driver.findElement(By.id(DropListID)));
				
					expYear.selectByIndex(1);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					expYear.selectByValue("2020");
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//For Card CVV Code Input box
					String Key = "200";
					String Cvv = "input[id='cvv']";
					driver.findElement(By.cssSelector(Cvv)).sendKeys(Key);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//For Pay Button Click Action
					String Pay = "button[id='pay_by_cc']";
					driver.findElement(By.cssSelector(Pay)).click();
					
		//STEP 7	
					//Terminate Application
					Thread.sleep(6000);
					driver.close();
					driver.quit();
				} catch (Exception e)
				{
					// TODO: handle exception
					e.printStackTrace();
				}					
				

	}

}
