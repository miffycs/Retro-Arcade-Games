package frogger;

import java.io.File;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GameStage extends World {

    private MediaPlayer mediaPlayer;

    @Override
    public void act(long now) {}

    public GameStage() {
        // debug: when click on World, show X and Y values
        
        this.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("[" + e.getX() + ", " + e.getY() + "]");
        });
        
        /* // same as above lambda
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("[" + e.getX() + ", " + e.getY() + "]");
            }
        });
        */
    }

    public void playMusic() {
        String musicFile = "src/frogger/music/theme-loop.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void stopMusic() {
        mediaPlayer.stop();
    }

}
