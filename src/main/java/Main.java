package main.java;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world");
        String str1 = "";
        for(String str : list){
            str1 += str;
        }
        System.out.println(str1.toString());
    }
}
