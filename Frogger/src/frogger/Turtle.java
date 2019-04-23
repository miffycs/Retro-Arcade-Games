package frogger;

import frogger.enums.Obstacle;

public class Turtle extends Actor {

    private final Obstacle OBS;
    private final int SPEED;
    private boolean isSunk = false;

    public Turtle(Obstacle obs, int x, int y, int speed) {
        this.OBS = obs;
        setImage(obs.img(2));
        setX(x);
        setY(y);
        this.SPEED = speed;
    }
    
    public boolean isSunk() {
        return this.isSunk;
    }
    
    @Override
    public void act(long now) {
        
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
        } else {
            if (now / 900000000 % 3 == 0) {
                setImage(OBS.img(2));
            } else if (now / 900000000 % 3 == 1) {
                setImage(OBS.img(1));
            } else if (now / 900000000 % 3 == 2) {
                setImage(OBS.img(3));
            }
        }

        move(SPEED, 0);
        if (getX() > 600 && SPEED > 0) {
            setX(-200);
        }
        if (getX() < -75 && SPEED < 0) {
            setX(600);
        }
    }
    
}
