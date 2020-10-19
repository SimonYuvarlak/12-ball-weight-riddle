package com.company;

import java.util.Random;

public class BallMain {
    private int number = 1; //Ball numbers
    private String[] ballKinds = {"L", "H"}; // Different possible ball types

    public int getNumber() {
        return number;
    }

    public String[] getBallKinds() {
        return ballKinds;
    }

    //This method creates a new ball
    public Ball createBall(String kind) {
        Ball newBall;
        if (kind.equals("U")) {
            return new Ball(this.number++, 1, kind);
        } else if (kind.equals("L")) {
            return new Ball(this.number++, 0, kind);
        } else {
            return new Ball(this.number++, 2, kind);
        }
    }

    //This method generates a random number between 0 and the given parameter
    public static int generateRandomNumber(int number){
        Random rn = new Random();
        return rn.nextInt(number);
    }

    //This method fill the empty Balls array with random balls
    public Ball[] generateArray() {
        Ball[] balls = new Ball[12]; //Array for 12 balls
        for (int i = 0; i < 12; i++){
            balls[i] = createBall("U");
        } //12 balls are generated with kind "unkown"
        String differentBallKind = ballKinds[generateRandomNumber(2)]; //Got a random different ball kind, either "L" or "H"
        int differentBallIndex = generateRandomNumber(12); //Got a random index for the different ball
        balls[differentBallIndex].setKind(differentBallKind); //Changed the kind of the different ball
        //Changing weight of the different kind of the ball
        if (differentBallKind == "H") balls[differentBallIndex].setWeight(2);
        else balls[differentBallIndex].setWeight(0);
        return balls;
    }
}
