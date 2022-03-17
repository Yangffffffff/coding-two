package com.le.obj;

import com.le.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BallObj extends GameObj{
    public BallObj() {
    }

    public BallObj(Image img, int x, int y, int width, int height, double speed, GameWin framel) {
        super(img, x, y, width, height, speed, framel);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                BallObj.super.x = e.getX() - width / 2;
                BallObj.super.y = e.getY() - height / 2;
            }
        });
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
