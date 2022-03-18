package com.todo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.todo.events.ToDoPageEvents;

import com.todo.utils.Constants;

/*
 * ToDoTest Class - Class to test ToDO Screen
 * */
 
public class ToDoTest extends BaseTest {

	@Test
	public void testTitleAndFooterExist() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.validateTitleText();
		toDoPageEvents.validateFooter();
	}

	@Test
	public void testItemAndClearCompletedNotVisible() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.verifyClearCompletedNotVisible();
		toDoPageEvents.verifyNumberOfItemsNotVisible();
	}

	@Test
	public void testAddTodo() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.checkExistingToDO(Constants.TODO_TEXT1);
	}

	@Test
	public void testSelectTodo() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.numberOfItemsLeft("1 item left");
		toDoPageEvents.selectToDo();
		toDoPageEvents.isToDoCompleted(Constants.TODO_TEXT1);
		toDoPageEvents.numberOfItemsLeft("0 items left");
	}

	@Test
	public void testEditTodo() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.editToDo(Constants.EDIT_TODO);
	}

	@Test
	public void testAddMultipleTodo() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.addToDo(Constants.TODO_TEXT2);
		List<String> toDos = new ArrayList<String>();
		toDos.add(Constants.TODO_TEXT1);
		toDos.add(Constants.TODO_TEXT2);
		toDoPageEvents.checkMultipleExistingToDO(toDos, 2);
		toDoPageEvents.numberOfItemsLeft("2 items left");
	}

	@Test
	public void testClearSingleToDo() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.selectToDo();
		toDoPageEvents.numberOfItemsLeft("0 items left");
		toDoPageEvents.clickClearCompleted();
		toDoPageEvents.verifyNumberOfItemsNotVisible();
		toDoPageEvents.verifyClearCompletedNotVisible();
	}

	@Test
	public void testClearAllToDos() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.addToDo(Constants.TODO_TEXT2);
		toDoPageEvents.addToDo(Constants.TODO_TEXT3);
		List<String> toDos = new ArrayList<String>();
		toDos.add(Constants.TODO_TEXT1);
		toDos.add(Constants.TODO_TEXT2);
		toDos.add(Constants.TODO_TEXT3);
		toDoPageEvents.selectAllToDos();
		toDoPageEvents.numberOfItemsLeft("0 items left");
		toDoPageEvents.clickClearCompleted();
		toDoPageEvents.toDoNotExist();
	}

	@Test
	public void testMarkMultipleToDosAsCompelted() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.addToDo(Constants.TODO_TEXT2);
		toDoPageEvents.addToDo(Constants.TODO_TEXT3);
		List<String> completedtoDos = new ArrayList<String>();
		completedtoDos.add(Constants.TODO_TEXT1);
		completedtoDos.add(Constants.TODO_TEXT3);
		toDoPageEvents.selectMultipleToDos();
		toDoPageEvents.numberOfItemsLeft("1 item left");
		toDoPageEvents.areMultipleToDoCompleted(completedtoDos);
	}

	@Test
	public void testClearCompletedNotVisibleIfNothingIsSelected() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.addToDo(Constants.TODO_TEXT2);
		toDoPageEvents.numberOfItemsLeft("2 items left");
		toDoPageEvents.verifyClearCompletedNotVisible();
	}

	@Test
	public void testDeleteActiveToDO() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.deleteSingleToDo(Constants.TODO_TEXT1);
		toDoPageEvents.toDoNotExist();
	}

	@Test
	public void testDeleteCompletedToDo() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.selectToDo();
		toDoPageEvents.deleteSingleToDo(Constants.TODO_TEXT1);
		toDoPageEvents.toDoNotExist();
	}

	@Test
	public void testDeleteMultiplesToDos() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.addToDo(Constants.TODO_TEXT2);
		toDoPageEvents.addToDo(Constants.TODO_TEXT3);
		toDoPageEvents.deleteMultipleToDos();
		toDoPageEvents.checkExistingToDO(Constants.TODO_TEXT3);
		toDoPageEvents.numberOfItemsLeft("1 item left");
	}

	@Test
	public void testDeleteAllToDos() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.addToDo(Constants.TODO_TEXT2);
		toDoPageEvents.deleteAllToDos();
		toDoPageEvents.toDoNotExist();
	}

	@Test
	public void testDeleteCompletedToDos() {
		ToDoPageEvents toDoPageEvents = new ToDoPageEvents();
		toDoPageEvents.addToDo(Constants.TODO_TEXT1);
		toDoPageEvents.addToDo(Constants.TODO_TEXT2);
		toDoPageEvents.selectToDo();
		toDoPageEvents.deleteSingleToDo(Constants.TODO_TEXT1);
		toDoPageEvents.checkExistingToDO(Constants.TODO_TEXT2);
	}
}
