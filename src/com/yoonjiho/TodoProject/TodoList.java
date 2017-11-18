package com.yoonjiho.TodoProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class TodoList {
    public enum Sort { BY_ADD_ORDER, BY_NAME_ASC, BY_NAME_DESC, BY_DATE_ASC, BY_DATE_DESC };

    private String name;
    private Sort sort;
    private TodoTheme theme;
    private ArrayList<TodoTask> todoTasks = new ArrayList<TodoTask>();
    private boolean doneTaskOnOff = false;

    public TodoList(TodoTheme theme) {
        this("untitled list", Sort.BY_ADD_ORDER, theme);
    }

    public TodoList(String name, Sort sort, TodoTheme theme) {
        this.name = name;
        this.sort = sort;
        this.theme = theme;
    }

    public ArrayList<TodoTask> getTodoTasks() {
        return todoTasks;
    }

    public void setTodoTasks(ArrayList<TodoTask> todoTasks) {
        this.todoTasks = todoTasks;
    }

    public TodoTask addTask() {
        TodoTask todoTask = new TodoTask();
        todoTasks.add(todoTask);
        return todoTask;
    }

    public TodoTask addTask(String name, Date dueDate, Date remainder) {
        TodoTask todoTask = new TodoTask(name, dueDate, remainder);
        todoTasks.add(todoTask);
        return todoTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sort getSorting() {
        return sort;
    }

    public void setSorting(Sort sort) {
        this.sort = sort;
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
        switch (sort) {
            case BY_ADD_ORDER:
                Collections.sort(todoTasks, new Comparator<TodoTask>() {
                    @Override
                    public int compare(TodoTask o1, TodoTask o2) {
                        return o1.getNum() - o2.getNum();
                    }
                });
                break;
            case BY_NAME_ASC:
                Collections.sort(todoTasks, new Comparator<TodoTask>() {
                    @Override
                    public int compare(TodoTask o1, TodoTask o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                break;
            case BY_NAME_DESC:
                Collections.sort(todoTasks, new Comparator<TodoTask>() {
                    @Override
                    public int compare(TodoTask o1, TodoTask o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                Collections.reverse(todoTasks);
                break;
            case BY_DATE_ASC:
                Collections.sort(todoTasks, new Comparator<TodoTask>() {
                    @Override
                    public int compare(TodoTask o1, TodoTask o2) {
                        return o1.getDueDate().compareTo(o2.getDueDate());
                    }
                });
                break;
            case BY_DATE_DESC:
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
        if (todoTasks.isEmpty()) {
            System.out.println("Empty List. Please add a task.\n");
            return;
        }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" : ");
        sb.append(this.sort).append(" : ");
        sb.append(this.theme);
        return sb.toString();
    }
}
