package io.codeforall.forsome;

import io.codeforall.forsome.characters.Destroyable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface Collideable extends Destroyable {

    void move();
    Picture getPicture();
}
