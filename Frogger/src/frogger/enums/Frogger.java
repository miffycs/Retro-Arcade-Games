package frogger.enums;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public enum Frogger {
    
    UP("file:src/frogger/img/frogger/movement/up.png"),
    LEFT("file:src/frogger/img/frogger/movement/left.png"),
    RIGHT("file:src/frogger/img/frogger/movement/right.png"),
    DOWN("file:src/frogger/img/frogger/movement/down.png"),
    UP_JUMP("file:src/frogger/img/frogger/movement/up_jump.png"),
    LEFT_JUMP("file:src/frogger/img/frogger/movement/left_jump.png"),
    RIGHT_JUMP("file:src/frogger/img/frogger/movement/right_jump.png"),
    DOWN_JUMP("file:src/frogger/img/frogger/movement/down_jump.png"),
    
    DEATH_LAND("file:src/frogger/img/frogger/death/land/"),
    DEATH_WATER("file:src/frogger/img/frogger/death/water/");
    
    ;

    private final String imgPath;
    private final int imgSize;
    private int x;
    private int y;
    private Image img;

    private Frogger(String imgPath) {
        this.imgPath = imgPath;
        this.imgSize = 40;
    }
    
    public Image img() {
        this.img = new Image(this.imgPath, this.imgSize, this.imgSize, true, true);
        return this.img;
    }
    
    public Image img(int imgIndex) {
        this.img = new Image(this.imgPath+imgIndex+".png", this.imgSize, this.imgSize, true, true);
        return this.img;
    }
    
//    public ImageView getImgView(int imgIndex, int x, int y) {
//        
//        ImageView imgView = new ImageView();
//        this.img = this.img(imgIndex);
//        
//        this.x = x;
//        this.y = y;
//        
//        imgView.setImage(this.img);
//        imgView.setX(x);
//        imgView.setY(y);
//        
//        return imgView;
//    }
}
