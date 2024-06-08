package io.codeforall.forsome.level;

import io.codeforall.forsome.ScoreWriter;
import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartScreen {
    private Picture background;
    private Text highScore;
    private Grid grid;

    public StartScreen(Grid grid) {
        this.grid = grid;
        this.background = new Picture(0,0,"src/io/codeforall/forsome/level/Images/Menu Backgroung.jpg");
    }

    public void show() {
        ScoreWriter scoreWriter = new ScoreWriter();
        int hScore = scoreWriter.readScoreFromFile();

        background.draw();
        highScore = new Text(grid.getWidth() / 2 - 50,grid.getHeight() / 3 + 70,"Highest Score: " + hScore);
        highScore.grow(200,25);
        highScore.setColor(Color.WHITE);
        highScore.draw();
    }

    public void remove() {
        background.delete();
        highScore.delete();
    }
}
