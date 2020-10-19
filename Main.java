package com.company;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        System.out.println("Our balls are:");
        System.out.println("o o o o x x x x q q  q  q");
        System.out.println("1 2 3 4 5 6 7 8 9 10 11 12");
        System.out.println("###########################");
        SolveProblem problem = new SolveProblem();
        problem.executeSolution();
        System.out.println("The chosen ball was : " + problem.getDifferentBall().getNumber());
    }
}
