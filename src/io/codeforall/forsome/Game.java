package io.codeforall.forsome;

import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.Player;
import io.codeforall.forsome.grid.Grid;
import io.codeforall.forsome.level.GameOverScreen;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {
    private int score;
    private Grid grid;
    private Collideable player;
    private Keyboard keyboard;

    private Collideable enemy1;
    private Collideable enemy2;
    private GameOverScreen gameOverScreen;

    public static GameState gameState;


    private int delay;

    public Game(int width, int height, int delay) {
        this.grid = new Grid(width, height);
        this.player = new Player(this.grid);
        this.delay = delay;
        this.enemy1 = new NormalEnemy(50, 5, this.grid, true);
        this.enemy2 = new NormalEnemy(50, 5, this.grid, true);
        this.gameState = GameState.INGAME;
        this.gameOverScreen = new GameOverScreen(this.grid);
        this.keyboard = new Keyboard(this);
        addKeyboard();

        CollideableManager.addCollideable(enemy1);

    }

    public void start() throws InterruptedException {
        while(gameState == GameState.STARTMENU) {
            Thread.sleep(this.delay);

        }

        while (gameState == GameState.INGAME) {
            Thread.sleep(this.delay);
            CollideableManager.detectCollisions();
            CollideableManager.show();
            CollideableManager.move();

            if(player.isDead()) {
                gameState = GameState.GAMEOVER;
            }
        }

        while (gameState == GameState.GAMEOVER) {
            Thread.sleep(this.delay);
            this.gameOverScreen.show();

            if(gameState == GameState.INGAME) {
                restart(false);
            }
        }
    }

    private void addKeyboard() {
        // move right
        KeyboardEvent escape = new KeyboardEvent();
        escape.setKey(KeyboardEvent.KEY_ESC);
        escape.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(escape);

        
        KeyboardEvent startGame = new KeyboardEvent();
        startGame.setKey(KeyboardEvent.KEY_ENTER);
        startGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(startGame);

    }

    private void restart(boolean startMenu) throws InterruptedException  {
        if(startMenu) {
            resetVariables();
            gameState = GameState.STARTMENU;
            start();
            return;
        }

        resetVariables();
        start();
        gameState = GameState.INGAME;
    }

    private void resetVariables() {
        CollideableManager.clearCollideableList();
        this.player = new Player(this.grid);
        this.gameOverScreen.remove();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        if(key == KeyboardEvent.KEY_ENTER){
            if(gameState == GameState.GAMEOVER) {
                gameState = GameState.INGAME;
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
