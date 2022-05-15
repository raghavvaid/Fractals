package com.company;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Seripinski_Triangle extends JPanel {
    private int levels;
    public Seripinski_Triangle(int lev) {
        levels = lev;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        int [] xcoord = {xCenter - 128, xCenter, xCenter + 128};
        int [] ycoord = {yCenter, yCenter - 128, yCenter};

        g.setColor(Color.green);
        drawAndSplit(g, xcoord, ycoord, 1);
    }

    public int [] midpoints(int [] x) {
        int [] mid = new int [3];

        mid[0] = (x[0] + x[1])/2;
        mid[1] = (x[1] + x[2])/2;
        mid[2] = (x[2] + x[0])/2;

        return mid;
    }

    public void drawAndSplit(Graphics g, int [] x, int [] y, int times) {
        g.drawPolygon(x, y, 3);
        if(times < levels) {
            int [] newx = midpoints(x);
            int [] newy = midpoints(y);
            int [] x1 = {x[0], newx[0], newx[2]};
            int [] y1 = {y[0], newy[0], newy[2]};

            drawAndSplit(g, x1, y1, times + 1);

            int [] x2 = {newx[0], x[1], newx[1]};
            int [] y2 = {newy[0], y[1], newy[1]};

            drawAndSplit(g, x2, y2, times + 1);

            int [] x3 = {newx[2], newx[1], x[2]};
            int [] y3 = {newy[2], newy[1], y[2]};

            drawAndSplit(g, x3, y3, times + 1);
        }

    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Seripinski_Triangle panel = new Seripinski_Triangle(9);
        panel.setBackground(Color.darkGray);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}