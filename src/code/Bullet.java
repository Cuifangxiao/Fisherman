package code;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Bullet{
    private BufferedImage image;
    private ArrayList<BufferedImage> bufferedImages = new ArrayList<>();
    private int x;
    private int y;
    private int width;
    private int height;
    private int step;
    private double theta;
    private Point point;
    private Game panel;
    int power;
    int hurt;
    Random r = new Random();

    public Bullet(int x,int y,Double theta,Game panel,int power){
        String bulletName = "src/resource/bullet/bullet0" + power +".png";
        step = 50/2;
        this.power = power;
        image = (BufferedImage) panel.loadImage(bulletName);
        width = image.getWidth();
        height = image.getHeight();
        this.theta = theta;
        this.point = new Point(x, y);
        this.x = x;
        this.y = y;
        this.panel = panel;



        switch (power) {
            case 1 -> {
                hurt = 10;
                if(r.nextInt(100) <= 4){
                    hurt = 20;
                }
                if(r.nextInt(100) <= 3){
                    hurt = 999;
                }
            }
            case 2 -> {
                hurt = 11+r.nextInt(3);
                if(r.nextInt(100) <= 5){
                    hurt*=2;
                }
                if(r.nextInt(200) <=8){
                    hurt = 999;
                }
            }
            case 3  -> {
                hurt = 12+r.nextInt(3);
                if(r.nextInt(100) <= 6){
                    hurt*=2;
                }
                if(r.nextInt(100) <= 4){
                    hurt = 999;
                }
            }
            case 4  -> {
                hurt = 13 +r.nextInt(3);
                if(r.nextInt(100) <= 7){
                    hurt*=2;
                }
                if(r.nextInt(200) <=10){
                    hurt = 999;
                }
            }
            case 5 -> {
                hurt = 14 + r.nextInt(3);
                if(r.nextInt(200) <= 16){
                    hurt*=2;
                }
                if(r.nextInt(100) <=5){
                    hurt = 999;
                }
            }
            case 6 -> {
                hurt = 15 + r.nextInt(3);
                if(r.nextInt(100) <= 9){
                    hurt*=2;
                }
                if(r.nextInt(200) <=12){
                    hurt = 999;
                }
            }
            case 7 -> {
                hurt = 16 + r.nextInt(3);
                if(r.nextInt(200) <= 18){
                    hurt*=2;
                }
                if(r.nextInt(100) <= 6){
                    hurt = 999;
                }
            }
        }
    }

    public void move(){
        this.y = this.y - this.step;
        int distance = this.point.y - this.y;
        //求xx,需要进一步进行强制转换
        int xx = (int) (distance * Math.sin(theta));
        int xxx = this.point.x + xx;
        //求yy坐标
        int yy = (int) (distance * Math.cos(theta));
        int yyy = this.point.y - yy;
        // Determine if it is out of bounds
        if (xxx < 0 || xxx > 1200 || yyy < 0) {
            // Delete bullets in the array
            panel.getBullets().remove(this);
        }

        ArrayList<Fish> fishs = panel.fish;
        for (Fish fish : fishs) {
            if(!fish.getCatch()) {
                // Range of x-coordinates of fish
                int maxX = fish.getX() + fish.getWidth();
                // Range of y-coordinate of fish
                int mayY = fish.getY() + fish.getHeight();
                if (xxx > fish.getX() - 10 && xxx < maxX + 10 && fish.getY() - 10 < yyy && yyy < mayY + 10) {
                    Net net = new Net(xxx,yyy,power,panel);
                    net.setOldTime(panel.getTime());
                    panel.nets.add(net);
                    //Setting the fish to be caught
                    if( hurt >= fish.getBlood()) {
                        fish.setOldTime(panel.getTime());
                        panel.score+=fish.getScore();
                        fish.setCatch(true);
                        GameEngine.AudioClip catchMusic = panel.loadAudio("src/resource/catch.wav");
                        panel.playAudio(catchMusic);
                        panel.gold+= fish.getGold();
                        Gold gold = new Gold(xxx,yyy,panel, fish.getGold());
                        panel.golds.add(gold);
                    }
                    // Delete bullets in the array
                    panel.getBullets().remove(this);
                }
            }
        }
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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
