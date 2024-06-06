package io.codeforall.forsome;

import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.Player;
import io.codeforall.forsome.grid.Grid;

public class Game {
    private int score;
    private Grid grid;
    private Collideable player;

    private Collideable enemy1;
    private Collideable enemy2;




    private int delay;

    public Game(int width, int height, int delay) {
        this.grid = new Grid(width, height);
        this.player = new Player(this.grid);
        this.delay = delay;
        this.enemy1 = new NormalEnemy(50, 5, this.grid, true);
        this.enemy2 = new NormalEnemy(50, 5, this.grid, true);
        CollideableManager.addCollideable(player);
        CollideableManager.addCollideable(enemy1);
        // CollideableManager.addCollideable(enemy2);
    }

    public void start() throws InterruptedException {
        while (!player.isDead()) {
            Thread.sleep(this.delay);
            CollideableManager.detectCollisions();
            CollideableManager.show();
            CollideableManager.move();
        }
    }
}
