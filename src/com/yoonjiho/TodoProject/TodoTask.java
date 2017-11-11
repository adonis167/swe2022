package com.yoonjiho.TodoProject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoTask {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static int index = 0;

    private int num;
    private String name;
    private String dueDate;
    private boolean done = false;

    public TodoTask() {
        this("untitled task", dateFormat.format(new Date()));
    }

    public TodoTask(String name, String dueDate) {
        this.num = index++;
        this.name = name;
        this.dueDate = dueDate;
        //this.dueDate = dateFormat.format(dueDate);
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.num).append(" : ");
        sb.append(this.name).append(" : ");
        sb.append(this.dueDate).append(" : ");
        sb.append(this.done);
        return sb.toString();
    }
}
