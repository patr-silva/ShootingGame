package io.codeforall.forsome;

import io.codeforall.forsome.characters.Player;
import io.codeforall.forsome.grid.Grid;

import java.awt.*;

public class Game {
    private int score;
    private Grid grid;
    private Player player;
    private CollisionDetector collisionDetector;


    private int delay;

    public Game(int width, int height, int delay) {
        this.grid = new Grid(width, height);
        this.player = new Player(this.grid);
        this.delay = delay;
        this.collisionDetector = new CollisionDetector();
    }

    public void start() throws InterruptedException {
        player.show();

        while(!player.isDead()){
            Thread.sleep(this.delay);

            player.move();

        }
    }
}
