package io.codeforall.forsome.level;

import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class GameOverScreen {
    private Picture background;
    private Text text;

    public GameOverScreen(Grid grid) {
        this.background = new Picture(0,0,"src/io/codeforall/forsome/level/hell.jpeg");
        this.text = new Text(grid.getWidth() / 2,grid.getHeight() / 2,"Game Over");
        this.text.grow(250,100);
        this.text.setColor(Color.RED);
    }

    public void show() {
        this.background.draw();
        this.text.draw();
    }

    public void remove() {
        this.background.delete();
        this.text.delete();
    }
}
