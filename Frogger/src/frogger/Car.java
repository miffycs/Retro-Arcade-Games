package frogger;

import frogger.enums.Obstacle;

public class Car extends Actor {
    
    /* 
     * Possible (enum)Obstacle types:
     * {CAR_LEFT, CAR_RIGHT,
     *  TRUCK_LEFT, TRUCK_RIGHT,
     *  TRUCK_LONG_LEFT, TRUCK_LONG_RIGHT}
     */
    private final Obstacle OBS;
    private final int SPEED;

    // constructor that takes data from Obstacle type and parameters
    public Car(Obstacle obs, int x, int y, int speed) {
        this.OBS = obs;
        setImage(obs.img());
        setX(x);
        setY(y);
        this.SPEED = speed;
    }
    
    // action for each second passed
    @Override
    public void act(long now) {
        move(SPEED, 0);
        if (getX() > 600 && SPEED > 0) {
            setX(-200);
        }
        if (getX() < -50 && SPEED < 0) {
            setX(600);
        }
    }

}
