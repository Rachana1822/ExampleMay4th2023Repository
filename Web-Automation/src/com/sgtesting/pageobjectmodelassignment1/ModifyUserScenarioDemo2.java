package com.sgtesting.pageobjectmodelassignment1;

//Launch Browser-->Navigate-->Login-->Create user-->Modify user-->Delete user-->Logout-->Close application

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModifyUserScenarioDemo2 {
	public static WebDriver oBrowser=null;
	public static ActiPage oPage=null;

	public static void main(String[] args) 
	{
		launchBrowser();
		navigate();
		login("admin","manager");
		minimizeFlyoutWindow();
		createUser("User1","Demo1","user1demo@gmail.com","User1Demo1","WelcomeUser1");
		modifyUser("WelcomeAgainUser1");
		deleteUser();
		logout();
		closeApplication();
	}

	private static void launchBrowser() 
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
			oPage=new ActiPage(oBrowser);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void navigate()
	{
		try
		{
			oBrowser.get("http://localhost/login.do");
			Thread.sleep(5000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void login(String userName, String password)
	{
		try
		{
			oPage.getUserName().sendKeys(userName);
			oPage.getPassword().sendKeys(password);
			oPage.getLoginButton().click();
			Thread.sleep(5000);			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void minimizeFlyoutWindow()
	{
		try
		{
			oPage.getFlyOutWindow().click();
			Thread.sleep(2000);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void createUser(String fn,String ln,String email,String un,String pwd)
	{
		try
		{
			oPage.getUserLink().click();
			Thread.sleep(2000);
			oPage.getAddUserButton().click();
			Thread.sleep(2000);
			oPage.getFirstName().sendKeys(fn);
			oPage.getLastName().sendKeys(ln);
			oPage.getEmail().sendKeys(email);
			oPage.getUserName().sendKeys(un);
			oPage.getUserPassword().sendKeys(pwd);
			oPage.getUserPasswordCopy().sendKeys(pwd);
			oPage.getCreateUserButton().click();
			Thread.sleep(5000);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void modifyUser(String newPassword)
	{
		try
		{
			oPage.getUser1LinkFromList().click();
			Thread.sleep(2000);
			oPage.getUserPassword().sendKeys(newPassword);
			oPage.getUserPasswordCopy().sendKeys(newPassword);
			oPage.getSaveChangesButton().click();
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void deleteUser()
	{
		try
		{
			oPage.getUser1LinkFromList().click();
			Thread.sleep(2000);
			oPage.getDeleteUserButton().click();
			Thread.sleep(2000);
			Alert oAlert=oBrowser.switchTo().alert();
			String content=oAlert.getText();
			Thread.sleep(2000);
			System.out.println(content);
			oAlert.accept();
			Thread.sleep(2000);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void logout()
	{
		try
		{
			oPage.getLogoutButton().click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void closeApplication()
	{
		try
		{
			oBrowser.close();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

