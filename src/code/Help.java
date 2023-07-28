package code;

import javax.swing.*;
import java.awt.*;


public class Help extends JFrame{

    public Help() {
        init();
        this.setResizable(false);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    void init() {
        this.setTitle("Help");
        this.setBounds(100, 50, 1200, 675);
        this.setLayout(null);
        Font font = new Font("font2",Font.PLAIN,40);
        JLabel title = new JLabel("Illustrated Handbook");
        ImageIcon gold = new ImageIcon("src/resource/gold/gold01.png");
        ImageIcon bg = new ImageIcon("src/resource/helpbg.png");
        ImageIcon fish1 = new ImageIcon("src/resource/fish/fish01_1.png");
        ImageIcon fish2 = new ImageIcon("src/resource/fish/fish02_1.png");
        ImageIcon fish3 = new ImageIcon("src/resource/fish/fish03_1.png");
        ImageIcon fish4 = new ImageIcon("src/resource/fish/fish04_1.png");
        ImageIcon fish5 = new ImageIcon("src/resource/fish/fish05_1.png");
        ImageIcon fish6 = new ImageIcon("src/resource/fish/fish06_1.png");
        ImageIcon fish7 = new ImageIcon("src/resource/fish/fish07_1.png");
        ImageIcon fish8 = new ImageIcon("src/resource/fish/fish08_1.png");
        ImageIcon fish9 = new ImageIcon("src/resource/fish/fish09_1.png");
        ImageIcon fish10 = new ImageIcon("src/resource/fish/fish010_1.png");
        ImageIcon fish11 = new ImageIcon("src/resource/fish/fish011_1.png");
        JLabel picture01 = new JLabel(gold);
        JLabel picture02 = new JLabel(gold);
        JLabel picture03 = new JLabel(gold);
        JLabel picture04 = new JLabel(gold);
        JLabel picture05 = new JLabel(gold);
        JLabel picture06 = new JLabel(gold);
        JLabel picture07 = new JLabel(gold);
        JLabel picture08 = new JLabel(gold);
        JLabel picture09 = new JLabel(gold);
        JLabel picture010 = new JLabel(gold);
        JLabel picture011 = new JLabel(gold);
        JLabel picture1 = new JLabel(bg);
        JLabel picture2 = new JLabel(fish1);
        JLabel picture3 = new JLabel(fish2);
        JLabel picture4 = new JLabel(fish3);
        JLabel picture5 = new JLabel(fish4);
        JLabel picture6 = new JLabel(fish5);
        JLabel picture7 = new JLabel(fish6);
        JLabel picture8 = new JLabel(fish7);
        JLabel picture9 = new JLabel(fish8);
        JLabel picture10 = new JLabel(fish9);
        JLabel picture11 = new JLabel(fish10);
        JLabel picture12 = new JLabel(fish11);
        JLabel fishyi = new JLabel("2");
        JLabel fisher = new JLabel("4");
        JLabel fishsan = new JLabel("7");
        JLabel fishsi = new JLabel("10");
        JLabel fishwu = new JLabel("10");
        JLabel fishliu = new JLabel("20");
        JLabel fishqi = new JLabel("25");
        JLabel fishba = new JLabel("40");
        JLabel fishjiu = new JLabel("50");
        JLabel fishshi = new JLabel("100");
        JLabel fishshiyi = new JLabel("30");
        title.setForeground(Color.BLUE);
        title.setFont(font);
        fishyi.setForeground(Color.yellow);
        fishyi.setFont(font);
        fisher.setForeground(Color.yellow);
        fisher.setFont(font);
        fishsan.setForeground(Color.yellow);
        fishsan.setFont(font);
        fishsi.setForeground(Color.yellow);
        fishsi.setFont(font);
        fishwu.setForeground(Color.yellow);
        fishwu.setFont(font);
        fishliu.setForeground(Color.yellow);
        fishliu.setFont(font);
        fishqi.setForeground(Color.yellow);
        fishqi.setFont(font);
        fishba.setForeground(Color.yellow);
        fishba.setFont(font);
        fishjiu.setForeground(Color.yellow);
        fishjiu.setFont(font);
        fishshi.setForeground(Color.yellow);
        fishshi.setFont(font);
        fishshiyi.setForeground(Color.yellow);
        fishshiyi.setFont(font);

        picture1.setBounds(0,0,1200,675);
        title.setBounds(400, 190,400,35);

        picture2.setBounds(100,260,50,50);
        fishyi.setBounds(90,300,50,50);
        picture01.setBounds(110,300,50,50);

        picture3.setBounds(270,260,55,50);
        fisher.setBounds(260,300,50,50);
        picture02.setBounds(280,300,50,50);

        picture4.setBounds(440,260,73,50);
        fishsan.setBounds(430,300,50,50);
        picture03.setBounds(450,300,50,50);

        picture5.setBounds(610,260,93,50);
        fishsi.setBounds(600,300,50,50);
        picture04.setBounds(645,300,50,50);

        picture6.setBounds(790,260,58,50);
        fishwu.setBounds(780,300,50,50);
        picture05.setBounds(825,300,50,50);

        picture7.setBounds(970,260,93,50);
        fishliu.setBounds(960,300,50,50);
        picture06.setBounds(1005,300,50,50);

        picture8.setBounds(155,410,89,50);
        fishqi.setBounds(145,465,50,50);
        picture07.setBounds(190,465,50,50);

        picture9.setBounds(315,410,88,63);
        fishba.setBounds(315,465,50,50);
        picture08.setBounds(360,465,50,50);

        picture10.setBounds(455,410,160,64);
        fishjiu.setBounds(485,465,50,50);
        picture09.setBounds(530,465,50,50);

        picture11.setBounds(665,390,303,110);
        fishshi.setBounds(715,510,80,50);
        picture010.setBounds(785,510,50,50);

        picture12.setBounds(1030,410,92,56);
        fishshiyi.setBounds(1025,465,50,50);
        picture011.setBounds(1070,465,50,50);

        this.add(picture1);
        picture1.add(title);
        picture1.add(picture2);
        picture1.add(picture3);
        picture1.add(picture4);
        picture1.add(picture5);
        picture1.add(picture6);
        picture1.add(picture7);
        picture1.add(picture8);
        picture1.add(picture9);
        picture1.add(picture10);
        picture1.add(picture11);
        picture1.add(picture12);
        picture1.add(fishyi);
        picture1.add(fisher);
        picture1.add(fishsan);
        picture1.add(fishsi);
        picture1.add(fishwu);
        picture1.add(fishliu);
        picture1.add(fishqi);
        picture1.add(fishba);
        picture1.add(fishjiu);
        picture1.add(fishshi);
        picture1.add(fishshiyi);
        picture1.add(picture01);
        picture1.add(picture02);
        picture1.add(picture03);
        picture1.add(picture04);
        picture1.add(picture05);
        picture1.add(picture06);
        picture1.add(picture07);
        picture1.add(picture08);
        picture1.add(picture09);
        picture1.add(picture09);
        picture1.add(picture010);
        picture1.add(picture011);
    }
}
