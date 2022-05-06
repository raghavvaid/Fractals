package com.company;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Seripinski_Triangle extends JPanel{
    private int levels;
    public Seripinski_Triangle(int lev) {
        levels = lev;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        int [] xcoord = {xCenter - 128, xCenter-128, xCenter + 128, xCenter + 128};
        int [] ycoord = {yCenter-128, yCenter + 128, yCenter + 128, yCenter - 128};

        g.setColor(Color.yellow);
        drawAndSplit(g, xcoord, ycoord, 1);

    }

    public int [] midpoints(int [] x) {
        int [] m = new int [4];

        m[0] = (x[0] + x[1])/2;
        m[1] = (x[1] + x[2])/2;
        m[2] = (x[2] + x[3])/2;
        m[3] = (x[3] + x[0])/2;

        return m;
    }

    public void drawAndSplit(Graphics g, int [] x, int [] y, int times) {
        g.drawPolygon(x, y, 4);
        if (times < levels) {
            drawAndSplit(g,midpoints(x), midpoints(y), times+1);
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SquareRose panel = new SquareRose(8);
        panel.setBackground(Color.darkGray);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}
