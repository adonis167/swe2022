package Lesson1;

import java.util.ArrayList;
import java.util.List;

public class Array {
    static public void main(String[] a){
        String[] names = new String[100];
        String[] member = {"m1", "m2"};
        String[] test = new String[]{"m1", "m2"};
        for(String i : test){
            System.out.println(i);
        }
        List<String> friends = new ArrayList<>();
        friends.add("m1");
        friends.add("m2");
        for(String i : friends){
            System.out.println(i);
        }
    }
}