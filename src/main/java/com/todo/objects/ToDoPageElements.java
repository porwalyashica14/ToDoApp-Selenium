package com.todo.objects;


/*
 * ToDoPageElements Interface - Elements of ToDo Screen
 * */
public interface ToDoPageElements {
	
	//Xpath
	String TITLE_XPATH = "/html/body/todo-app/section/header/h1";
	String FOOTER_XPATH = "/html/body/footer/p[1]";
	String ADD_TODO_XPATH = "/html/body/todo-app/section/header/input";
	String EDIT_TODO_XPATH = "/html/body/todo-app/section/section/ul/li[1]/input";
	String TODO_TEXT1_XPATH= "/html/body/todo-app/section/section/ul/li/div/label";
	
	//Class
	String COMPLETED_CLASS = "completed";
	String CLEAR_COMPLETED_CLASS = "clear-completed";
	String DESTROY_CLASS = "destroy";
	String TODO_COUNT_CLASS = "todo-count";
	String TODO_LIST_CLASS = "todo-list";
	String VIEW_CLASS = "view";
	String EDITING_CLASS = "editing";
	String TOGGLE_CLASS = "toggle";

}
