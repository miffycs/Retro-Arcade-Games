package frogger.enums;

import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;

public enum Obstacle {
    
    CAR_LEFT("file:src/frogger/img/obstacles/car/car_left.png", 50),
    CAR_RIGHT("file:src/frogger/img/obstacles/car/car_right.png", 50),
    
    TRUCK_LEFT("file:src/frogger/img/obstacles/car/truck_left.png", 120),
    TRUCK_RIGHT("file:src/frogger/img/obstacles/car/truck_right.png", 120),
    TRUCK_LONG_LEFT("file:src/frogger/img/obstacles/car/truck_left_long.png", 200),
    TRUCK_LONG_RIGHT("file:src/frogger/img/obstacles/car/truck_right_long.png", 200),
    
    LOG_SHORT("file:src/frogger/img/obstacles/log/short.png", 150),
    LOG_MED("file:src/frogger/img/obstacles/log/med.png", 200),
    LOG_LONG("file:src/frogger/img/obstacles/log/long.png", 300),
    
    TURTLE("file:src/frogger/img/obstacles/turtle/Turtle", 130),
    TURTLE_SINKS("file:src/frogger/img/obstacles/turtle/TurtleSinks", 130),
    
    ;
    
    private final String imgPath;
    private final int imgSize;
    private int x;
    private int y;
    private Image img;
    
    private Obstacle(String imgPath, int imgSize) {
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
