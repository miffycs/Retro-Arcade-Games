package frogger;

import frogger.enums.Obstacle;

public class Log extends Actor {
    
    /* 
     * Possible (enum)Obstacle types:
     * {LOG_SHORT, LOG_MED, LOG_LONG}
     */
    private final Obstacle OBS;
    private final double SPEED;

    // constructor that takes data from Obstacle type and parameters
    public Log(Obstacle obs, int x, int y, double speed) {
        this.OBS = obs;
        setImage(obs.img());
        setX(x);
        setY(y);
        this.SPEED = speed;
    }
    
    // returns if Log is goind left,
    // called in Frog when Frog is at the edge of the application,
    // if true, then move Frog position towards the center of the app
    public boolean isDirectionLeft() {
        return this.SPEED < 0;
    }
    
    // action for each second passed
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
