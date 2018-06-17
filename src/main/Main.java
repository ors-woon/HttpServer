package main;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world");
        String str = "";
        for(String arg  : list){
            str += arg;
        }
        System.out.println(str.toString()); // detect sonarCloud
    }
}
