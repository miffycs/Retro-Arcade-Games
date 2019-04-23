package frogger;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView {

    // getters method for parent (World/Pane that it belongs to)
    public World getWorld() {
        return (World) getParent();
    }

    // getters method for width
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    // getters method for height
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
    
    // move Actor on the Pane
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    // check for objects that intersect with this object
    // by going through other Actors in the same World
    public <A extends Actor> List<A> getIntersectingObjects(Class<A> cls) {
        ArrayList<A> arr = new ArrayList<>();
        for (A actor : getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                arr.add(actor);
            }
        }
        return arr;
    }

    // check for objects that intersect with this object
    // by going through other Actors in the same World
//    public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
//        ArrayList<A> arr = new ArrayList<>();
//        for (A actor : getWorld().getObjects(cls)) {
//            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
//                arr.add(actor);
//                break;
//            }
//        }
//        return arr.get(0);
//    }

    public abstract void act(long now);

}
