package com.sgtesting.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogoutacti {
	public static WebDriver o=null;
	public static Actipage opage=null;

	public static void main(String[] args) {
		Launch();
		Navigate();
		 login();
		 minimize();
		 logout();
		 close();
	}
	private static void Launch()
	{
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			o=new ChromeDriver();
			opage=new Actipage(o);
			
		} catch (Exception e) {
			
		}
	}
	private static void Navigate()
	{
		try {
			 o.get("http://localhost/login.do");
			 Thread.sleep(5000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    private static void login()
    {
    	try {
    		opage.getUserName().sendKeys("admin");
    		Thread.sleep(2000);
    		opage.getPassword().sendKeys("manager");
    		Thread.sleep(2000);
    		opage.getLoginButton().click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    private static void minimize()
	{
		try {
			 opage.getFlyoutWindow().click();
			 Thread.sleep(5000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    private static void logout()
   	{
   		try {
   			 opage.getLogoutButton().click();
   			 Thread.sleep(5000);
   			
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   	}
    private static void close()
   	{
   		try {
   			 
   			o.close();
   			
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   	}
    
}