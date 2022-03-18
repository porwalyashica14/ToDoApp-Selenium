package com.todo.utils;

import java.util.List;

/*
 * ElementFetch class - To get the elements of ToDo Screen
 * */

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.todo.BaseTest;

public class ElementFetch {

	public WebElement getWebElement(String identifierType, String identifierValue) {
		switch (identifierType) {
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifierValue));
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(identifierValue));
		case "CLASSNAME":
			return BaseTest.driver.findElement(By.className(identifierValue));
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));
		default:
			return null;
		}
	}

	public List<WebElement> getListWebElements(String identifierType, String identifierValue) {
		switch (identifierType) {
		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifierValue));
		case "TAGNAME":
			return BaseTest.driver.findElements(By.tagName(identifierValue));
		case "CLASSNAME":
			return BaseTest.driver.findElements(By.className(identifierValue));
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifierValue));
		default:
			return null;
		}
	}
	
	public boolean isClassElementPresent(String identifierType, String identifierValue) {
		try {
		BaseTest.driver.findElement(By.className(identifierValue));
		return true;
		} catch (NoSuchElementException e) {
			return false;
		}	
	}
	
}
