package io.codeforall.forsome.level;

import io.codeforall.forsome.Collideable;
import io.codeforall.forsome.CollideableManager;
import io.codeforall.forsome.Game;
import io.codeforall.forsome.ScoreWriter;
import io.codeforall.forsome.characters.Enemy;
import io.codeforall.forsome.characters.NormalEnemy;
import io.codeforall.forsome.characters.NoskEnemy;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level {

    private Text scoreBoard;
    private Text highestScoreBoard;
    private ScoreWriter scoreWriter = new ScoreWriter();
    private String currentHighestScore = String.valueOf(scoreWriter.readScoreFromFile());

    private Picture ground;
    private Picture portal;
    private Picture backGround;
    private Grid grid;
    private boolean levelEnded;

    private int numberOfEnemies;
    private int remainingEnemies;
    private int enemySpeed;
    private int scoreDeduction;
    private int scoreIncrement;
    private int spawnInterval;
    private int spawnTimer;
    private final double NOSK_SPAWN_RATE = 0.15;


    public Level(Grid grid, Picture backGround, Picture ground, Picture portal, int numberOfEnemies, int enemySpeed, int spawnInterval, int scoreDeduction, int scoreIncrement) {
        this.backGround = backGround;
        this.ground = ground;
        this.portal = portal;
        this.grid = grid;
        this.numberOfEnemies = numberOfEnemies;
        this.remainingEnemies = this.numberOfEnemies;
        this.scoreIncrement = scoreIncrement;
        this.scoreDeduction = scoreDeduction;
        this.enemySpeed = enemySpeed;
        this.spawnInterval = spawnInterval;
        this.spawnTimer = spawnInterval;
        System.out.println("Number of enemies: " + this.numberOfEnemies);

        this.scoreBoard = new Text(5, 5, "");
        this.highestScoreBoard = new Text(5, 20, this.currentHighestScore);

    }

    public Level(Grid grid, Picture backGround, Picture ground, Picture portal) {
        this.backGround = backGround;
        this.ground = ground;
        this.portal = portal;
        this.grid = grid;
        this.numberOfEnemies = 5;
        this.remainingEnemies = this.numberOfEnemies;
        System.out.println("Number of enemies: " + this.numberOfEnemies);
        this.scoreIncrement = 50;
        this.scoreDeduction = 20;
        this.enemySpeed = 7;
        this.spawnInterval = 100;
        this.spawnTimer = spawnInterval;

        this.scoreBoard = new Text(5, 5, "");
        this.highestScoreBoard = new Text(5, 20, this.currentHighestScore);
    }

    public void createEnemies() {
        spawnTimer--;

        if (spawnTimer <= 0 && remainingEnemies > 0) {
            remainingEnemies--;

            if (remainingEnemies <= 0) {
                levelEnded = true;
            }

            if (Math.random() < NOSK_SPAWN_RATE) {
                String source = Math.floor(Math.random() * 2) == 0 ? "src/io/codeforall/forsome/characters/images/Nozk.png" : "src/io/codeforall/forsome/characters/images/Nozk1_resized.png";
                Collideable noskEnemy = new NoskEnemy(300, grid, scoreDeduction * 3, scoreIncrement * 4, enemySpeed / 3, source);
                CollideableManager.addCollideable(noskEnemy);
                noskEnemy.show();
                spawnTimer = spawnInterval;
                return;
            }

            Collideable normalEnemy = new NormalEnemy(1, enemySpeed, grid, scoreDeduction, scoreIncrement);
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


    public void scoreBoard() {
        this.scoreBoard.setText("Score: " + Game.score);
        this.scoreBoard.setColor(Color.WHITE);
        this.scoreBoard.draw();
    }

    public void highestScoreBoard() {
        this.currentHighestScore = String.valueOf(this.scoreWriter.compareScores(Game.score));
        this.highestScoreBoard.setText("Highest Score: " + this.currentHighestScore);
        this.highestScoreBoard.setColor(Color.WHITE);
        this.highestScoreBoard.draw();
    }

    public void draw() {
        backGround.draw();
        portal.draw();
    }

}


