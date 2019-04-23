package frogger;

import frogger.enums.Obstacle;

public class Log extends Actor {
    
    private final Obstacle obs;
    private double speed;

    @Override
    public void act(long now) {
        move(speed, 0);
        if (getX() > 600 && speed > 0) {
            setX(-180);
        }
        if (getX() < -300 && speed < 0) {
            setX(700);
        }
    }
    
    public Log(Obstacle obs, int x, int y, double speed) {
        this.obs = obs;
        setImage(obs.img());
        setX(x);
        setY(y);
        this.speed = speed;
    }

    public boolean isDirectionLeft() {
        return this.speed < 0;
    }
}
