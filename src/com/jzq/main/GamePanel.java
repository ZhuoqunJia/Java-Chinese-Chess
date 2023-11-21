package com.jzq.main;

/**
 * @Author: JZQ
 * @Date: 2023/11/8 11:37
 * @Description:
 */

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GamePanel extends JPanel {
    //定义一个保存所有棋子的成员变量，变量值类型为数组
    private Chess[] chesses = new Chess[32]; //保存所有的棋子

    @Override //重写注解
    public void paint(Graphics g) {
        String backGroundPicture = "picture" + File.separator + "qipan.jpg";
        System.out.println("每拖动一次窗口，就会在画板上重新画一次");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image bgImg = toolkit.getImage(backGroundPicture);
        g.drawImage(bgImg, 0, 0, this);

        String[] names = new String[]{"che", "ma", "xiang", "shi", "boss", "shi", "xiang", "ma", "che",
                                "pao", "pao",
                                "bing", "bing", "bing", "bing", "bing"};
        Point[] ps = {
                new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(4, 1), new Point(5, 1), new Point(6, 1), new Point(7, 1), new Point(8, 1), new Point(9, 1),
                new Point(2, 3), new Point(8, 3),
                new Point(1, 4), new Point(3, 4), new Point(5, 4), new Point(7, 4), new Point(9, 4)
        };

        for (int i = 0; i < ps.length; i++) {
            Chess c = new Chess(); //创建棋子对象
            c.setName(names[i]); //指定棋子名称
            c.setP(ps[i]); //指定棋子的网格坐标
            c.setPlayer(0); //这是棋子阵营
            c.draw(g, this); //绘制棋子
        }

        for (int i = 0; i < ps.length; i++) {
            Chess c = new Chess(); //创建棋子对象
            c.setName(names[i]); //指定棋子名称
            c.setP(ps[i]); //指定棋子的网格坐标
            c.reserve(); //反转网络坐标
            c.setPlayer(1); //这是棋子阵营
            c.draw(g, this); //绘制棋子
        }
    }
}
