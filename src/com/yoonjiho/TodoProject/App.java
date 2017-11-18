package com.yoonjiho.TodoProject;

import java.util.ArrayList;

public class App {
    private static TodoTheme defalutTheme = new TodoTheme();
    private ArrayList<TodoList> todoLists = new ArrayList<>();

    public TodoList makeList() {
        TodoList todoList = new TodoList(defalutTheme);
        todoLists.add(todoList);
        return todoList;
    }
    public TodoList makeList(String name, TodoList.Sort sort, TodoTheme todoTheme) {
        TodoList todoList = new TodoList(name, sort, todoTheme);
        todoLists.add(todoList);
        return todoList;
    }

    public void deleteList(TodoList todoList) {
        todoLists.remove(todoList);
    }

    public void displayLists() {
        if (todoLists.isEmpty()) System.out.println("There is no list. Please make a list.");
        else for (TodoList todoList : todoLists) {
            System.out.println(todoList);
        }
        System.out.println();
    }

    public ArrayList<TodoList> getTodoLists() {
        return todoLists;
    }
}
