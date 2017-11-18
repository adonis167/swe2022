package com.yoonjiho.TodoProject;

import java.awt.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static int timerCount;

    public static void main(String args[]) throws ParseException {

        App app = new App();
        app.displayLists();

        TodoList todoList01 = app.makeList();
        app.displayLists();

        todoList01.setName("JAVA Assignments"); //Rename
        todoList01.displayTasks();

        TodoTask todoTask01 = todoList01.addTask("To Make an App Class", TodoTask.dueDateFormat.parse("2017-01-01"), null);
        todoList01.displayTasks();


        TodoTask todoTask02 = todoList01.addTask("To Read a textbook.", TodoTask.dueDateFormat.parse("2017-04-01"), null);
        TodoTask todoTask03 = todoList01.addTask("To Build up my github repository.", TodoTask.dueDateFormat.parse("2017-03-01"), null);
        TodoTask todoTask04 = todoList01.addTask("Make a connection with classmates to study with.", TodoTask.dueDateFormat.parse("2017-02-01"), null);
        todoList01.displayTasks();


        /**
         *  Test for setSorting
         */
        todoList01.setSorting(TodoList.Sort.BY_NAME_ASC); //Change Sort Option
        todoList01.displayTasks();

        TodoTask todoTask05 = todoList01.addTask("To Memorize entire contents of the text book.", TodoTask.dueDateFormat.parse("2017-06-01"), null);
        TodoTask todoTask06 = todoList01.addTask("To prepare a final exam.", TodoTask.dueDateFormat.parse("2017-07-01"), null);
        TodoTask todoTask07 = todoList01.addTask("To type codes and think a lot as much as possible.", TodoTask.dueDateFormat.parse("2017-09-01"), null);
        todoList01.displayTasks();


        /**
         *  Test for setDone
         */
        todoList01.getTodoTasks().get(0).setDone(true);
        todoList01.getTodoTasks().get(3).setDone(true);
        todoList01.getTodoTasks().get(4).setDone(true);
        todoList01.getTodoTasks().get(6).setDone(true);
        todoList01.displayTasks();


        /**
         *  Test for setDueDate
         */
        todoTask01.setDueDate(TodoTask.enumDueDate.TODAY);
        todoList01.displayTasks();

        todoTask02.setDueDate(TodoTask.enumDueDate.TOMORROW);
        todoList01.displayTasks();

        todoTask03.setDueDate(TodoTask.enumDueDate.NEXTWEEK);
        todoList01.displayTasks();

        todoTask04.setDueDate(TodoTask.enumDueDate.SELECT_DATE, TodoTask.dueDateFormat.parse("2017-03-22"));
        todoList01.displayTasks();


        /**
         *  Test for setRemainder
         */
        todoTask03.setReminder(TodoTask.enumReminder.LATER_TODAY);
        todoList01.displayTasks();

        todoTask04.setReminder(TodoTask.enumReminder.TOMORROW);
        todoList01.displayTasks();

        todoTask05.setReminder(TodoTask.enumReminder.NEXTWEEK);
        todoList01.displayTasks();

        todoTask06.setReminder(TodoTask.enumReminder.SELECT_TIME, TodoTask.reminderDateFormat.parse("2017-11-18 17:31"));
        //todoTask06.setAlarm(false);
        todoList01.displayTasks();


        /**
         *  Test for setTheme
         */
        todoList01.setTheme(new TodoTheme(Color.BLUE, null)); //Change TodoTheme
        todoList01.displayTasks();


        /**
         *  Test for setDoneTaskOnOff
         */
        todoList01.setDoneTaskOnOff(true); //Hide Done Tasks;
        todoList01.displayTasks();


        /**
         *  Test for deleteList
         */
        //app.deleteList(todoList01); //Delete TodoList
        //app.displayLists();


        /**
         *  Set the Timer to check time of the reminders alarm for every N second.
         *  For the test, I set the maximum checking count number is 20.
         */
        Timer mTimer = new Timer();
        TimerTask mTask = new TimerTask() {
            @Override
            public void run() {
                if (timerCount <= 20) { // <- This is the maximum chk count.
                    System.out.println(timerCount + ") ############## Reminder Time Checking ( "+ TodoTask.reminderDateFormat.format(new Date()) + ") ##############");
                    for (TodoList todoList : app.getTodoLists()) {
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
}
