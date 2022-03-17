package com.le;

import com.le.obj.BallObj;
import com.le.obj.BgObj;
import com.le.obj.GameObj;
import com.le.obj.ObstacleObj;
import com.le.utils.GameUtils;
import com.le.utils.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameWin extends JFrame {
    Music m = new Music("music/bgm.wav");
    int windowW = 600;
    int windowH = 600;
    int count = 1;
    public static int state = 0;
    public static int score = 0;
    Image offScreenImage = null;
    BgObj bgObjbj = new BgObj(GameUtils.bgImage, 0, -360, 2);
    public BallObj ballObj = new BallObj(GameUtils.ballImage, 240, 500, 20, 20, 0, this);
    public void launch() throws InterruptedException {
        this.setVisible(true);
        this.setSize(windowW, windowH);
        this.setLocationRelativeTo(null);
        this.setTitle("游戏");

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(state == 0 || state == 2){
                    m.start();
                    state = 1;
                    score = 0;
                    GameUtils.gameObjList = new ArrayList<GameObj>();
                    GameUtils.gameObjList.add(bgObjbj);
                    GameUtils.gameObjList.add(ballObj);
                    repaint();
                }
            }
        });

        GameUtils.gameObjList.add(bgObjbj);
        GameUtils.gameObjList.add(ballObj);
        while(true){
            repaint();
            try {
                Thread.sleep(40);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g){
        count++;

        if(offScreenImage == null) {
            offScreenImage = createImage(windowW, windowH);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0, 0, windowW, windowH);
        if(state == 0){
            GameUtils.drawWord(gImage, "START", Color.white, 40, 220, 300);
        } else if(state == 1){
            createObj();
            for(int i = 0; i < GameUtils.gameObjList.size(); i++){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            score = GameUtils.removeObjList.size();
            GameUtils.gameObjList.removeAll(GameUtils.removeObjList);
        } else if(state == 2){
            m.pause();
            GameUtils.drawWord(gImage, "GAME OVER", Color.red, 40, 170, 300);
        }
        GameUtils.drawWord(gImage, "SCORE:" + score, Color.green, 20, 20, 50);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    void createObj(){
        if(count % 15 == 0){
            GameUtils.obstacleObjList.add(new ObstacleObj(GameUtils.obstacleImage, (int)(Math.random()*12)*50, 0, 61, 61, 5, this));
            GameUtils.gameObjList.add(GameUtils.obstacleObjList.get(GameUtils.obstacleObjList.size() - 1));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GameWin win = new GameWin();
        win.launch();
    }
}
