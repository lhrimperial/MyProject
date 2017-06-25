package com.handy.frame.design.adapter;

import javax.swing.*;
import java.awt.*;

/**
 * @author longhairen
 * @create 2017-06-25 15:58
 * @description
 **/
public class ShowRocketTable {

    public static void main(String[] args) {
        setFonts();
        JTable jTable = new JTable(getRocketTable());
        jTable.setRowHeight(36);
        JScrollPane pane = new JScrollPane(jTable);
        pane.setPreferredSize(new Dimension(300,100));
        display(pane,"Rockets");
    }

    public static void display(Component c , String title){
        JFrame jFrame = new JFrame(title);
        jFrame.getContentPane().add(c);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private static RocketTable getRocketTable(){
        Rocket rocket1 = new Rocket("Shooter", "$39", "4.5");
        Rocket rocket2 = new Rocket("Orbit", "$29.0", "2.0");
        return new RocketTable(new Rocket[]{rocket1, rocket2});
    }

    private static void setFonts(){
        Font font = new Font("Dialog", Font.PLAIN, 18);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
    }
}
