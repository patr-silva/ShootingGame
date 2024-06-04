package io.codeforall.forsome;

import io.codeforall.forsome.characters.Enemy;
import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.Player;
import io.codeforall.forsome.grid.Grid;

import java.awt.*;

public class Game {
    private int score;
    private Grid grid;
    private Player player;
    private CollisionDetector collisionDetector;

    private Enemy enemy1;
    private Enemy enemy2;



    private int delay;

    public Game(int width, int height, int delay) {
        this.grid = new Grid(width, height);
        this.player = new Player(this.grid);
        this.delay = delay;
        this.collisionDetector = new CollisionDetector();
        this.enemy1 = new NormalEnemy(50, 20, this.grid, true);
        this.enemy2 = new NormalEnemy(50, 23, this.grid, true);
    }

    public void start() throws InterruptedException {
        player.show();


        enemy1.drawEnemy();
        enemy2.drawEnemy();

        while (!player.isDead()) {
            Thread.sleep(this.delay);
            player.move();

            enemy1.move();
            enemy2.move();
        }
    }
}
