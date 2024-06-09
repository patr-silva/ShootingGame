package io.codeforall.forsome;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(0, 0,1366, 768);
        rectangle.setColor(Color.GRAY);
        rectangle.fill();

        Game game = new Game(1366,768, 20);
        game.start();
    }
}
