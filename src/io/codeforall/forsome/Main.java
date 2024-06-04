package io.codeforall.forsome;

import io.codeforall.forsome.level.Level;
import io.codeforall.forsome.level.LevelFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Rectangle rectangle = new Rectangle(0, 0,1366, 768);
        rectangle.setColor(Color.GRAY);
        rectangle.fill();

        Level level = LevelFactory.createLevel();
        level.draw();
        Game game = new Game(1366,768, 20);
        game.start();




        //level.grow(100,100);




    }
}
