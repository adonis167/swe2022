package com.yoonjiho.TodoProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class App implements Serializable{
    private TodoTheme todoTheme = new TodoTheme();
    private ArrayList<TodoList> todoLists = new ArrayList<>();
    public transient Timer mTimer;
    public transient int timerCount;

    public App() {
        setTimer();
    }

    /**
     *  Set the Timer to check time of the reminders alarm for every N second.
     *  For the test, I set the maximum checking count number is 20.
     */

    public void setTimer() {
        mTimer = new Timer();
        TimerTask mTask = new TimerTask() {
            @Override
            public void run() {
                if (timerCount <= 200) { // <- This is the maximum chk count.
                    //System.out.println(timerCount + ") ############## Reminder Time Checking ( "+ TodoTask.reminderDateFormat.format(new Date()) + ") ##############");
                    for (TodoList todoList : todoLists) {
                        for(TodoTask todoTask : todoList.getTodoTasks()) {
                            if (!todoTask.isAlarm() || todoTask.isDone()) continue;
                            if (TodoTask.reminderDateFormat.format(todoTask.getReminder()).equals(TodoTask.reminderDateFormat.format(new Date()))) {
                                System.out.println("It's Time to Do! - " + todoTask.getName());
                            }
                        }
                    }
                    timerCount++;
                }
                else {
                    mTimer.cancel();
                }
            }
        };

        mTimer.schedule(mTask,5000, 3000); // Check reminders alarm time for every 3 second.
    }

    public TodoList makeList() {
        TodoList todoList = new TodoList();
        todoLists.add(todoList);
        return todoList;
    }
    public TodoList makeList(String name) {
        TodoList todoList = new TodoList(name);
        todoLists.add(todoList);
        return todoList;
    }
    public TodoList makeList(String name, TodoList.Sort sort) {
        TodoList todoList = new TodoList(name, sort);
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

    public TodoList getTodoList(String name) {
        for (TodoList todoList : todoLists) {
            if (todoList.getName().equals(name)) {
                return todoList;
            }
        }
        return null;
    }

    public Object[] getTodoTask(String name) {
        Object[] listTask = new Object[2];
        for (TodoList todoList : todoLists) {
            for (TodoTask todoTask : todoList.getTodoTasks()) {
                if (name.equals(todoTask.getName())) {
                    listTask[0] = todoList;
                    listTask[1] = todoTask;
                    return listTask;
                }
            }
        }
        return null;
    }

    public TodoTheme getTodoTheme() {
        return todoTheme;
    }

    public void setTodoTheme(TodoTheme todoTheme) {
        this.todoTheme = todoTheme;
    }
}
