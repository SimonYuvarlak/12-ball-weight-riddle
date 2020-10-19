package com.company;

public class SolveProblem {
    BallMain balls = new BallMain(); // Created 12 balls with one different (one of them is either light or heavy)
    Ball[] ballsArray = balls.generateArray(); //Got the generated array with 12 balls one being different

    //This method splits the 12 ball into 3 arrays with each having 4 balls
    private Ball[][] splitToThree(){
        Ball[][] threeBalls = new Ball[3][4]; //We have an empty two dimensional array. 3 arrays including 4 different balls
        //First part of the three parts
        for (int i = 0; i < 4; i++) {
            threeBalls[0][i] = ballsArray[i];
        }
        //Second part of the three parts
        for (int i = 4; i < 8; i++) {
            threeBalls[1][i-4] = ballsArray[i];
        }
        //Third part of the three parts
        for (int i = 8; i < 12; i++) {
            threeBalls[2][i-8] = ballsArray[i];
        }
        return threeBalls;
    }

    //This method weights two array and return 1 if the left side is heavier, 0 if both sides are equal and 2 if the right side is heavier
    private int weightBalls(Ball[] leftArray, Ball[] rightArray, int length){
        int leftWeight = 0; // Weight of the left side
        int rightWeight = 0; // Weight of the right side

        //Calculating the weight of the left side
        for (int i = 0; i < length; i++){
            leftWeight += leftArray[i].getWeight();
        }
        //Calculating the weight of the right side
        for (int i = 0; i < length; i++){
            rightWeight += rightArray[i].getWeight();
        }

        if (leftWeight > rightWeight) {
            return 1;
        } else if (leftWeight == rightWeight) {
            return 0;
        } else {
            return 2;
        }
    }

    private void printPossibility1(){
        System.out.println("I have calculated the result.");
        System.out.println("I looked for the weights of the first 8 ball and they were equal.");
        System.out.println("oooo    xxxx");
        System.out.println("------------------------");
        System.out.println();
    }

    private void printPossibility2(){
        System.out.println("I have calculated the result.");
        System.out.println("I looked for the weights of the first 8 ball and left side was heavier than the right side.");
        System.out.println("       xxxx");
        System.out.println("oooo");
        System.out.println("------------------------");
        System.out.println();
        System.out.println("I put 5,6,1 on the left side and 7,2,12 to the right side. -> xxo    xoq");
    }

    private void printPossibility3(){
        System.out.println("I have calculated the result.");
        System.out.println("I looked for the weights of the first 8 ball and right side was heavier than the left side.");
        System.out.println("oooo");
        System.out.println("       xxxx");
        System.out.println("------------------------");
        System.out.println();
        System.out.println("I put 1,2,5 on the left side and 3,6,12 to the right side.");
    }

    private void printPossibility1A() {
        printPossibility1();
        System.out.println("Then I looked for the weight of the first three balls which we know they are fine and looked for the three ball that we have not looked yet and they were equal.");
        System.out.println("ooo qqq");
        System.out.println("------------------------");
        System.out.println();
        System.out.println("That have us the result that the different ball was the one that we have not looked yet.");
        System.out.println("q");
    }

    private void printPossibility1B(){
        printPossibility1();
        System.out.println("Then I compared the three balls we know that are fine and the balls that we have not looked for yet and the right side were lighter. That shows us that the problem was on the right side and the ball was lighter.");
        System.out.println("       qqq");
        System.out.println("ooo");
        System.out.println("------------------------");
        System.out.println();
        System.out.println("Then I compared two balls that are possibly problematic.");
    }

    private void printPossibility1C(){
        printPossibility1();
        System.out.println("Then I compared the three balls we know that are fine and the balls that we have not looked for yet and the right side were heavier. That shows us that the problem was on the right side and the ball was heavier.");
        System.out.println("ooo");
        System.out.println("       qqq");
        System.out.println("------------------------");
        System.out.println();
        System.out.println("Then I compared two balls that are possibly problematic.");
    }

    private void possibility1A(Ball differentBall){
        printPossibility1A();
        System.out.println("The number of the ball : q-" + differentBall.getNumber());
    }

    private void possibility1B(Ball[] array) {
        //At this point we know we have light ball.
        //We weight the first two balls if they are equal than the answer is the other ball.
        if (array[0].getWeight() == array[1].getWeight()) {
            printPossibility1B();
            System.out.println("q    q");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("Since they were equal the lighter ball was the one we have not looked for yet.");
            System.out.println("The number of the ball : q-" + array[2].getNumber());
        } else if (array[0].getWeight() < array[1].getWeight()) {
            printPossibility1B();
            System.out.println("     q");
            System.out.println("q");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("They were not equal and the problematic the ball is the lighter one since we already knew that the different ball has to be the lighter one.");
            System.out.println("The number of the ball : q-" + array[0].getNumber());
        } else {
            printPossibility1B();
            System.out.println("q");
            System.out.println("     q");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("They were not equal and the problematic the ball is the lighter one since we already knew that the different ball has to be the lighter one.");
            System.out.println("The number of the ball : q-" + array[1].getNumber());
        }
    }

    private void possibility1C(Ball[] array) {
        //At this point we know we have heavy ball.
        //We weight the first two balls if they are equal than the answer is the other ball.
        if (array[0].getWeight() == array[1].getWeight()) {
            printPossibility1C();
            System.out.println("q    q");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("Since they were equal the heavier ball was the one we have not looked for yet.");
            System.out.println("The number of the ball : q-" + array[2].getNumber());
        } else if (array[0].getWeight() > array[1].getWeight()) {
            printPossibility1C();
            System.out.println("     q");
            System.out.println("q");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("They were not equal and the problematic the ball is the heavier one since we already knew that the different ball has to be the heavier one.");
            System.out.println("The number of the ball : q-" + array[0].getNumber());
        } else {
            printPossibility1C();
            System.out.println("q");
            System.out.println("     q");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("They were not equal and the problematic the ball is the heavier one since we already knew that the different ball has to be the heavier one.");
            System.out.println("The number of the ball : q-" + array[1].getNumber());
        }
    }

    //When we weight the first two arrays and they are equally heavy
    private void possibility1(Ball[] first, Ball[] second, Ball[] third){
        int result = weightBalls(first, third, 3); // We looked for the weight of the balls 1,2,3 and 9,10,11
        // If they are equal we go to possibility1A where the result is the 12th ball
        if (result == 0) {
            possibility1A(third[3]);
        } else if (result == 1){ // If left side is heavier
            possibility1B(third);
        } else {
            possibility1C(third);
        }
    }

    private void possibility2A(Ball[] first, Ball[] second){
        // Weigh 3 and 4
        System.out.println("Compared ball 3 and ball 4");
        if (first[2].getWeight() == first[3].getWeight()) {
            System.out.println("They were balanced.");
            System.out.println("o    o");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("So the odd ball is : x-" + second[3].getNumber());
        } else {
            if (first[2].getWeight() > first[3].getWeight()) {
                System.out.println("Ball 3 was heavier.");
                System.out.println("    o");
                System.out.println("o");
                System.out.println("------------------------");
                System.out.println();
                System.out.println("The odd heavy ball is : o-" + first[2].getNumber());
            } else {
                System.out.println("Ball 4 was heavier.");
                System.out.println("o");
                System.out.println("    o");
                System.out.println("------------------------");
                System.out.println();
                System.out.println("The odd heavy ball is : o-" + first[3].getNumber());
            }
        }
    }

    private void possibility2B(Ball[] first, Ball[] second){
        System.out.println("Compared 7 and 8 (instead of eight could have used any other ball than 7).");
        if (second[2].getWeight() == second[3].getWeight()) {
            System.out.println("They were balanced.");
            System.out.println("x     x");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("So the odd heavy ball is : o-" + first[0].getNumber());
        } else {
            System.out.println("7 was lighter.");
            System.out.println("x");
            System.out.println("     x");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("So, the odd light ball is : x-" + second[2].getNumber());
        }
    }

    private void possibility2C(Ball[] first, Ball[] second){
        System.out.println("Compared 5 and 6");
        if (second[0].getWeight() == second[1].getWeight()) {
            System.out.println("They were balanced.");
            System.out.println("x    x");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("So the odd heavy ball is :  o-" + first[1].getNumber());
        } else {
            if (second[0].getWeight() > second[1].getWeight()) {
                System.out.println("6 was lighter.");
                System.out.println("     x");
                System.out.println("x");
                System.out.println("------------------------");
                System.out.println();
                System.out.println("So the result is ball : x-" + second[1].getNumber());
            } else {
                System.out.println("5 was lighter.");
                System.out.println("x");
                System.out.println("     x");
                System.out.println("------------------------");
                System.out.println();
                System.out.println("So the result is ball : x-" + second[0].getNumber());
            }
        }
    }

    //When we weight the first array is heavier than the other
    private void possibility2(Ball[] first, Ball[] second, Ball[] third) {
        printPossibility2();
        Ball[] temp1 = {second[0], second[1], first[0]}; // Balls 5,6,1
        Ball[] temp2 = {second[2], first[1], third[3]}; //Balls 7,2,12
        int result = weightBalls(temp1, temp2, 3); // We looked for the weight of the balls 5,6,1 and 7,2,12
        if (result == 0){
            System.out.println("They were balanced.");
            System.out.println("xxo    xoq");
            System.out.println("------------------------");
            System.out.println();
            possibility2A(first, second);
        } else if (result == 1){
            System.out.println("Left side was heavier.");
            System.out.println("       xoq");
            System.out.println("xxo");
            System.out.println("------------------------");
            System.out.println();
            possibility2B(first, second);
        } else {
            System.out.println("Right side was heavier.");
            System.out.println("xoq");
            System.out.println("       xxo");
            System.out.println("------------------------");
            System.out.println();
            possibility2C(first, second);
        }
    }

    private void possibility3A(Ball[] first, Ball[] second){
        // Weigh 7 and 8
        System.out.println("Compared ball 7 and ball 8");
        if (second[2].getWeight() == second[3].getWeight()) {
            System.out.println("They were balanced.");
            System.out.println("x    x");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("So the odd ball is : o-" + first[3].getNumber());
        } else {
            if (second[2].getWeight() > second[3].getWeight()) {
                System.out.println("Ball 7 was heavier.");
                System.out.println("    x");
                System.out.println("x");
                System.out.println("------------------------");
                System.out.println();
                System.out.println("The odd heavy ball is : x-" + second[2].getNumber());
            } else {
                System.out.println("Ball 8 was heavier.");
                System.out.println("x");
                System.out.println("    x");
                System.out.println("------------------------");
                System.out.println();
                System.out.println("The odd heavy ball is : x-" + second[3].getNumber());
            }
        }
    }

    private void possibility3B(Ball[] first, Ball[] second){
        System.out.println("Compared 3 and 8 (instead of eight could have used any other ball than 7). -> o    x");
        if (first[2].getWeight() == second[3].getWeight()) {
            System.out.println("They were balanced.");
            System.out.println("o     x");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("So the odd heavy ball is : x-" + second[0].getNumber());
        } else {
            System.out.println("3 was lighter.");
            System.out.println("o");
            System.out.println("     x");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("So, the odd light ball is : o-" + first[2].getNumber());
        }
    }

    private void possibility3C(Ball[] first, Ball[] second){
        System.out.println("Compared 1 and 2");
        if (first[0].getWeight() == first[1].getWeight()) {
            System.out.println("They were balanced.");
            System.out.println("o    o");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("So the odd heavy ball is :  x-" + second[1].getNumber());
        } else {
            if (first[0].getWeight() > first[1].getWeight()) {
                System.out.println("2 was lighter.");
                System.out.println("     o");
                System.out.println("o");
                System.out.println("------------------------");
                System.out.println();
                System.out.println("So the result is ball : o-" + first[1].getNumber());
            } else {
                System.out.println("1 was lighter.");
                System.out.println("o");
                System.out.println("      o");
                System.out.println("------------------------");
                System.out.println();
                System.out.println("So the result is ball : o-" + first[0].getNumber());
            }
        }
    }

    private void possibility3(Ball[] first, Ball[] second, Ball[] third){
        printPossibility3();
        Ball[] temp1 = {first[0], first[1], second[0]}; // Balls 1,2,5
        Ball[] temp2 = {first[2], second[1], third[3]}; //Balls 3,6,12
        int result = weightBalls(temp1, temp2, 3); // We looked for the weight of the balls 1,2,5 and 3,6,12
        if (result == 0){
            System.out.println("They were balanced.");
            System.out.println("oox    oxq");
            System.out.println("------------------------");
            System.out.println();
            possibility3A(first, second);
        } else if (result == 1){
            System.out.println("Left side was heavier.");
            System.out.println("       oxq");
            System.out.println("oox");
            System.out.println("------------------------");
            System.out.println();
            possibility3B(first, second);
        } else {
            System.out.println("Right side was heavier.");
            System.out.println("oox");
            System.out.println("       oxq");
            System.out.println("------------------------");
            System.out.println();
            possibility3C(first, second);
        }
    }

    //Total solution function
    public void executeSolution(){
        Ball[][] multipleArrays = splitToThree(); // Now we are 3 different array with sizes of 4
        int result = weightBalls(multipleArrays[0], multipleArrays[1], 4); //Looking which side is heavier in the first two arrays
        //If they are equally heavy than we execute possibility1
        if (result == 0) {
            possibility1(multipleArrays[0], multipleArrays[1], multipleArrays[2]);
        } else if (result == 1){ // Left side is heavier than the right side
            possibility2(multipleArrays[0], multipleArrays[1], multipleArrays[2]);
        } else {
            //If left side is lighter than the right side
            possibility3(multipleArrays[0], multipleArrays[1], multipleArrays[2]);
        }
    }

    //This method returns the different ball
    public Ball getDifferentBall(){
        for (int i = 0; i < 12; i++) {
            if (ballsArray[i].getKind().equals("U") == false){
                return ballsArray[i];
            }
        }
        return null;
    }
}
