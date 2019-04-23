package frogger;

import frogger.enums.Frogger;

import javafx.scene.input.KeyEvent;

public class Frog extends Actor {
    
    private final double moveX = 10.666666 * 2;
    private final double moveY = 13.333333 * 2;
    private boolean isJumping = false;
    private boolean isMovementDisabled = false;
    
    private boolean isDead_Land = false;
    private boolean isDead_Water = false;
    private int deathAnimation = 0;
    
    private int score = 0;
    private boolean isScoreChanged = false;
    
    private int numEndFrogs = 0;
    private int perfectRoundScore = 800;
    
    @Override
    public void act(long now) {
        this.checkXYBounds();
        this.checkIntersections();
        this.checkDeath(now);
    }
    
    public Frog() {
        
        setImage(Frogger.UP.img());
        this.resetOriginalXY();
        
        setOnKeyPressed((KeyEvent event) -> {
            if (!isMovementDisabled) {
                if (isJumping) {
                    isJumping = false;
                    switch (event.getCode()) {
                        case W:
                        case UP:
                            move(0, -moveY);
                            setImage(Frogger.UP.img());
                            break;
                        case A:
                        case LEFT:
                            move(-moveX, 0);
                            setImage(Frogger.LEFT.img());
                            break;
                        case S:
                        case DOWN:
                            move(0, moveY);
                            setImage(Frogger.DOWN.img());
                            break;
                        case D:
                        case RIGHT:
                            move(moveX, 0);
                            setImage(Frogger.RIGHT.img());
                            break;
                        default:
                            break;
                    }
                } else {
                    isJumping = true;
                    switch (event.getCode()) {
                        case W:
                        case UP:
                            move(0, -moveY);
                            setImage(Frogger.UP_JUMP.img());
                            break;
                        case A:
                        case LEFT:
                            move(-moveX, 0);
                            setImage(Frogger.LEFT_JUMP.img());
                            break;
                        case S:
                        case DOWN:
                            move(0, moveY);
                            setImage(Frogger.DOWN_JUMP.img());
                            break;
                        case D:
                        case RIGHT:
                            move(moveX, 0);
                            setImage(Frogger.RIGHT_JUMP.img());
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        setOnKeyReleased((KeyEvent event) -> {
            if (!isMovementDisabled) {
                isJumping = false;
                switch (event.getCode()) {
                    case W:
                    case UP:
                        if (getY() < perfectRoundScore && getY() > 152) {
                            isScoreChanged = true;
                            perfectRoundScore = (int)getY();
                            score += 10;
//                            System.out.println("Forward: " + this.score);
                        }
                        move(0, -moveY);
                        setImage(Frogger.UP.img());
                        break;
                    case A:
                    case LEFT:
                        move(-moveX, 0);
                        setImage(Frogger.LEFT.img());
                        break;
                    case S:
                    case DOWN:
                        move(0, moveY);
                        setImage(Frogger.DOWN.img());
                        break;
                    case D:
                    case RIGHT:
                        move(moveX, 0);
                        setImage(Frogger.RIGHT.img());
                        break;
                    default:
                        break;
                }
            }
        });
    } // constructor end
    
    
    private void resetOriginalXY() {
        setX(300);
        setY(679.8 + moveY);
    }
        
    private void checkXYBounds() {
        if (getX() < 0) {
            move(moveY * 2, 0);
        } else if (getX() > 600) {
            move(-moveY * 2, 0);
        }
        if (getY() < 0 || getY() > 734) {
            this.resetOriginalXY();
        }
    }
    
    private void checkIntersections() {
        // check Cars, Logs, Turtles
        if (getIntersectingObjects(Car.class).size() >= 1) {
            isDead_Land = true;
        } else if (getIntersectingObjects(Log.class).size() >= 1 && !isMovementDisabled) {
            // move Frog on Log if at end of bound
            if (getIntersectingObjects(Log.class).get(0).isDirectionLeft()) {
                move(-2, 0);
            } else {
                move(.75, 0);
            }
        } else if (getIntersectingObjects(Turtle.class).size() >= 1 && !isMovementDisabled) {
            if (!getIntersectingObjects(Turtle.class).get(0).isSunk()) {
                move(-1, 0);
            } else {
                // if Frog not on Log and not on Turtle that is floating
                isDead_Water = true;
            }
        } else if (getIntersectingObjects(End.class).size() >= 1) {
            if (getIntersectingObjects(End.class).get(0).isOccupied()) {
                numEndFrogs--;
                score -= 60;
//                System.out.println("Dup--: " + this.score);
            }
            score += 60;
//            System.out.println("New Frog: " +this.score);
            isScoreChanged = true;
            perfectRoundScore = 800;
            getIntersectingObjects(End.class).get(0).addFrog();
            numEndFrogs++;
            this.resetOriginalXY();
        } else if (getY() < 434) {
            isDead_Water = true;
        }
    }
    
    private void checkDeath(long now) {
        if (isDead_Land) {
            onDeathEvent(now, Frogger.DEATH_LAND);
        } else if (isDead_Water) {
            onDeathEvent(now, Frogger.DEATH_WATER);
        }
    }
    
    private void onDeathEvent(long now, Frogger death) {
        
        this.isMovementDisabled = true;

        // check every time
        if ((now) % 10 == 0) {
            deathAnimation++;
        }
        // death animation using switch, last step reverts to starting point
        switch (deathAnimation) {
            case 1:
            case 2:
            case 3: {
                setImage(death.img(deathAnimation));
                break;
            }
            case 4: {
                if (death == Frogger.DEATH_WATER) {
                    setImage(death.img(deathAnimation));
                    break;
                }
                // if death == DEATH_LAND, go to 5
            }
            case 5: {
                setImage(Frogger.UP.img());
                this.resetOriginalXY();
                isDead_Land = false;
                isDead_Water = false;
                deathAnimation = 0;
                if (score >= 50) {
                    score -= 50;
//                    System.out.println("Death: " + this.score);
                    isScoreChanged = true;
                }
                isMovementDisabled = false;
                break;
            }
        }
    }
    
    public boolean scoreChanged() {
        if (isScoreChanged) {
            isScoreChanged = false;
            return true;
        }
        return false;
    }

    public int getScore() {
//        System.out.println("Returned: " + this.score);
        return this.score;
    }
    
    public boolean isGameFinished() {
        return numEndFrogs == 5;
    }
    
}
