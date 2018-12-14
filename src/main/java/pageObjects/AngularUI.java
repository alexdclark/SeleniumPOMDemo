package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class AngularUI {
	
	private static WebElement element = null;
	
	public static WebElement column_Dropdown(WebDriver Driver) {
		
		element = Driver.findElement(By.xpath("//div[@title='4 columns selected']"));
		return element;
		
	}
	
	public static WebElement column_Dropdown_ID_Column(WebDriver Driver) {
		
		element = Driver.findElement(By.xpath("//label[contains(text(),'id')]"));
		return element;	
		
	}
	
	public static WebElement column_Dropdown_UserID_Column(WebDriver Driver) {
			
			element = Driver.findElement(By.xpath("//label[contains(text(),'User ID')]"));
			return element;	
			
	}
	
	public static WebElement column_Dropdown_Title_Column(WebDriver Driver) {
		
		element = Driver.findElement(By.xpath("//label[contains(text(),'title')]"));
		return element;	
		
		
	}
	
	public static WebElement column_Dropdown_Body_Column(WebDriver Driver) {
		
		element = Driver.findElement(By.xpath("//label[contains(text(),'body')]"));
		return element;	
		
	}	

	public static WebElement ID_Column(WebDriver Driver) {
			
		element = Driver.findElement(By.xpath("//th[@id='id']"));
		return element;
			
	}
		
	public static WebElement Body_Column(WebDriver Driver) {
		
		element = Driver.findElement(By.xpath("//th[@id='body']"));
		return element;
		
	}
	
	public static WebElement Title_Column(WebDriver Driver) {
			
		element = Driver.findElement(By.xpath("//th[@id='title']"));
		return element;
			
	}
	
	public static WebElement UserID_Column(WebDriver Driver) {
		
		element = Driver.findElement(By.xpath("//th[@id='userID']"));
		return element;
		
	}
		
	public static WebElement Search_Box(WebDriver Driver) {
			
		element = Driver.findElement(By.xpath("//input[@role='textbox']"));
		return element;
			
	}
	
}
