package io.codeforall.forsome.characters;

import io.codeforall.forsome.Collideable;
import io.codeforall.forsome.CollideableManager;
import io.codeforall.forsome.grid.Grid;
import io.codeforall.forsome.weapons.Weapon;
import io.codeforall.forsome.weapons.WeaponFactory;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Collideable, KeyboardHandler {
    private Weapon weapon;

    private boolean isDead;
    private boolean collided;

    private Picture characterImage;

    private int movementSpeed;

    private boolean isJumping;
    private boolean isComingDown;
    private boolean isMovingRight;
    private boolean isMovingLeft;

    private final int MAXJUMPHEIGHT = 350;
    private final int MAXJUMPS = 2;
    private int activeJumps;
    private int initialJumpPosition;

    private int groundedPoisition;

    private Grid grid;

    private Keyboard keyboard;

    public Player(Grid grid) {
        this.keyboard = new Keyboard(this);
        CollideableManager.addCollideable(this);
        addKeyboard();

        this.movementSpeed = 10;
        System.out.println(this.movementSpeed);

        this.grid = grid;

        this.characterImage = new Picture();
        this.characterImage.load("src/io/codeforall/forsome/characters/images/emanuel_resized.png");

        this.groundedPoisition = this.grid.getHeight() - this.characterImage.getHeight();
        this.characterImage.translate(0, this.groundedPoisition);

        this.weapon = WeaponFactory.createWeapon(characterImage.getX(),characterImage.getY());


    }

    public void revive() {
        this.isDead = false;
    }

    private void addKeyboard() {
        // move right
        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);

        // stop move right
        KeyboardEvent stopMoveRight = new KeyboardEvent();
        stopMoveRight.setKey(KeyboardEvent.KEY_RIGHT);
        stopMoveRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(stopMoveRight);

        // move left
        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);

        // stop move left
        KeyboardEvent stopMoveLeft = new KeyboardEvent();
        stopMoveLeft.setKey(KeyboardEvent.KEY_LEFT);
        stopMoveLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(stopMoveLeft);

        // jump
        KeyboardEvent jump = new KeyboardEvent();
        jump.setKey(KeyboardEvent.KEY_UP);
        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(jump);

        // shoot
        KeyboardEvent shoot = new KeyboardEvent();
        shoot.setKey(KeyboardEvent.KEY_SPACE);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(shoot);
    }

    public void show() {
        this.characterImage.draw();
        this.weapon.show();
    }

    public void move(){
        if (this.isMovingRight) {
            if(this.characterImage.getMaxX() + movementSpeed <= this.grid.getWidth()) {
                this.characterImage.translate(movementSpeed, 0);
                this.weapon.getWeaponImage().translate(movementSpeed, 0);
            }
        }
        if (this.isMovingLeft) {
            if(this.characterImage.getX() - movementSpeed >= 0) {
                this.characterImage.translate(-movementSpeed, 0);
                this.weapon.getWeaponImage().translate(-movementSpeed, 0);
            }
        }
        if (this.isJumping) {
            jump();
        }
    }

    @Override
    public Picture getPicture() {
        return characterImage;
    }


    public void jump() {
        if (this.isComingDown) {
            this.characterImage.translate(0, this.movementSpeed);
            this.weapon.getWeaponImage().translate(0, this.movementSpeed);

            if (this.characterImage.getY() >= this.groundedPoisition) {
                // force put player in grounded position just in case
                int distanceToGroundedPosition = this.characterImage.getY() - this.groundedPoisition;
                this.characterImage.translate(0, -distanceToGroundedPosition);

                this.initialJumpPosition = this.groundedPoisition;
                this.isJumping = false;
                this.isComingDown = false;
                this.activeJumps = 0;
            }

            return;
        }

        if (this.characterImage.getY() < this.initialJumpPosition - MAXJUMPHEIGHT ) {
            this.isComingDown = true;
            return;
        }

        this.characterImage.translate(0, -movementSpeed);
        this.weapon.getWeaponImage().translate(0, -movementSpeed);
    }

    public void reset() {
        this.characterImage = new Picture();
        this.characterImage.load("src/io/codeforall/forsome/characters/images/emanuel_resized.png");

        this.groundedPoisition = this.grid.getHeight() - this.characterImage.getHeight();
        this.characterImage.translate(0, this.groundedPoisition);

        this.weapon = WeaponFactory.createWeapon(characterImage.getX(),characterImage.getY());

        this.isDead = false;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void increaseSpeed() {
        this.movementSpeed = 20;
    }



    @Override
    public void kill() {
        this.isDead = true;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    private void incrementJump() {
        this.activeJumps++;
        this.initialJumpPosition = this.characterImage.getY();
        this.isJumping = true;
        this.isComingDown = false;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();


        if (key == KeyboardEvent.KEY_RIGHT) {
            this.isMovingRight = true;
        }

        if (key == KeyboardEvent.KEY_LEFT) {
            this.isMovingLeft = true;
        }

        if(key == KeyboardEvent.KEY_SPACE) {
            this.weapon.shoot();
        }

        if (key == KeyboardEvent.KEY_UP) {
            if(this.activeJumps < MAXJUMPS) {
                incrementJump();
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        if (key == KeyboardEvent.KEY_RIGHT) {
            this.isMovingRight = false;
        }
        if (key == KeyboardEvent.KEY_LEFT) {
            this.isMovingLeft = false;
        }
    }
}
