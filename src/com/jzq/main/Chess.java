package com.jzq.main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @Author: JZQ
 * @Date: 2023/11/20 16:43
 * @Description:
 */
public class Chess {
    //定义一个常量，只能在定义时或代码块中修改值，其他不允许修改
    //棋子大小
    private final int SIZE = 30;
    //棋盘外边距
    private final int MARGIN = 20;
    //棋子间距
    private final int SPACE = 40;
    //棋子名称
    private String name;
    //棋子图片后缀
    private final String suffix = ".png"; //若为public修饰，则违反了java面向对象三大特性之一的封装性，使用set和get方法
    //棋子阵营，0：红，1：黑
    private int player;
    //棋子绘制时的实际坐标位置
    private int x, y;
    //棋子的网格坐标
    private Point p;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 棋子的绘制方法
     * @param g
     * @param panel
     */
    public void draw(Graphics g, JPanel panel){
        String path = "picture" + File.separator + this.name + this.player + this.suffix;
        Image img = Toolkit.getDefaultToolkit().getImage(path);
        g.drawImage(img, this.x, this.y, this.SIZE, this.SIZE, panel);

    }

    /**
     * 计算xy的绘制坐标
     */
    public void calXY(){
        this.x = this.MARGIN - this.SIZE / 2 * (this.p.x - 1);
        this.y = this.MARGIN - this.SIZE / 2 * (this.p.y - 1);

    }

    public static void main(String[] args) {
        Point p = new Point();
        System.out.println(p.x);
    }
}
