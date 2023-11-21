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
    private static final int SIZE = 30;
    //棋盘外边距
    private static final int MARGIN = 20;
    //棋子间距
    private static final int SPACE = 40;
    //棋子名称
    private String name; //若为public修饰，则违反了java面向对象三大特性之一的封装性，使用set和get方法


    //棋子图片后缀
    private static final String SUFFIX = ".png";
    //棋子阵营，0：红，1：黑
    private int player;
    //棋子绘制时的实际坐标位置
    private int x, y;
    //棋子的网格坐标
    private Point p;
    //棋子的网格坐标，初始位置，不可改变
//    private Point initP;
    //保存每个棋子的索引位置
//    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

//    public int getIndex() {
//        return index;
//    }
//
//    public void setIndex(int index) {
//        this.index = index;
//    }

    public void setP(Point p) {
//        this.p = (Point) p.clone();
//        if (initP == null) {
//            initP = this.p;
//        }
//        calXY();

        //克隆一个新的Point对象
        this.p = (Point) p.clone();
        this.calXY();
    }

    public Point getP() {
        return this.p;
    }

    /**
     * 棋子的绘制方法
     * @param g
     * @param panel
     */
    public void draw(Graphics g, JPanel panel){
        String path = "picture" + File.separator + this.name + this.player + Chess.SUFFIX;
        Image img = Toolkit.getDefaultToolkit().getImage(path);
        //画图片的时候，是以图片的左上角为基准变进行绘制的
        g.drawImage(img, this.x, this.y, Chess.SIZE, Chess.SIZE, panel);
    }

    /**
     * 计算xy的绘制坐标
     */
    public void calXY(){
        this.x = (Chess.MARGIN - Chess.SIZE / 2) + Chess.SPACE * (this.p.x - 1);
        this.y = (Chess.MARGIN - Chess.SIZE / 2) + Chess.SPACE * (this.p.y - 1);
    }

    /**
     * 根据xy坐标计算网格坐标对象
     * @param x
     * @param y
     *
     * static：静态关键字
     *      修饰方法：称为类方法或静态方法
     *          如何调用
     *              实例.方法()或类名.方法()
     *          注意：类方法只能使用类属性
     *      修饰属性：称为类属性或静态属性
     *          如何调用
     *              实例.属性名 或 类名.属性名
     *          注意：静态属性只有一个共用的内存地址，所以不管有多少个对象，只需要修改一次，其他对象都会受影响
     */
    public static Point getPointFromXY(int x, int y){
        Point p = new Point();
        p.x = (x - (Chess.MARGIN - Chess.SIZE / 2)) / Chess.SPACE + 1;
        p.y = (y - (Chess.MARGIN - Chess.SIZE / 2)) / Chess.SPACE + 1;
        if(p.x < 1 || p.x > 9 || p.y < 1 || p.y > 10){
            return null;
        }
        return p;
//        return new Point((x - (this.MARGIN - this.SIZE / 2)) / this.SPACE + 1, (y - (this.MARGIN - this.SIZE / 2)) / this.SPACE + 1);

    }

    /**
     *反转网格坐标
     */
    public void reserve(){
        this.p.x = 10 - this.p.x;
        this.p.y = 11 - this.p.y;
//        this.initP = p;
        this.calXY();
    }

    public static void main(String[] args) {
        Point p = new Point();
        System.out.println(p.x);


    }
}
