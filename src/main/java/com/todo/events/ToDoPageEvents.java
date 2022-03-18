package com.todo.events;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.todo.BaseTest;
import com.todo.objects.ToDoPageElements;
import com.todo.utils.Constants;
import com.todo.utils.ElementFetch;

/*
 * ToDoPageEvents Class - Events for ToDo Screen
 * */

public class ToDoPageEvents {

	public void validateTitleText() {
		ElementFetch elementFetch = new ElementFetch();
		WebElement wb = elementFetch.getWebElement("XPATH", ToDoPageElements.TITLE_XPATH);
		assertTrue(wb.getText().equals(Constants.TITLE_VALUE));
	}

	public void validateFooter() {
		ElementFetch elementFetch = new ElementFetch();
		WebElement wb = elementFetch.getWebElement("XPATH", ToDoPageElements.FOOTER_XPATH);
		assertTrue(wb.getText().equals(Constants.FOOTER_TEXT));
	}

	public void addToDo(String todoText) {
		ElementFetch elementFetch = new ElementFetch();
		WebElement wb = elementFetch.getWebElement("XPATH", ToDoPageElements.ADD_TODO_XPATH);
		wb.sendKeys(todoText);
		wb.sendKeys(Keys.ENTER);
	}

	public void toDoExist(String todoText) {
		ElementFetch elementFetch = new ElementFetch();
		List<WebElement> wbs = elementFetch.getListWebElements("CLASSNAME", ToDoPageElements.TODO_LIST_CLASS);
		boolean isExist = false;
		for (WebElement wb : wbs) {
			if (wb.getText().equalsIgnoreCase(todoText)) {
				isExist = true;
			}
		}
		assertTrue(isExist);
	}

	public void checkExistingToDO(String todoText) {
		ElementFetch elementFetch = new ElementFetch();
		WebElement text = elementFetch.getWebElement("XPATH", ToDoPageElements.TODO_TEXT1_XPATH);
		assertTrue(text.getText().equals(todoText));
	}

	public void checkMultipleExistingToDO(List<String> todosText, int size) {
		ElementFetch elementFetch = new ElementFetch();
		List<WebElement> wbs = elementFetch.getListWebElements("XPATH", ToDoPageElements.TODO_TEXT1_XPATH);
		assertTrue(todosText.size() == 2);
		for (WebElement wb : wbs) {
			assertTrue(todosText.contains(wb.getText()));
		}
	}

	public void selectToDo() {
		ElementFetch elementFetch = new ElementFetch();
		List<WebElement> wb = elementFetch.getListWebElements("CLASSNAME", ToDoPageElements.TOGGLE_CLASS);
		wb.get(0).click();
		assertTrue(wb.get(0).isSelected());
	}

	public void selectAllToDos() {
		ElementFetch elementFetch = new ElementFetch();
		List<WebElement> wbs = elementFetch.getListWebElements("CLASSNAME", ToDoPageElements.TOGGLE_CLASS);
		for (WebElement wb : wbs) {
			wb.click();
		}
	}

	public void selectMultipleToDos() {
		ElementFetch elementFetch = new ElementFetch();
		List<WebElement> wbs = elementFetch.getListWebElements("CLASSNAME", ToDoPageElements.TOGGLE_CLASS);
		wbs.get(0).click();
		wbs.get(2).click();
	}

	public void isToDoCompleted(String todoText) {
		ElementFetch elementFetch = new ElementFetch();
		WebElement wb = elementFetch.getWebElement("CLASSNAME", ToDoPageElements.COMPLETED_CLASS);
		assertTrue(wb.getText().equals(todoText));
	}

	public void areMultipleToDoCompleted(List<String> toDos) {
		ElementFetch elementFetch = new ElementFetch();
		List<WebElement> wbs = elementFetch.getListWebElements("CLASSNAME",
				ToDoPageElements.COMPLETED_CLASS);
		for (WebElement wb : wbs) {
			assertTrue(toDos.contains(wb.getText()));
		}
	}

	public void numberOfItemsLeft(String itemsLeft) {
		ElementFetch elementFetch = new ElementFetch();
		WebElement wb = elementFetch.getWebElement("CLASSNAME", ToDoPageElements.TODO_COUNT_CLASS);
		assertEquals(wb.getText(), itemsLeft);
	}

	public void verifyNumberOfItemsNotVisible() {
		ElementFetch elementFetch = new ElementFetch();
		assertFalse(elementFetch.isClassElementPresent("CLASSNAME", ToDoPageElements.TODO_COUNT_CLASS));
	}

	public void verifyClearCompletedNotVisible() {
		ElementFetch elementFetch = new ElementFetch();
		assertFalse(elementFetch.isClassElementPresent("CLASSNAME", ToDoPageElements.CLEAR_COMPLETED_CLASS));
	}

	public void clickClearCompleted() {
		ElementFetch elementFetch = new ElementFetch();
		WebElement clearCompletedClassElement = elementFetch.getWebElement("CLASSNAME",
				ToDoPageElements.CLEAR_COMPLETED_CLASS);
		clearCompletedClassElement.click();
	}

	public void deleteSingleToDo(String toDoText) {
		ElementFetch elementFetch = new ElementFetch();
		WebElement wb = elementFetch.getWebElement("XPATH", ToDoPageElements.TODO_TEXT1_XPATH);
		BaseTest.actions.moveToElement(wb).perform();
		WebElement destroyWb = elementFetch.getWebElement("CLASSNAME", ToDoPageElements.DESTROY_CLASS);
		destroyWb.click();
	}

	public void deleteMultipleToDos() {
		ElementFetch elementFetch = new ElementFetch();
		List<WebElement> wbs = elementFetch.getListWebElements("CLASSNAME", ToDoPageElements.VIEW_CLASS);
		BaseTest.actions.moveToElement(wbs.get(0)).perform();
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(ToDoPageElements.DESTROY_CLASS)));
		elementFetch.getWebElement("CLASSNAME", ToDoPageElements.DESTROY_CLASS).click();
		elementFetch.getWebElement("CLASSNAME", ToDoPageElements.DESTROY_CLASS).click();
	}

	public void deleteAllToDos() {
		ElementFetch elementFetch = new ElementFetch();
		List<WebElement> wbs = elementFetch.getListWebElements("CLASSNAME", ToDoPageElements.VIEW_CLASS);
		BaseTest.actions.moveToElement(wbs.get(0)).perform();
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(ToDoPageElements.DESTROY_CLASS)));
		for (WebElement wb : wbs) {
			elementFetch.getWebElement("CLASSNAME", ToDoPageElements.DESTROY_CLASS).click();
		}
	}

	public void toDoNotExist() {
		ElementFetch elementFetch = new ElementFetch();
		assertFalse(elementFetch.isClassElementPresent("CLASSNAME", ToDoPageElements.TODO_LIST_CLASS));
	}

	public void editToDo(String todoText) {
		ElementFetch elementFetch = new ElementFetch();
		WebElement wb = elementFetch.getWebElement("XPATH", ToDoPageElements.TODO_TEXT1_XPATH);
		BaseTest.actions.moveToElement(wb).doubleClick().build().perform();
		WebElement editedClassWb = elementFetch.getWebElement("CLASSNAME", ToDoPageElements.EDITING_CLASS);
		BaseTest.actions.moveToElement(editedClassWb).doubleClick().build().perform();
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ToDoPageElements.EDIT_TODO_XPATH)));

		WebElement editedXpathWb = elementFetch.getWebElement("XPATH", ToDoPageElements.EDIT_TODO_XPATH);
		editedXpathWb.sendKeys(Constants.EDIT_TODO);
		editedXpathWb.sendKeys(Keys.ENTER);
		WebElement updatedToDO = elementFetch.getWebElement("XPATH", ToDoPageElements.TODO_TEXT1_XPATH);
		assertTrue(updatedToDO.getText().equals(todoText));
	}

	public void deleteMultipleToDO() {
		ElementFetch elementFetch = new ElementFetch();
		WebElement wb = elementFetch.getWebElement("XPATH", ToDoPageElements.ADD_TODO_XPATH);
		wb.click();
	}
}
