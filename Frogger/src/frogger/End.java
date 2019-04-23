package frogger;

import frogger.enums.Img;

public class End extends Actor {

    private boolean isOccupied = false;

    public End(int x, int y) {
        setImage(Img.END_SLOT.img());
        setX(x);
        setY(y);
    }

    public void addFrog() {
        setImage(Img.END_FROG.img());
        this.isOccupied = true;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }
    
    @Override
    public void act(long now) {}

}
