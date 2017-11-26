package com.yoonjiho.TodoProject;

import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void displayMenu() {
        System.out.println("############################################### USAGE ###############################################");
        System.out.println("");
        System.out.println("1. Display all my TodoLists. (describe)");
        System.out.println("2. Add new TodoList. (addList:[List Name])");
        System.out.println("3. Display all my TodoTasks in the list. (list:[List Name])");
        System.out.println("4. Add new TodoTask in the list. (addTodo:[List Name], [Todo Name], [Date]*, [Alarm]**)");
        System.out.println("5. Change a status of the task. (complete:[Todo Name] / incomplete:[Todo Name])");
        System.out.println("6. Save Data and Exit the app. (exit)");
        System.out.println("");
        System.out.println("* Due Date Format ex) 2017-11-30");
        System.out.println("** Alarm Date and Time Format ex) 2017-12-01 17:33");
        System.out.println("");
        System.out.println("#####################################################################################################");
        System.out.println("");
    }

    public void on(InputStream src, App app) throws ParseException {
        Scanner in = new Scanner(src).useDelimiter("\n");
        while (in.hasNext()) {
            String c = in.next();
            //System.out.println(c);
            if ("describe".equals(c))  {
                app.displayLists();
            }
            else if ("exit".equals(c))  {
                app.mTimer.cancel();
                app.writeData();
                return;
            }
            else if (c.contains(":")) {

                String t[] = c.split(":");

                if (t[0].equals("addList")) {
                    app.makeList(t[1]);
                    app.displayLists();
                }

                else if (t[0].equals("list")) {
                    TodoList list = app.getTodoList(t[1]);
                    if (list != null) {
                        list.displayTasks();
                    }
                    else {
                        System.out.println("Incorrect List Name.\n");
                    }
                }

                else if (t[0].equals("addTodo")) {
                    String t2[] = t[1].split(",");
                    if (t2.length < 3) {
                        System.out.println("Illegal usage.\n");
                        continue;
                    }
                    TodoList list = app.getTodoList(t2[0]);
                    if (t2.length == 3) {
                        list.addTask(t2[1], TodoTask.dueDateFormat.parse(t2[2]), null);
                    }
                    else if (t2.length == 4) {
                        t2[3] = t2[3] + ":" + t[2];
                        list.addTask(t2[1], TodoTask.dueDateFormat.parse(t2[2]), TodoTask.reminderDateFormat.parse(t2[3]));
                    }
                    list.displayTasks();
                }

                else if (t[0].equals("complete")) {
                    Object[] listTask = app.getTodoTask(t[1]);
                    TodoList list = (TodoList)listTask[0];
                    TodoTask task = (TodoTask)listTask[1];
                    if (task != null) {
                        task.setDone(true);
                        list.displayTasks();
                    }
                    else {
                        System.out.println("Wrong Task.");
                    }
                }

                else if (t[0].equals("incomplete")) {
                    Object[] listTask = app.getTodoTask(t[1]);
                    TodoList list = (TodoList)listTask[0];
                    TodoTask task = (TodoTask)listTask[1];
                    if (task != null) {
                        task.setDone(false);
                        list.displayTasks();
                    }
                    else {
                        System.out.println("Wrong Task.");
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {

        App app = new App();
        displayMenu();
        new Main().on(System.in, app);

    }
}
