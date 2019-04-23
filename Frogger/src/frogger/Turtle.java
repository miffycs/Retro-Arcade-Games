package frogger;

import frogger.enums.Obstacle;

public class Turtle extends Actor {

    /* 
     * Possible (enum)Obstacle types:
     * {TURTLE, TURTLE_SINKS}
     */
    private final Obstacle OBS;
    private final int SPEED;
    // turns true for TURTLE_SINKS in animation frame 4, but not 1-3
    private boolean isSunk = false;

    // constructor that takes data from Obstacle type and parameters
    public Turtle(Obstacle obs, int x, int y, int speed) {
        this.OBS = obs;
        setImage(obs.img(2));
        setX(x);
        setY(y);
        this.SPEED = speed;
    }
    
    // returns if TURTLE_SINK is in the animation frame
    // of sinking in this current second
    public boolean isSunk() {
        return this.isSunk;
    }
    
    // action for each second passed
    @Override
    public void act(long now) {
        // for TURTLEs that sinks down in animation frame 4
        if (OBS == Obstacle.TURTLE_SINKS) {
            if (now / 900000000 % 4 == 0) {
                setImage(OBS.img(2));
                isSunk = false;
            } else if (now / 900000000 % 4 == 1) {
                setImage(OBS.img(1));
                isSunk = false;
            } else if (now / 900000000 % 4 == 2) {
                setImage(OBS.img(3));
                isSunk = false;
            } else if (now / 900000000 % 4 == 3) {
                setImage(OBS.img(4));
                isSunk = true;
            }
        // for TURTLEs that don't sink at all
        } else {
            if (now / 900000000 % 3 == 0) {
                setImage(OBS.img(2));
            } else if (now / 900000000 % 3 == 1) {
                setImage(OBS.img(1));
            } else if (now / 900000000 % 3 == 2) {
                setImage(OBS.img(3));
            }
        }
        // moving for both Turtle types are the same
        move(SPEED, 0);
        if (getX() > 600 && SPEED > 0) {
            setX(-200);
        }
        if (getX() < -75 && SPEED < 0) {
            setX(600);
        }
    }
    
}
