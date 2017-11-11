package com.yoonjiho.TodoProject;

import java.awt.*;

public class TodoTheme {
    private Color headerColor;
    private Image backgroundImg;

    public TodoTheme() {
        this(Color.white, null);
    }

    public TodoTheme(Color headerColor, Image backgroundImg) {
        this.headerColor = headerColor;
        this.backgroundImg = backgroundImg;
    }
}
