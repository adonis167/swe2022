package com.yoonjiho.TodoProject;

import java.awt.*;

public class Main {

    public static void main(String args[]) {
        TodoTheme defaultTheme = new TodoTheme();

        TodoList test = new TodoList(defaultTheme); //new List
        test.setName("To do homework"); //Rename
        test.setSorting(TodoList.BY_NAME_ASC); //Change Sort Option

        test.addTask("a", "2017-01-01");
        test.addTask("t", "2017-04-01");
        test.addTask("d", "2017-03-01");
        test.addTask("f", "2017-02-01");
        test.addTask("w", "2017-06-01");
        test.addTask("c", "2017-07-01");
        test.addTask("j", "2017-09-01");

        test.getTodoTasks().get(0).setDone(true);
        test.getTodoTasks().get(3).setDone(true);
        test.getTodoTasks().get(4).setDone(true);
        test.getTodoTasks().get(6).setDone(true);

        test.setTheme(new TodoTheme(Color.BLUE, null)); //Change TodoTheme
        test.displayTasks();

        test.setDoneTaskOnOff(true); //Hide Done Tasks;
        test.displayTasks();

        test = null; //Delete TodoList

    }
}
