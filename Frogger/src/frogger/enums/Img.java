package frogger.enums;

import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;

/*
 * Stores imgPath, imgSize, x/y coordinates
 * Methods for accessing Image and ImageView
 */
public enum Img {
    
    BACKGROUND("file:src/frogger/img/scene/background.png", 800),
    DIGITS("file:src/frogger/img/digits/", 30),
    END_SLOT("file:src/frogger/img/scene/end/slot.png", 60),
    END_FROG("file:src/frogger/img/scene/end/frog.png", 70),
    ;

    public String imgPath;
    public int imgSize;
    public int x;
    public int y;
    private Image img;

    private Img(String imgPath, int imgSize) {
        this.imgPath = imgPath;
        this.imgSize = imgSize;
    }
    
    public Image img() {
        this.img = new Image(this.imgPath, this.imgSize, this.imgSize, true, true);
        return this.img;
    }
    
    public Image img(int imgIndex) {
        this.img = new Image(this.imgPath+imgIndex+".png", this.imgSize, this.imgSize, true, true);
        return this.img;
    }
    
//    public ImageView getImgView(int imgIndex, int x, int y){
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
//        imgView.setPickOnBounds(true);
//        
//        return imgView;
//    }
}
