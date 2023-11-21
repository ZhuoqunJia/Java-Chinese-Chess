package com.jzq.main;

/**
 * @Author: JZQ
 * @Date: 2023/11/8 11:37
 * @Description:
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class GamePanel extends JPanel {
    //定义一个保存所有棋子的成员变量，变量值类型为数组
    private Chess[] chesses = new Chess[32]; //保存所有的棋子
    //当前选中的棋子
    private Chess selectedChess;

    //构造方法
    //无参构造方法：权限修饰符 类名(){}
    //构造方法，可以让我们自定义创建对象时，做一些必要的操作
    public GamePanel(){
        //super(); //调用父类构造方法，每个类的构造方法中，都隐藏有这一行代码，且必须是第一行
        System.out.println("调用GamePanel的无参构造方法！");
//        super(); 必须在构造方法的第一行
        this.createChesses();
        /**
         * 如何操作棋子
         *      1、点击棋盘
         *      2、如何判断点击的地方是否有棋子
         *      3、如何区分第一次选择，重新选择，移动，吃子
         */
        //添加点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                System.out.println("点击棋盘的坐标为：x=" + e.getX() + ",y=" + e.getY());
                Point p = Chess.getPointFromXY(e.getX(), e.getY());
                System.out.println("点击棋子对象的棋盘的网格坐标对象为：p===" + p);

                if(null == selectedChess){
                    //第一次选择
                    selectedChess = getChessByP(p);
                    System.out.println("第一次选择");
                }else {
                    //重新选择，移动，吃子
                    Chess c = getChessByP(p);
                    if(null != c){
                        //第n次点击的时候有棋子
                        //重新选择，吃子
                        if(c.getPlayer() == selectedChess.getPlayer()){
                            //重新选择
                            System.out.println("重新选择");
                        }else {
                            //吃子
                            System.out.println("吃子");
                        }
                    }else {
                        //第n次点击的时候没有棋子，点的是空白地方
                        //移动
                        System.out.println("移动");
                    }
                }
                System.out.println("点击的棋子对象为：selectedChess===" + selectedChess);
                System.out.println("============一个棋子对象的操作==============");
            }
        });
    }

    /**
     * 根据网格坐标p对象查找棋子对象
     * @param p
     * @return
     */
    private Chess getChessByP(Point p){
        for (Chess item:
             chesses) {
//            System.out.println(item.getP());
            if(item.getP().equals(p)){
                return item; //因为return关键字是结束方法的，所以也会导致循环提前终止
            }
        }
        return null;
    }


    /**
     * 创建所有棋子
     */
    private void createChesses(){
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
            this.chesses[i] = c; //将棋子保存到数组中
        }

        for (int i = 0; i < ps.length; i++) {
            Chess c = new Chess(); //创建棋子对象
            c.setName(names[i]); //指定棋子名称
            c.setP(ps[i]); //指定棋子的网格坐标
            c.reserve(); //反转网络坐标
            c.setPlayer(1); //这是棋子阵营
            this.chesses[i + 16] = c; //将棋子保存到数组中
        }
    }

    /**
     * 绘制所有棋子
     * @param g
     */
    private void drawChesses(Graphics g){
        for (Chess item:
             chesses) {
            item.draw(g, this);
        }
    }

    /**
     * 有一个问题，paint方法又是创建，绘制，保存数据到数组，一共做了三个事情
     * paint方法正常来说应该只做绘制棋子这一件事情
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override //重写注解
    public void paint(Graphics g) {
        //super调用父类中的方法
//        super.paint(g); //清除原来的痕迹
        String backGroundPicture = "picture" + File.separator + "qipan.jpg";
        System.out.println("每拖动一次窗口，就会在画板上重新画一次");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image bgImg = toolkit.getImage(backGroundPicture);
        g.drawImage(bgImg, 0, 0, this);

        this.drawChesses(g);
    }
}
