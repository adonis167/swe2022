package com.yoonjiho.TodoProject;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class TodoTheme implements Serializable {
    private static ArrayList<TodoTheme> themeList = new ArrayList<>();
    private String name;
    private Color headerColor;
    private Image backgroundImg;

    public TodoTheme() {
        this("untitled theme", Color.white, null);
    }

    public TodoTheme(Color headerColor, Image backgroundImg) {
        this("untitled theme", headerColor, backgroundImg);
    }

    public TodoTheme(String name, Color headerColor, Image backgroundImg) {
        this.name = name;
        this.headerColor = headerColor;
        this.backgroundImg = backgroundImg;
        themeList.add(this);
    }

    public static ArrayList<TodoTheme> getThemeList() {
        return themeList;
    }

    @Override
    public String toString() {
        return name;
//                return "TodoTheme{" +
//                "name = '" + name + '\'' +
//                ", headerColor = " + headerColor +
//                ", backgroundImg = " + backgroundImg +
//                '}';
    }
}
