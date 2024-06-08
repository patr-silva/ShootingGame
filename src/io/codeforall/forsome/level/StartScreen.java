package io.codeforall.forsome.level;

import io.codeforall.forsome.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartScreen {
    private Picture background;
    private Text startGameText;
    private Text gameTitle;

    public StartScreen(Grid grid) {
        this.background = new Picture(0,0,"src/io/codeforall/forsome/level/hell.jpeg");
    }

    public void show() {

    }

    public void remove() {
    }
}
