package frogger;

import frogger.enums.Obstacle;

public class Turtle extends Actor {

    private final Obstacle obs;
    private int speed;
    private boolean isSunk = false;

    @Override
    public void act(long now) {
        
        if (obs == Obstacle.TURTLE_SINKS) {
            if (now / 900000000 % 4 == 0) {
                setImage(obs.img(2));
                isSunk = false;
            } else if (now / 900000000 % 4 == 1) {
                setImage(obs.img(1));
                isSunk = false;
            } else if (now / 900000000 % 4 == 2) {
                setImage(obs.img(3));
                isSunk = false;
            } else if (now / 900000000 % 4 == 3) {
                setImage(obs.img(4));
                isSunk = true;
            }
        } else {
            if (now / 900000000 % 3 == 0) {
                setImage(obs.img(2));
            } else if (now / 900000000 % 3 == 1) {
                setImage(obs.img(1));
            } else if (now / 900000000 % 3 == 2) {
                setImage(obs.img(3));
            }
        }

        move(speed, 0);
        if (getX() > 600 && speed > 0) {
            setX(-200);
        }
        if (getX() < -75 && speed < 0) {
            setX(600);
        }
    }
    
    public Turtle(Obstacle obs, int x, int y, int speed) {
        this.obs = obs;
        setImage(obs.img(2));
        setX(x);
        setY(y);
        this.speed = speed;
    }
    
    public boolean isSunk() {
        return this.isSunk;
    }
}
