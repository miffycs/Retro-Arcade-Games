package frogger;

import frogger.enums.Obstacle;

public class Car extends Actor {
    
    private final Obstacle OBS;
    private final int SPEED;

    public Car(Obstacle obs, int x, int y, int speed) {
        this.OBS = obs;
        setImage(obs.img());
        setX(x);
        setY(y);
        this.SPEED = speed;
    }
    
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
