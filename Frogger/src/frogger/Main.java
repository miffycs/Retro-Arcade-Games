package frogger;

import frogger.enums.Img;
import frogger.enums.Obstacle;
import java.util.Optional;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class Main extends Application {

    // variables
    private AnimationTimer timer;
    private GameStage gamestage;
    private Frog player;
    private String playerName;

    // main method
    public static void main(String[] args) {
        launch(args);
    }
    
    // start the game
    @Override
    public void start(Stage primaryStage) {

        // set background, set Scene
        this.gamestage = new GameStage();
        this.gamestage.add(Img.BACKGROUND.img(), 0, 0);
        Scene scene = new Scene(gamestage, 600, 800);

        // set score
        this.resetScore();

        // add end slots
        this.resetEnd();

        // add obstacles
        this.resetObstacles();

        // add Frogger
        this.player = new Frog();
        this.gamestage.add(this.player);

        // start
        this.gameStart();
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // ask player for name
        this.askPlayerName();
    }
    
    // asks player for their name to show when game ends
    private void askPlayerName() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Player Name");
        dialog.setHeaderText("Please enter your name:");
        dialog.setContentText("Name:");
        Optional<String> result = dialog.showAndWait();
        
        // if result caught something && result is not empty
        result.ifPresent(name -> {
            if (!result.equals("")) {
                this.playerName = result.get();
            } else {
                this.playerName = "Anon Player";
            }
        });
    }
    
    // start the game: world & timer & music
    public void gameStart() {
        this.gamestage.start();
        this.gamestage.playMusic();
        this.createTimer();
        this.timer.start();
    }
    
    // create a new AnimationTimer
    private void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // if scoreChanged, set score in World to new score
                if (player.scoreChanged()) {
                    setScore(player.getScore());
                }
                // if gameFinished (5 Frogs in End), end game
                if (player.isGameFinished()) {
                    gamestage.stopMusic();
                    timer.stop();
                    gamestage.stop();
                    
                    // show game results
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("You Won!");
                    alert.setHeaderText("Score for " + playerName);
                    alert.setContentText("Your score is: " + player.getScore() + "\n"
                            + "(Highest possible score: 800)");
                    alert.show();
                }
            }
        };
    }
    
    // reset the score to 000
    private void resetScore() {
        gamestage.add(Img.DIGITS.img(0), 500, 30);
        gamestage.add(Img.DIGITS.img(0), 500-30, 30);
        gamestage.add(Img.DIGITS.img(0), 500-30-30, 30);
    }
    
    // set score in World to current score,
    // starting with right most digit
    private void setScore(int n) {
        this.resetScore();
        int shift = 0;
        while(n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            gamestage.add(Img.DIGITS.img(k), 500-shift, 30);
            shift += Img.DIGITS.imgSize;
        }
    }
    
    // reset the End slots to all empty
    private void resetEnd() {
        gamestage.add(new End( 13, 96));
        gamestage.add(new End(141, 96));
        gamestage.add(new End(270, 96));
        gamestage.add(new End(399, 96));
        gamestage.add(new End(527, 96));
    }
    
    // reset all obstacles: Car, Log, Turtle
    private void resetObstacles() {
        // logs top
        gamestage.add(new Log(Obstacle.LOG_SHORT, 0, 166, 0.75));
        gamestage.add(new Log(Obstacle.LOG_SHORT, 220, 166, 0.75));
        gamestage.add(new Log(Obstacle.LOG_SHORT, 440, 166, 0.75));

        // turtle upper
        gamestage.add(new Turtle(Obstacle.TURTLE_SINKS, 200, 217, -1));
        gamestage.add(new Turtle(Obstacle.TURTLE_SINKS, 400, 217, -1));
        gamestage.add(new Turtle(Obstacle.TURTLE_SINKS, 600, 217, -1));
        
        // logs mid
        gamestage.add(new Log(Obstacle.LOG_LONG, 0, 276, -2));
        gamestage.add(new Log(Obstacle.LOG_LONG, 400, 276, -2));

        // logs bot
        gamestage.add(new Log(Obstacle.LOG_SHORT, 50, 329, 0.75));
        gamestage.add(new Log(Obstacle.LOG_SHORT, 270, 329, 0.75));
        gamestage.add(new Log(Obstacle.LOG_SHORT, 490, 329, 0.75));
        gamestage.add(new Log(Obstacle.LOG_SHORT, 570, 329, 0.75));

        // turtle lower
        gamestage.add(new Turtle(Obstacle.TURTLE, 300, 376, -1));
        gamestage.add(new Turtle(Obstacle.TURTLE_SINKS, 500, 376, -1));
        gamestage.add(new Turtle(Obstacle.TURTLE, 700, 376, -1));

        // add cars fast
        gamestage.add(new Car(Obstacle.CAR_LEFT, 500, 490, -5));

        // add trucks long
        gamestage.add(new Car(Obstacle.TRUCK_LONG_RIGHT, 0, 540, 1));
        gamestage.add(new Car(Obstacle.TRUCK_LONG_RIGHT, 500, 540, 1));

        // add cars
        gamestage.add(new Car(Obstacle.CAR_LEFT, 100, 597, -1));
        gamestage.add(new Car(Obstacle.CAR_LEFT, 250, 597, -1));
        gamestage.add(new Car(Obstacle.CAR_LEFT, 400, 597, -1));
        gamestage.add(new Car(Obstacle.CAR_LEFT, 550, 597, -1));

        // add trucks
        gamestage.add(new Car(Obstacle.TRUCK_RIGHT, 0, 649, 1));
        gamestage.add(new Car(Obstacle.TRUCK_RIGHT, 300, 649, 1));
        gamestage.add(new Car(Obstacle.TRUCK_RIGHT, 600, 649, 1));
    }

}
