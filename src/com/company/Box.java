package com.company;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Box extends JPanel{
    private int levels;
    public Box(int lev) {
        levels = lev;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int x = xCenter - 243;
        int y = yCenter - 243;
        int width = 486;
        int height = 486;

        g.setColor(Color.blue);
        drawAndSplit(g, x, y, width, height, 1);
    }

    public void drawAndSplit(Graphics g, int x, int y, int width, int height, int times) {
        if(times < levels) {
            drawAndSplit(g, x, y, width/3, height/3, times + 1);
            drawAndSplit(g, x + width/3, y + height/3, width/3, height/3, times + 1);
            drawAndSplit(g, x + 2*width/3, y, width/3, height/3, times + 1);
            drawAndSplit(g, x, y + 2*height/3, width/3, height/3, times + 1);
            drawAndSplit(g, x + 2*width/3, y + 2*height/3, width/3, height/3, times + 1);
        }else{
            g.fillRect(x, y, height, width);
        }

    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box panel = new Box(6);
        panel.setBackground(Color.lightGray);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}