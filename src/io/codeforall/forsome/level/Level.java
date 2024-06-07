package io.codeforall.forsome.level;

import io.codeforall.forsome.Collideable;
import io.codeforall.forsome.CollideableManager;
import io.codeforall.forsome.characters.Enemy;
import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.NoskEnemy;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level {

    private Picture ground;
    private Picture portal;
    private Picture backGround;
    private Grid grid;
    private boolean levelEnded;

    private int numberOfEnemies;
    private int enemySpeed;
    private int scoreDeduction;
    private int scoreIncrement;
    private int spawnInterval;
    private int spawnTimer;
    private final double NOSK_SPAWN_RATE = 0.2;

    public Level(Grid grid, Picture backGround,Picture ground,Picture portal,int numberOfEnemies, int enemySpeed, int spawnInterval, int scoreDeduction, int scoreIncrement) {
        this.backGround = backGround;
        this.ground = ground;
        this.portal = portal;
        this.grid = grid;
        this.numberOfEnemies = numberOfEnemies;
        this.scoreIncrement = scoreIncrement;
        this.scoreDeduction = scoreDeduction;
        this.enemySpeed = enemySpeed;
        this.spawnInterval = spawnInterval;
        this.spawnTimer = spawnInterval;
    }

    public Level(Grid grid, Picture backGround,Picture ground,Picture portal) {
        this.backGround = backGround;
        this.ground = ground;
        this.portal = portal;
        this.grid = grid;
        this.numberOfEnemies = 5;
        this.scoreIncrement = 50;
        this.scoreDeduction = 20;
        this.enemySpeed = 7;
        this.spawnInterval = 100;
        this.spawnTimer = spawnInterval;
    }

    public void createEnemies() {
        spawnTimer--;

        if(spawnTimer <= 0 && numberOfEnemies > 0) {
            numberOfEnemies--;

            if(numberOfEnemies<=0) {
                levelEnded = true;
            }

            if(Math.random() < NOSK_SPAWN_RATE) {
                Collideable noskEnemy = new NoskEnemy(300,grid,scoreDeduction * 3,scoreIncrement * 4, enemySpeed / 3);
                CollideableManager.addCollideable(noskEnemy);
                noskEnemy.show();
                spawnTimer = spawnInterval;
                return;
            }

            Collideable normalEnemy = new NormalEnemy(1,enemySpeed,grid,scoreDeduction,scoreIncrement);
            CollideableManager.addCollideable(normalEnemy);
            normalEnemy.show();
            spawnTimer = spawnInterval;
        }
    }

    public int getEnemySpeed() {
        return this.enemySpeed;
    }

    public int getEnemySpawnInterval() {
        return this.spawnInterval;
    }

    public int getNumberOfEnemies() {
        return this.numberOfEnemies;
    }

    public int getScoreDeduction() {
        return this.scoreDeduction;
    }

    public int getScoreIncrement() {
        return this.scoreIncrement;
    }

    public boolean getLevelEnded() {
        return this.levelEnded;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public void draw() {
        backGround.draw();
        //ground.draw();
        portal.draw();

    }
}


