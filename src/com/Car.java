package com;

import sun.awt.geom.AreaOp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {

    private String color;
    private int speed;
    private Integer seat;

    public void run() {
        System.out.println("车能跑。");
    }

    public static void main(String[] args) {
//        Car car = new Car();
//        car.setColor("黑色");
//        car.setSeat(4);
//        car.setSpeed(120);
//
//        car.run();

        String str = "1、武汉市东湖新技术开发区高新大道818号武汉高科医疗器械园B区21号楼1层3、4号；2、宜昌市高新区百灵路15号。";
        String[] split = str.split("；");
        System.out.println(split[0] + "------" + split[1]);
//1.创建匹配模式
        Pattern pattern = Pattern.compile("\\；\\d\\、");//匹配一个或多个数字字符
//2.选择匹配对象
        Matcher matcher = pattern.matcher(str);
//与谁匹配？与参数字符串str匹配
        int count = 0;
        while (matcher.find())//matcher.find()用于查找是否有这个字符，有的话返回true
        {
            System.out.println("第" + (++count) + "次找到");
            //start()返回上一个匹配项的起始索引
            //end()返回上一个匹配项的末尾索引。
            System.out.println(str.substring(matcher.start(), matcher.end()));
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}
