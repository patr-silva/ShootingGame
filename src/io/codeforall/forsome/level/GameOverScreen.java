package io.codeforall.forsome.level;

import io.codeforall.forsome.Game;
import io.codeforall.forsome.ScoreWriter;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class GameOverScreen {
    private Picture background;
    private Text highScore;
    private Text score;
    private Grid grid;

    public GameOverScreen(Grid grid) {
        this.grid = grid;
        this.background = new Picture(0,0,"src/io/codeforall/forsome/level/Images/Gameover background.jpeg");
        //this.text = new Text(grid.getWidth() / 2,grid.getHeight() / 2,"Game Over");
        //this.text.grow(250,100);
        //this.text.setColor(Color.RED);
    }

    public void show() {
        ScoreWriter scoreWriter = new ScoreWriter();
        int hScore = scoreWriter.readScoreFromFile();

        background.draw();
        highScore = new Text(grid.getWidth() / 2 + 150,grid.getHeight() / 2 + 150,"Highest Score: " + hScore);
        highScore.grow(100,15);
        highScore.setColor(Color.WHITE);
        highScore.draw();

       score = new Text(grid.getWidth() / 3 - 50, grid.getHeight() / 2 + 150, "Your Score: " + Game.score);
       score.grow(100, 15);
       score.setColor(Color.WHITE);
       score.draw();
        //this.text.draw();
    }

    public void remove() {
        this.background.delete();
        highScore.delete();
        score.delete();
    }
}
