package io.codeforall.forsome;

import io.codeforall.forsome.characters.Player;
import io.codeforall.forsome.grid.Grid;
import io.codeforall.forsome.level.GameOverScreen;
import io.codeforall.forsome.level.Level;
import io.codeforall.forsome.level.LevelFactory;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game implements KeyboardHandler {
    private Grid grid;
    private Text scoreBoard;
    private Text highestScoreBoard;
    private ScoreWriter scoreWriter = new ScoreWriter();
    private String currentHighestScore = String.valueOf(scoreWriter.readScoreFromFile());

    private Level level;

    public static int score = 0;
    private Collideable player;
    private Keyboard keyboard;

    private GameOverScreen gameOverScreen;

    public static GameState gameState;


    private int delay;

    public Game(int width, int height, int delay) {
        this.grid = new Grid(width, height);
        scoreBoard = new Text(5, 5, "");
        highestScoreBoard = new Text(15, 15, this.currentHighestScore);

        this.level = LevelFactory.createLevel(this.grid, 0, 0, 0, 0, 0, true);

        this.player = new Player(this.grid);

        this.delay = delay;
        this.gameState = GameState.INGAME;
        this.gameOverScreen = new GameOverScreen(this.grid);
        this.keyboard = new Keyboard(this);
        addKeyboard();

        CollideableManager.addCollideable(player);

    }

    public void start() throws InterruptedException {
        while (gameState == GameState.STARTMENU) {
            Thread.sleep(this.delay);

        }

        level.draw();
        player.show();

        while (gameState == GameState.INGAME) {
            Thread.sleep(this.delay);
            //CollideableManager.show();
            CollideableManager.move();
            CollideableManager.detectCollisions(this);
            this.scoreBoard();
            this.highestScoreBoard();
            level.createEnemies();

            if (score < 0) {
                player.kill();
                System.out.println("F Player: " + score);
            }

            if (player.isDead()) {
                gameState = GameState.GAMEOVER;
            }
        }

        while (gameState == GameState.GAMEOVER) {
            Thread.sleep(this.delay);
            this.gameOverScreen.show();

            if (gameState == GameState.INGAME) {
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

    private void restart(boolean startMenu) throws InterruptedException {
        if (startMenu) {
            resetVariables(true);
            gameState = GameState.STARTMENU;
            start();
            return;
        }

        gameState = GameState.INGAME;
        resetVariables(true);
        start();
    }

    private void resetVariables(boolean firstLevel) {
        setLevel(LevelFactory.createLevel(this.grid, 0, 0, 0, 0, 0, firstLevel));
        score = 0;
        this.gameOverScreen.remove();
    }

    public Grid getGrid() {
        return this.grid;
    }

    public Collideable getPlayer() {
        return this.player;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
        level.draw();
        CollideableManager.clearCollideableList();
        player = new Player(grid);
        player.show();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        if (key == KeyboardEvent.KEY_ENTER) {
            if (gameState == GameState.GAMEOVER) {
                gameState = GameState.INGAME;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void scoreBoard() {
        this.scoreBoard.setText("Score: " + score);
        this.scoreBoard.setColor(Color.BLACK);
        this.scoreBoard.draw();
    }

    public void highestScoreBoard() {
        this.currentHighestScore = String.valueOf(this.scoreWriter.compareScores(score));
        highestScoreBoard.setText("Highest Score: " + this.currentHighestScore);
        highestScoreBoard.setColor(Color.BLACK);
        highestScoreBoard.draw();
    }
}
