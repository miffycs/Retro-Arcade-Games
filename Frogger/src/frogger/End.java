package frogger;

import frogger.enums.Img;

public class End extends Actor {

    private boolean occupied = false;

    @Override
    public void act(long now) {}

    public End(int x, int y) {
        setImage(Img.END_SLOT.img());
        setX(x);
        setY(y);
    }

    public void addFrog() {
        setImage(Img.END_FROG.img());
        this.occupied = true;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

}
