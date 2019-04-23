package frogger;

import frogger.enums.Obstacle;

public class Car extends Actor {
    
    private final Obstacle obs;
    private int speed;

    @Override
    public void act(long now) {
        move(speed, 0);
        if (getX() > 600 && speed > 0) {
            setX(-200);
        }
        if (getX() < -50 && speed < 0) {
            setX(600);
        }
    }

    public Car(Obstacle obs, int x, int y, int speed) {
        this.obs = obs;
        setImage(obs.img());
        setX(x);
        setY(y);
        this.speed = speed;
    }
    
}
