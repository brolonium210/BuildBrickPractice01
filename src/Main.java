import java.awt.*;
import java.util.ArrayList;
import ecs100.*;
import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //*********Linked List Practice************************
        int Challsize = 30;
        Challenges challenges = new Challenges(Challsize);
        LinkedList<Block> testList01 = challenges.makeBlocks();

        Grid grid01 = new Grid(testList01,Challsize);
        GridAction gridaction = new GridAction(grid01,challenges);
        gridaction.setupGUI();
        grid01.printGrid(challenges);

//        Boolean[] score = challenges.testScore(testList01);
//        System.out.println(score[0]);
//        System.out.println(score[1]);
//        System.out.println(score[2]);
//        System.out.println(score[3]);
    }


}