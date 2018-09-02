package com.sashashtmv.roboJuja;

import java.awt.*;
import java.util.Random;

public class RobotAPI {

    public static void buttonDown() {
        System.out.println("Нажали на кнопкодав");
    }

    public static void buttonUp() {
        System.out.println("Отпустили кнопкодав");
    }

    public static void sleep(int sleep) {
        try {
            Thread.sleep(sleep * 100);
        }catch (InterruptedException e){e.printStackTrace();}
        System.out.println("Подождали: " + sleep + " секунд");
    }

    public static Object getFromMemory(String name) {
        if (name.equals("police-number"))
            return 911;
        if(name.startsWith("[x,y]")){
            Random random = new Random();
            return new Point(random.nextInt(10), random.nextInt(10));
        }
        System.out.println("Загрузили из памяти запись: " + name);
        return new String("Звук: " + name + ".wave");
    }

    public static void play(Object voice) {
        System.out.println("Воспроизводится звук: "+ voice);
    }

    public static Object listen(){
        return new String("ЗOUND");
    }

    public static void moveTo(double x, double y) {
        System.out.println("Переместили кнопкодав в позицию: " + x + ", " + y);
    }



}
