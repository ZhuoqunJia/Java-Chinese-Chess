package com.jzq.main;

/**
 * @Author: JZQ
 * @Date: 2023/11/8 11:37
 * @Description:
 */

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 在swing编程中面板是指JPanel这个类
 *     在JFrame自带有一个面板，但那个面板有bug
 * 关于java的继承
 *     格式：
 *         public class 子类名 extends 父类名
 *     注意：
 *         1、子类是必须先存在的
 *         2、子类只能继承父类中的非私有（private）修饰的属性和方法
 *         3、父类中私有的属性和方法不能被子类继承
 *     方法重写：只针对于实例方法，不针对实例变量
 *         1、子类重新定义父类中的同名方法，必须一模一样
 *         2、重写方法不能比被重写方法限制有更严格的访问级别
 *         3、形参列表必须与被重写方法的相同
 *         4、返回类型必须与被重写方法的返回类型相同
 *         5、重写方法不能抛出新的异常或者比被重写方法声明的检查异常更广泛的检查异常
 *         6、不能重写被表示为final的方法
 *         7、如果一个方法不能被继承，则不能重写它，例如private 私有方法
 *         8、子类不能用 静态方法 重写父类的非静态方法
 *         9、子类不能用 非静态方法  重写  父类的静态方法
 *
 */
public class GamePanel extends JPanel {
    @Override //重写注解
    //如果该方法是重写父类中的方法，加不加都不会报错
    //但是如不是重写父类中的中方法，加上就会报错
    public void paint(Graphics g) {
        //super.paint(g); //删除或注释即可
        /**
         * paint方法是JPanel类中绘制面板内容的实例方法
         * Graphics；绘制类，是一个抽象类
         * 常用实例方法：
         *     drawImage(): 画图片
         *     drawChars(): 画文字
         *     drawLine(): 画直线的
         *     drawOval(): 画圆或椭圆
         *
         * 如何在JPane画一张图
         *     1、准备图片路径
         *          File.separator: 路径分隔符
         *              Windows系统：\，反斜杠
         *              Linux和macos系统：/，斜杠
         *     2、通过图片路径得到图片对象
         *     3、使用g.drawImage()方法将图片绘制到面板上
         */
        //1、准备图片路径
        String backGroundPicture = "picture" + File.separator + "qipan.jpg";
        //System.out.println(backGroundPicture); //picture\qipan.jpg
        System.out.println("每拖动一次窗口，就会在画板上重新画一次");
        //2、通过图片路径得到图片对象
        /**
         * getDefaultToolkit(): Toolkit类中的静态方法，用于获取Toolkit类型的实例对象
         * 获取实例对象并不止通过new 的方式，还可以通过方法来获取实例对象
         *
         * Toolkit实例对象常用实例方法：
         *     createImage(): 创建图片
         *     getImage(): 获取图片
         */
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image bgImg = toolkit.getImage(backGroundPicture);
        //3、使用g.drawImage方法将图片绘制到面板上
        /**
         * boolean drawImage(Image img, int x, int y, ImageObserver observer)
         * img: 要绘制的图片对象
         * x: 坐标x，在编程中坐标都是从左上角开始的，到右下角，往右是正数
         * y: 坐标y，往下是正数
         * observer: 图片观察者，写JPanel对象即可，如上写this，表示就是当执行该行代码时的对象
         */
        g.drawImage(bgImg, 0, 0, this);


        //如何画棋子
        /**
         * 画红棋：车
         */
        //1、准备图片路径
        String che0Path = "picture" + File.separator + "che0.png";
        //2、通过图片路径得到图片对象
        Image che0Img = Toolkit.getDefaultToolkit().getImage(che0Path);
        //3、使用g.drawImage方法将图片绘制到面板上
        g.drawImage(che0Img, 5, 5, 30,30,this);

        /**
         * 画红棋：马
         */
        //1、准备图片路径
        String ma0Path = "picture" + File.separator + "ma0.png";
        //2、通过图片路径得到图片对象
        Image ma0Img = Toolkit.getDefaultToolkit().getImage(ma0Path);
        //3、使用g.drawImage方法将图片绘制到面板上
        g.drawImage(ma0Img, 45, 5, 30,30,this);

        /**
         * 画红棋：象
         */
        String xiang0Path = "picture" + File.separator + "xiang0.png";
        Image xiang0Image = Toolkit.getDefaultToolkit().getImage(xiang0Path);
        g.drawImage(xiang0Image, 85, 5, 30,30,this);







    }

    public static void main(String[] args) {
//        String backGroundPicture = "picture" + File.separator + "qipan.jpg";
//        System.out.println(backGroundPicture);
        System.out.println(111);
    }
}
