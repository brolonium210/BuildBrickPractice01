import java.awt.*;
import java.util.ArrayList;
import ecs100.*;
import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //*********Linked List Practice************************
        Block block01 = new Block(0,0,0, Color.red);
        Block block02 = new Block(1,0,1, Color.blue);
        Block block03 = new Block(2,1,0, Color.green);
        Block block04 = new Block(3,1,1, Color.blue);
        Block block05 = new Block(4,0,0, Color.green);
        Block block06 = new Block(5,0,0, Color.red);
        Block block07 = new Block(6,0,0, Color.green);
        Block block08 = new Block(7,0,0, Color.red);
        Block block09 = new Block(8,0,0, Color.blue);

        LinkedList<Block> testList01 = new LinkedList<>();
        testList01.add(block01);
        testList01.add(block02);
        testList01.add(block03);
        testList01.add(block04);
        testList01.add(block05);
        testList01.add(block06);
        testList01.add(block07);
        testList01.add(block08);
        testList01.add(block09);

        Grid grid01 = new Grid(testList01);
        GridAction gridaction = new GridAction(grid01);
        gridaction.setupGUI();
        grid01.printGrid();

    }


}