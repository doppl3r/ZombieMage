import java.awt.*;

public class Game {
    private boolean gameOver;
    public Blood blood;
    public Player player;
    public EnemyHandler enemies;
    public Background background;
    public int currentTime;
    public int maxTime;

    public Game(){
        blood = new Blood();
        player = new Player();
        enemies = new EnemyHandler();
        background = new Background();
        currentTime = maxTime = 5000;
    }
    public void draw(Graphics2D g){
        background.draw(g);
        blood.draw(g);
        enemies.draw(g);
        player.draw(g);

    }
    public void update(){
        blood.update();
        player.update();
        enemies.update();
        if (currentTime > 0) currentTime--;
        else Window.panel.setPanelState(2); //game over
    }

    //key pressed
    public void keyUpPressed(){ player.moveUp(true); }
    public void keyDownPressed(){ player.moveDown(true); }
    public void keyLeftPressed(){ player.moveLeft(true); }
    public void keyRightPressed(){ player.moveRight(true); }

    //key released
    public void keyUpReleased(){ player.moveUp(false); }
    public void keyDownReleased(){ player.moveDown(false); }
    public void keyLeftReleased(){ player.moveLeft(false); }
    public void keyRightReleased(){ player.moveRight(false); }

    //setGameOver
    public void setGameOver(boolean gameOver){ this.gameOver=gameOver; }
    public boolean isGameOver(){ return gameOver; }
    public int getCurrentTime(){ return currentTime; }
}
