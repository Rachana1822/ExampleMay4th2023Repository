package com.sgtesting.tests;

public class ExecuteAutoITFile {

	public static void main(String[] args) {
		executeAutoItFile();

	}
	private static void executeAutoItFile()
	{
		try
		{
			Runtime obj=Runtime.getRuntime();
			obj.exec("E:\\SeleniumAutomation\\Audit\\DemoScenarioFirst.exe");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
