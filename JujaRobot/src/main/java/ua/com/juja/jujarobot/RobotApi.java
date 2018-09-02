package ua.com.juja.jujarobot;

import java.awt.*;
import java.util.Random;

/**
 * Created by oleksandr.baglai on 17.11.2015.
 */
public class RobotApi {
    public static void buttonDown() {
        System.out.println("Нажали на кнопкодав");
    }

    public static void buttonUp() {
        System.out.println("Отпустили кнопкодав");
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Подождали " + time + "секунд");
    }

    public static Object getFromMemory(String name) {
        if (name.equals("police-number")) {
            return 911;
        }
        if (name.startsWith("[x,y]")) {
            Random random = new Random();
            return new Point(random.nextInt(10), random.nextInt(10));
        }

        System.out.println("Загрузили из памяти запись с именем: " + name);
        return new String("звуки/" + name + ".wave");
    }

    public static void play(Object wave) {
        System.out.println("Воспроизводится звук: " + wave);
    }

    public static Object listen() {
        return new String("ЗВУК");
    }

    public static void moveTo(double x, double y) {
        System.out.println("Переместили кнопкодав в позицию: " + x + ", " + y);
    }
}
