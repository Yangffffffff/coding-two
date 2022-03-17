package com.le.obj;

import com.le.GameWin;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GameObj {
    Image img;
    int x;
    int y;
    int width;
    int height;
    double speed;
    GameWin frame;

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getFramel() {
        return frame;
    }

    public void setFramel(GameWin frame) {
        this.frame = frame;
    }

    public GameObj() {
    }

    public GameObj(Image img, int x, int y, int width, int height, double speed, GameWin framel) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = framel;
    }

    public GameObj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void paintSelf(Graphics gImage){
        gImage.drawImage(img, x, y, null);
    }

    public Rectangle getRec(){
        return new Rectangle(x, y, width, height);
    }
}
