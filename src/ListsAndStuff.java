import ecs100.UI;

import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ListsAndStuff {

//    private String name;
//    private String id;
//    private Integer age;

    public ListsAndStuff(){

    }

    ArrayList<String> makeBasicLi(String[] arr){
        //def return to this
        return new ArrayList<>(Arrays.asList(arr));
    }

    boolean isRunning = false;
    String buttonLabel = "start";

    void setupGUI(){
        UI.addButton(buttonLabel, this::startOrStop);
        UI.setMouseListener(this::doMouse);
    }
    void startOrStop(){
        if (isRunning) {
            buttonLabel = "start";
        } else {
            buttonLabel = "stop";
        }
        isRunning = !isRunning;
    }

    void doMouse(String action,double x, double y){
        System.out.println("mouse: " + x + ", " + y);
    }
}
