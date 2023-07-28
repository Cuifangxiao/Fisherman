package code;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game extends GameEngine{
    BufferedImage bg = (BufferedImage) loadImage("src/resource/WinLayerBg.png");
    ArrayList<Fish> fish = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Gold> golds = new ArrayList<>();
    ArrayList<Net> nets = new ArrayList<>();
    Cannon cannon = new Cannon(Game.this);
    int mouseX,mouseY;
    double theta;


    int gold;
    int score;
    AudioClip bgMusic = loadAudio("src/resource/GameLayerBGM.wav");


    @Override
    public void init() {
        score=0;
        gold=20;
        fish.clear();
        golds.clear();
        nets.clear();
        setWindowSize(1200,675);
        for (int i = 0; i < 30; i++) {
            fish.add(new Fish(Game.this));
        }
        startAudioLoop(bgMusic);
        bullets.clear();
        golds.clear();
    }


    @Override
    public void update(double dt) {
        if(score<10000) {
            if (gold != 0 || bullets.size() != 0) {
                for (int i = 0; i < fish.size(); i++) {
                    if (fish.get(i).getCatch()) {
                        fish.get(i).turnOver();
                    } else fish.get(i).move();
                }
                for (int i = 0; i < golds.size(); i++) {
                    golds.get(i).move();
                }
                for (int i = 0; i < bullets.size(); i++) {
                    bullets.get(i).move();
                }
                for(int i = 0;i<nets.size();i++){
                    nets.get(i).move();
                }
            }
        }
    }


    @Override
    public void paintComponent() {
        drawImage(bg,0,0);
        changeColor(white);
        drawText(350,625,"Score:  "+score);
        drawText(750,625,"Gold: "+gold);


        for(int i=0;i<fish.size();i++){
            Fish f = fish.get(i);
            drawImage(f.image,f.getX(),f.getY(),f.getWidth(),f.getHeight());
        }
        double centerX = cannon.getX() + (double)cannon.getWidth()/2;
        double centerY = cannon.getY() + (double)cannon.getHeight()/4*3;
        double xx = mouseX - centerX;
        double yy = mouseY - centerY;
        theta = -Math.atan(xx/yy);
        Graphics2D graphics2d = (Graphics2D) mGraphics.create();
        graphics2d.rotate(theta,centerX,centerY);
        graphics2d.drawImage(cannon.getImage(),cannon.getX(),cannon.getY(),cannon.getWidth(),cannon.getHeight(),null);
        
        if(bullets.size()>0) {
            for (Bullet bullet : bullets) {
                if (bullet != null) {
                    Graphics2D graphics2D2 = (Graphics2D) mGraphics.create();
                    graphics2D2.rotate(bullet.getTheta(), centerX, centerY);
                    graphics2D2.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight(), null);
                }
            }
        }

        for (int i = 0; i < golds.size(); i++) {
            Gold gold = golds.get(i);
            drawImage(gold.getImage(),gold.getX(),gold.getY(),gold.width,gold.getHeight());
            changeColor(yellow);
            drawText(gold.getX()+50,gold.getY()+30,"+"+gold.price);
        }

        for (int i = 0; i < nets.size(); i++) {
            Net net = nets.get(i);
            drawImage(net.getImage(),net.getX(),net.getY());
        }

        if(score>=10000){
            changeColor(red);
            drawText(200,400,"You Success, Press space to start again!");
        }
        if(gold==0 && bullets.size()==0){
            changeColor(red);
            drawText(200,400,"You Failed, Press space to start again!");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && (score>=1000 || gold<=0)){
            stopAudioLoop(bgMusic);
            init();
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            mFrame.dispose();
            stopAudioLoop(bgMusic);
            startFrame.s.setVisible(true);
        }
        switch (e.getKeyChar()) {
            case '1' -> {
                cannon.change(1);
            }
            case '2' -> {
                cannon.change(2);
            }
            case '3'  -> {
                cannon.change(3);
            }
            case '4'  -> {
                cannon.change(4);
            }
            case '5' -> {
                cannon.change(5);
            }
            case '6' -> {
                cannon.change(6);
            }
            case '7' -> {
                cannon.change(7);
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if((bullets.size()!=0 || gold!=0) && score<=10000) {
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        if(gold>=cannon.getPower()) {
            Bullet bullet = new Bullet(cannon.getX() + 25, cannon.getY(), theta, Game.this, cannon.getPower());
            bullets.add(bullet);
            gold -= cannon.getPower();
            AudioClip shootMusic = loadAudio("src/resource/shoot.wav");
            playAudio(shootMusic);
        }

    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(ArrayList<Bullet> bullets) {
        this.bullets = bullets;
    }
}
