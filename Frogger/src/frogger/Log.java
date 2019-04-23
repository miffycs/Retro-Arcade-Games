package frogger;

import frogger.enums.Obstacle;

public class Log extends Actor {
    
    private final Obstacle OBS;
    private final double SPEED;

    public Log(Obstacle obs, int x, int y, double speed) {
        this.OBS = obs;
        setImage(obs.img());
        setX(x);
        setY(y);
        this.SPEED = speed;
    }
    
    public boolean isDirectionLeft() {
        return this.SPEED < 0;
    }
    
    @Override
    public void act(long now) {
        move(SPEED, 0);
        if (getX() > 600 && SPEED > 0) {
            setX(-180);
        }
        if (getX() < -300 && SPEED < 0) {
            setX(700);
        }
    }
    
}
