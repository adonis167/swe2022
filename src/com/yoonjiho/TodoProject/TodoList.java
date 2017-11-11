package com.yoonjiho.TodoProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TodoList {
    public static final int BY_ADD_ORDER = 0;
    public static final int BY_NAME_ASC = 1;
    public static final int BY_NAME_DESC = 2;
    public static final int BY_DATE_ASC = 3;
    public static final int BY_DATE_DESC = 4;

    private String name;
    private int sorting;
    private TodoTheme theme;
    private ArrayList<TodoTask> todoTasks = new ArrayList<TodoTask>();
    private boolean doneTaskOnOff = false;

    public TodoList(TodoTheme theme) {
        this("untitled list", BY_ADD_ORDER, theme);
    }

    public TodoList(String name, int sorting, TodoTheme theme) {
        this.name = name;
        this.sorting = sorting;
        this.theme = theme;
    }

    public ArrayList<TodoTask> getTodoTasks() {
        return todoTasks;
    }

    public void setTodoTasks(ArrayList<TodoTask> todoTasks) {
        this.todoTasks = todoTasks;
        //sortTasks();
    }

    public void addTask() {
        todoTasks.add(new TodoTask());
        //sortTasks();
    }

    public void addTask(String name, String dueDate) {
        todoTasks.add(new TodoTask(name, dueDate));
        //sortTasks();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
        //sortTasks();
    }

    public TodoTheme getTheme() {
        return theme;
    }

    public void setTheme(TodoTheme theme) {
        this.theme = theme;
    }

    public boolean isDoneTaskOnOff() {
        return doneTaskOnOff;
    }

    public void setDoneTaskOnOff(boolean doneTaskOnOff) {
        this.doneTaskOnOff = doneTaskOnOff;
    }

    private void sortTasks() {
        switch (sorting) {
            case 0:
                Collections.sort(todoTasks, new Comparator<TodoTask>() {
                    @Override
                    public int compare(TodoTask o1, TodoTask o2) {
                        return o1.getNum() - o2.getNum();
                    }
                });
                break;
            case 1:
                Collections.sort(todoTasks, new Comparator<TodoTask>() {
                    @Override
                    public int compare(TodoTask o1, TodoTask o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                break;
            case 2:
                Collections.sort(todoTasks, new Comparator<TodoTask>() {
                    @Override
                    public int compare(TodoTask o1, TodoTask o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                Collections.reverse(todoTasks);
                break;
            case 3:
                Collections.sort(todoTasks, new Comparator<TodoTask>() {
                    @Override
                    public int compare(TodoTask o1, TodoTask o2) {
                        return o1.getDueDate().compareTo(o2.getDueDate());
                    }
                });
                break;
            case 4:
                Collections.sort(todoTasks, new Comparator<TodoTask>() {
                    @Override
                    public int compare(TodoTask o1, TodoTask o2) {
                        return o1.getDueDate().compareTo(o2.getDueDate());
                    }
                });
                Collections.reverse(todoTasks);
                break;
        }
    }

    public void displayTasks() {
        sortTasks();
        if (!doneTaskOnOff) {
            for (TodoTask task : todoTasks) {
                System.out.println(task);
            }
        }
        else {
            for (TodoTask task : todoTasks) {
                if (!task.isDone()) System.out.println(task);
            }
        }
        System.out.println();
    }
}
