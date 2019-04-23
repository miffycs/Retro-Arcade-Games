package frogger;

import frogger.enums.Img;

public class End extends Actor {

    // keeps track of whether End slot is occupied
    private boolean isOccupied = false;

    // constructor
    public End(int x, int y) {
        setImage(Img.END_SLOT.img());
        setX(x);
        setY(y);
    }

    // add an EndFrog image to End slot, mark End slot as occupied
    public void addFrog() {
        setImage(Img.END_FROG.img());
        this.isOccupied = true;
    }

    // returns if End slot is occupied
    public boolean isOccupied() {
        return this.isOccupied;
    }
    
    // don't do anything, End slots don't move
    @Override
    public void act(long now) {}

}
