package frogger;

import java.io.File;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GameStage extends World {

    // MediaPlayer that plays background music
    private MediaPlayer mediaPlayer;

    // constructor, turn on debug mode if desire
    public GameStage() {
        this.debugMode(true);
    }
    
    // debug: when click on World, show X and Y coordinates
    private void debugMode(boolean debugOn) {
        if (debugOn) {
            this.setOnMouseClicked((MouseEvent e) -> {
                System.out.println("[" + e.getX() + ", " + e.getY() + "]");
            });
        }
    }

    // start playing music
    public void playMusic() {
        String musicFile = "src/frogger/music/theme-loop.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    // stop playing music
    public void stopMusic() {
        mediaPlayer.stop();
    }

    // don't do anything, GameStage doesn't move
    // only move the Actors in the GameStage
    @Override
    public void act(long now) {}
    
}
