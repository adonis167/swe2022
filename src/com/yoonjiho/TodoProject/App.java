package com.yoonjiho.TodoProject;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class App {
    public static final String fileName = "./src/com/yoonjiho/TodoProject/data.txt";
    private TodoTheme todoTheme = new TodoTheme();
    private ArrayList<TodoList> todoLists = new ArrayList<>();
    public Timer mTimer = new Timer();
    public int timerCount;

    public void fileExistanceTest() {
        File f = new File(fileName);
        if (!f.exists()) {
            try {
                FileWriter fw = new FileWriter(f, false) ;
                fw.write("");
                fw.flush();
                fw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readData() throws ParseException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String listData = "";
            String taskData = "";

            while ((listData = reader.readLine()) != null) {
                //System.out.println(data);
                String newList[] = listData.split(",");
                TodoList list = makeList(newList[0], TodoList.Sort.valueOf(newList[1]));
                if (newList[3].equals("true")) list.setDoneTaskOnOff(true);
                for (int i=0; i < Integer.parseInt(newList[2]); i++) {
                    taskData = reader.readLine();
                    String newTask[] = taskData.split(",");
                    if (newTask[3].equals("null")) {
                        TodoTask task = list.addTask(newTask[1], TodoTask.dueDateFormat.parse(newTask[2]), null);
                        if (newTask[4].equals("true")) task.setDone(true);
                    }
                    else {
                        TodoTask task = list.addTask(newTask[1], TodoTask.dueDateFormat.parse(newTask[2]), TodoTask.reminderDateFormat.parse(newTask[3]));
                        if (newTask[4].equals("true")) task.setDone(true);
                    }
                }
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData() {

        String txt;

        String listName;
        String listSort;
        int nTodo;
        String doneTaskOnOff;

        int todoNum;
        String todoName;
        String dueDate;
        String reminder;
        String done;
        String isAlarm;

        try {

            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, false));

            for (TodoList todoList : todoLists) {

                listName = todoList.getName();
                listSort = todoList.getSorting().toString();
                nTodo = todoList.getTodoTasks().size();
                doneTaskOnOff = todoList.isDoneTaskOnOff() ? "true" : "false";
                txt = listName + "," + listSort + "," + nTodo + "," + doneTaskOnOff + "\n";

                fw.write(txt);

                for(TodoTask todoTask : todoList.getTodoTasks()) {
                    todoNum = todoTask.getNum();
                    todoName = todoTask.getName();
                    dueDate = TodoTask.dueDateFormat.format(todoTask.getDueDate());
                    if (todoTask.isAlarm()) reminder = TodoTask.reminderDateFormat.format(todoTask.getReminder());
                    else reminder = "null";
                    done = todoTask.isDone() ? "true" : "false";
                    isAlarm = todoTask.isAlarm() ? "true" : "false";
                    txt = todoNum + "," + todoName + "," + dueDate + "," + reminder + "," + done + "," + isAlarm + "\n";

                    fw.write(txt);
                }
            }

            fw.flush();
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public App() throws ParseException {

        fileExistanceTest();
        readData();


        /**
         *  Set the Timer to check time of the reminders alarm for every N second.
         *  For the test, I set the maximum checking count number is 20.
         */

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
