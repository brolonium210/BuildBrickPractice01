import java.util.ArrayList;
import ecs100.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // runtime instance associated with
        // the current Java application
//        Runtime runtime = Runtime.getRuntime();
//
//        // Enable instruction tracing
//        runtime.traceInstructions(true);

        ArrayList<String> list1;
        String[] arr1 = {"a", "b", "c", "d", "e", "f", "g", "h"};
        ListsAndStuff listsAndStuff = new ListsAndStuff();
        list1 = listsAndStuff.makeBasicLi(arr1);
        System.out.println(list1.size());



        listsAndStuff.setupGUI();

    }


}