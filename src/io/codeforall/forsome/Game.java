package io.codeforall.forsome;

import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.Player;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game {
    private Grid grid;
    private Text scoreBoard;
    private Text healthBoard;

    public static int score = 20;
    private Collideable player;
    private Collideable enemy1;
    private Collideable enemy2;

    private int delay;

    public Game(int width, int height, int delay) {
        this.grid = new Grid(width, height);
        scoreBoard = new Text(5, 5, "");
        healthBoard = new Text(5, 20, "");

        this.player = new Player(this.grid);
        this.delay = delay;
        this.enemy1 = new NormalEnemy(50, 15, this.grid, true, 5, 10);
        this.enemy2 = new NormalEnemy(50, 10, this.grid, true, 3, 6);
        CollideableManager.addCollideable(player);
        CollideableManager.addCollideable(enemy1);
        CollideableManager.addCollideable(enemy2);
    }

    public void start() throws InterruptedException {
        while (!player.isDead()) {
            Thread.sleep(this.delay);
            CollideableManager.detectCollisions();
            CollideableManager.show();
            CollideableManager.move();
            this.scoreBoard();
            if (score < 0) {
                player.kill();
                System.out.println("F Player: " + score);
            }
        }
    }

    //Create score as Text
    public void scoreBoard() {
        scoreBoard.setText("Score: " + score);
        scoreBoard.setColor(Color.BLACK);

        scoreBoard.draw();
        healthBoard.setText("Health: " + score);
        healthBoard.setColor(Color.BLACK);

        healthBoard.draw();

    }
}
