package com.le.utils;

import com.le.obj.GameObj;
import com.le.obj.ObstacleObj;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    public static Image bgImage = Toolkit.getDefaultToolkit().getImage("imgs/bg.png");
    public static Image ballImage = Toolkit.getDefaultToolkit().getImage("imgs/ball.png");
    public static Image obstacleImage = Toolkit.getDefaultToolkit().getImage("imgs/obstacle.png");

    public static List<GameObj> gameObjList = new ArrayList<GameObj>();
    public static List<ObstacleObj> obstacleObjList = new ArrayList<ObstacleObj>();
    public static List<GameObj> removeObjList = new ArrayList<GameObj>();
    public static void drawWord(Graphics gImage, String str, Color color, int size, int x, int y){
        gImage.setColor(color);
        gImage.setFont(new Font("微软雅黑", Font.BOLD, size));
        gImage.drawString(str, x, y);
    }
}
