package Lesson8;

import java.util.ArrayList;

public class List {
    static private ArrayList<String> names = new ArrayList<String>();

    private String name;
    public List(String name) throws Exception {
        if(names.contains(name)) throw new Exception();
        this.name = name;
        names.add(this.name);
    }

    public void setName(String name) throws Exception {
        if(name == this.name) return;
        if(names.contains(name)) throw new Exception();
        names.remove(this.name);
        this.name = name;
        names.add(this.name);
    }
}
