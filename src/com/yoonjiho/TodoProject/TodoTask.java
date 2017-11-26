package com.yoonjiho.TodoProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TodoTask {
    public static SimpleDateFormat dueDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat reminderDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static Calendar cal = Calendar.getInstance();

    public enum enumDueDate { TODAY, TOMORROW, NEXTWEEK, SELECT_DATE };
    public enum enumReminder { LATER_TODAY, TOMORROW, NEXTWEEK, SELECT_TIME };

    private static int index = 0;

    private int num;
    private String name;
    private Date dueDate;
    private Date reminder;
    private boolean done = false;
    private boolean isAlarm = false;

    public boolean isAlarm() {
        return isAlarm;
    }

    public void setAlarm(boolean alarm) {
        isAlarm = alarm;
    }

    public TodoTask() {
        this("untitled task", new Date(), null);
    }

    public TodoTask(String name, Date dueDate, Date reminder) {
        this.num = index++;
        this.name = name;
        this.dueDate = dueDate;
        this.reminder = reminder;
        if (this.reminder != null) isAlarm = true;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(enumDueDate dd) {
        switch (dd) {
            case TODAY:
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
                break;
            case TOMORROW:
                cal.add(Calendar.DATE, 1);
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
                break;
            case NEXTWEEK:
                cal.add(Calendar.DATE, 7);
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
                break;
            default:
                break;
        }
        this.dueDate = new Date(cal.getTimeInMillis());
    }

    public void setDueDate(enumDueDate dd, Date dueDate) {
        if (dd.equals(enumDueDate.SELECT_DATE)) this.dueDate = dueDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getReminder() {
        return reminder;
    }

    public void setReminder(enumReminder r) {
        switch (r) {
            case LATER_TODAY:
                if (cal.get(Calendar.HOUR_OF_DAY) <= 18) cal.add(Calendar.HOUR_OF_DAY, 5);
                else return;
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                break;
            case TOMORROW:
                cal.add(Calendar.DATE, 1);
                cal.set(Calendar.HOUR_OF_DAY, 9);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                break;
            case NEXTWEEK:
                cal.add(Calendar.DATE, 7);
                cal.set(Calendar.HOUR_OF_DAY, 9);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                break;
            default:
                break;
        }
        this.reminder = new Date(cal.getTimeInMillis());
        isAlarm = true;
    }

    public void setReminder(enumReminder r, Date reminder) {
        if (r.equals(enumReminder.SELECT_TIME)) this.reminder = reminder;
        if (this.reminder != null) isAlarm = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isDone()) sb.append("- [O] ");
        else sb.append("[-] ");
        sb.append(this.name).append(" ");
        sb.append(this.dueDateFormat.format(dueDate)).append(" ");
        if (isAlarm) sb.append("알림");
        return sb.toString();
    }
}
