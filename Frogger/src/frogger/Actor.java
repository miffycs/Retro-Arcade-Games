package frogger;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView {

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
    
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    public <A extends Actor> List<A> getIntersectingObjects(Class<A> cls) {
        ArrayList<A> arr = new ArrayList<>();
        for (A actor : getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                arr.add(actor);
            }
        }
        return arr;
    }

    public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
        ArrayList<A> arr = new ArrayList<>();
        for (A actor : getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                arr.add(actor);
                break;
            }
        }
        return arr.get(0);
    }

    public abstract void act(long now);

}
