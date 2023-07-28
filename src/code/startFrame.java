package code;

import javax.swing.*;
import java.awt.*;


public class startFrame extends JFrame {
    static startFrame s;
    Help help = new Help();
    public startFrame(){
        this.setTitle("Fishing Joy");
        this.setSize(1200,676);
        init();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    void init(){
        JButton startB = new JButton("START");
        JButton helpB = new JButton("HELP");


        startB.addActionListener(e -> {
            setVisible(false);
            Game.createGame(new Game(),60);
        });
        helpB.addActionListener(e -> {
            help.setVisible(true);
        });

        startB.setBounds(500,376,200,50);
        startB.setBorderPainted(false);
        startB.setFocusPainted(false);
        startB.setForeground(Color.blue);
        startB.setFont(new Font("黑体",Font.LAYOUT_LEFT_TO_RIGHT,30));

        helpB.setBounds(500,475,200,50);
        helpB.setBorderPainted(false);
        helpB.setFocusPainted(false);
        helpB.setForeground(Color.blue);
        helpB.setFont(new Font("黑体",Font.LAYOUT_LEFT_TO_RIGHT,30));
        this.add(helpB);
        this.add(startB);

    }

    public static void main(String[] args){
        s = new startFrame();
        s.add(new startPanel());
        s.setVisible(true);
    }


}
