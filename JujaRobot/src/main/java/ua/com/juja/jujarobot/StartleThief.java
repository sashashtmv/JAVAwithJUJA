package ua.com.juja.jujarobot;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by oleksandr.baglai on 17.11.2015.
 */
// сигнализировать воров о том, что дома кто-то есть
public class StartleThief {

    public static void main(String[] args) {
        int state = 0;
        // основную часть времени мы простаиваем и слушаем
        while (true) {
            // и если мы слышим за дверью какой-то шум, мы активизируемся
            if (isNotNoise(RobotApi.listen())) {
                // записываем звук и анализируем его
                Object wave = RobotApi.listen();

                // еси мы уже в прошлом насторажливались
                if (state == 0) {
                    // если звук подозрительный
                    if (isStrange(wave)) {
                        state = 1; // мы насторожились
                        // мы включаем свет
                        lightOn();
                        // мы воспроизводим записьм звука
                        // звука гавкающей бойцовой собаки
                        RobotApi.play(RobotApi.getFromMemory("uf-uf"));
                        // говорим голосом хозяина Бобик фу
                        RobotApi.play(RobotApi.getFromMemory("bobik-fu"));
                        // и замолкаем
                    }
                } else if (state == 1) {
                    // если звук продолжается и усиляется (работают с дверью)
                    // собака снова гав-гав
                    RobotApi.play(RobotApi.getFromMemory("uf-uf"));

                    // хозяин спрашивает, кто там?
                    RobotApi.play(RobotApi.getFromMemory("kto-tam"));

                    // и тишина при гавкающей собаке
                    // собака снова гав-гав
                    RobotApi.play(RobotApi.getFromMemory("uf-uf"));

                    // собака снова гав-гав
                    RobotApi.play(RobotApi.getFromMemory("uf-uf"));

                    // собака снова гав-гав
                    RobotApi.play(RobotApi.getFromMemory("uf-uf"));

                    state = 2;
                } else if (state == 2) {

                    if (isQuestion(wave)) {
                        // спасибо ненадо я сейчас занят
                        RobotApi.play(RobotApi.getFromMemory("spasibo-nenado"));
                    } else {
                        // do nothing
                    }

                    state = 3;
                } else if (state == 3) {
                    // если при этом шум продолжается
                    // хозяин говорит, я вызвал милицию и у вас есть 15 минут чтобы удалиться
                    RobotApi.play(RobotApi.getFromMemory("police"));

                    callPolice();

                    state = 4;
                } else {

                }

            } else {
                // если звук не подозрительный
                // мы молчим
                state = 0;
            }
            RobotApi.sleep(10);
        }
    }

    private static void callPolice() {
        int number = (Integer)RobotApi.getFromMemory("police-number");

        byte[] numbers = getNumbers(number);

        for (byte n : numbers) {
            Point point = (Point)RobotApi.getFromMemory("[x,y]" + n);
            RobotApi.moveTo(point.getX(), point.getY());
            RobotApi.buttonDown();
            RobotApi.buttonUp();
        }
        RobotApi.play(RobotApi.getFromMemory("call-police"));
    }

    private static byte[] getNumbers(int number) {
        byte[] result = new byte[3];

        int index = 0;
        do {
            byte b = (byte) (number % 10);
            number = number / 10;
            result[index] = b;
            index++;
        } while (number != 0);

        reverse(result);

        return result;
    }

    private static void reverse(byte[] data) {
        for(int i = 0; i < data.length / 2; i++) {
            byte temp = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = temp;
        }
    }

    private static void lightOn() {
        System.out.println("Свет включен!");
    }

    // наш код

    public static boolean isQuestion(Object wave) {
        System.out.println("Изучаем звук: " + wave);
        System.out.println("Да это речь и это вопрос!");
        return true;
    }

    public static boolean isStrange(Object wave) {
        System.out.println("Изучаем звук: " + wave);
        System.out.println("Да это очень странный звук!");
        return true;
    }

    private static boolean isNotNoise(Object listen) {
        System.out.println("Мы слышим какой-то звук!");
        return true;
    }
}

