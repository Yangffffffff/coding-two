package com.le.obj;

import com.le.GameWin;
import com.le.utils.GameUtils;
import groovy.util.logging.Log;

import java.awt.*;

public class ObstacleObj extends GameObj{
    public ObstacleObj() {
    }

    public ObstacleObj(Image img, int x, int y, int width, int height, double speed, GameWin framel) {
        super(img, x, y, width, height, speed, framel);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;

        if(this.getRec().intersects(this.frame.ballObj.getRec())){
            GameWin.state = 2;
        }

        if(this.getY() >= 600){
            GameUtils.removeObjList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
