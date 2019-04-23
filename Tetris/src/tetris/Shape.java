package tetris;

import java.util.ArrayList;
import java.util.Random;

/*
 * Called by Board as the current piece of Tetromino falling.
 * Has variables storing information on the current piece on the Board.
 * Contains methods for manipulating coordinates of a Tetromino.
 */
public class Shape {

    /*
     * coords of a shape is made out of 4 square blocks,
     * stored in each row of int[4][2] coords,
     * with each column as (x,y) coordinates of each block
     */
    private Tetrominoes pieceShape;
    private int[][] coords;

    private static ArrayList<Integer> list = new ArrayList<Integer>();
    private static ArrayList<Integer> shapesCalled = new ArrayList<Integer>();

    // constructor
    public Shape() {
	// 4 squre blocks on each row, 2 coords for (x, y)
        this.coords = new int[4][2];
	// default enum shape is NoShape, then override it
        this.setShape(Tetrominoes.NoShape);
    }

    // override enum Tetromino passed in
    // by using Random to pick a new Tetrominoes enum
    // store coords from enum picked into this.coords
    public void setShape(Tetrominoes shape) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; ++j) {
                this.coords[i][j] = shape.coords[i][j];
            }
        }
        this.pieceShape = shape;
    }
    
    // set the X coordinate at index index
    private void setX(int index, int x) {
        coords[index][0] = x;
    }

    // set the Y coordinate at index index
    private void setY(int index, int y) {
        coords[index][1] = y;
    }

    // x coordinate of block 1 of 4 of a Tetrominoes shape
    public int x(int index) {
        return coords[index][0];
    }

    // y coordinate of block 1 of 4 of a Tetrominoes shape
    public int y(int index) {
        return coords[index][1];
    }

    // return Tetrominoes representing shape of the current piece
    public Tetrominoes getShape() {
        return pieceShape;
    }

    // save the 7 shapes in their set order to static ArrayList list
    // pick a shape randomly out of the available shapes left
    // when all 7 shapes have been called, reset the list to every shape 
    private static int randomSevenShape() {
        if (list.isEmpty()) {
            for (int i = 0; i < 7; i++) {
                list.add(i + 1);
            }
        }
        if (list.size() == 1) {
            shapesCalled.add(list.get(0));
            list.clear();
            for (int i = 0; i < 7; i++) {
                list.add(i + 1);
            }
            return shapesCalled.get(shapesCalled.size() - 1);
        }
        Random r = new Random();
        int index = r.nextInt(list.size());
        shapesCalled.add(list.get(index));
        list.remove(index);
        return shapesCalled.get(shapesCalled.size() - 1);
    }

    // not completely random
    // go through a set of 7 shapes before calling another set 
    public void setRandomShape() {
        int x = randomSevenShape();
        Tetrominoes[] values = Tetrominoes.values();
        setShape(values[x]);
    }

    // return the minimum X coordinate
    public int minX() {
        int m = coords[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][0]);
        }
        return m;
    }

    // return the minimum Y coordinate
    public int minY() {
        int m = coords[0][1];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coords[i][1]);
        }
        return m;
    }

    /* 
     * rotateLeft() / rotateRight()
     * manipulates coords of Shape calling on this method,
     * to rotate it in the direction chosen.
     * and return new Shape with rotated coords,
     * but keep the Tetromino enum the same
     */
    
    // rotate counter-clockwise
    public Shape rotateLeft() {
        if (pieceShape == Tetrominoes.OShape) {
            return this;
        }
        Shape result = new Shape();
        result.pieceShape = pieceShape;
        for (int i = 0; i < 4; i++) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    // rotate clockwise
    public Shape rotateRight() {
        if (pieceShape == Tetrominoes.OShape) {
            return this;
        }
        Shape result = new Shape();
        result.pieceShape = pieceShape;
        for (int i = 0; i < 4; i++) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }

}
