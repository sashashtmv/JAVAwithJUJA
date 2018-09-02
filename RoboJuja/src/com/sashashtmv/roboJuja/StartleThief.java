package com.sashashtmv.roboJuja;

// сигнализировать воров о том, что дома кто-то есть


import java.awt.*;

public class StartleThief {
    public static void main(String[] args) {

        int state = 0;
        // основную часть времени мы простаиваем и слушаем
        while (true) {
            // и если мы слышим за дверью какой-то шум, мы активизируемся
            if(isNotNoise(RobotAPI.listen())){
                // записываем звук и анализируем его
                Object voice = RobotAPI.listen();
                // если мы уже в прошлом настораживались
                if(state == 0){
                    // если звук подозрительный
                    if(isStrange(voice)){
                        state = 1;// мы насторожились
                        // мы включаем свет
                        lightOn();
                        // мы воспроизводим запись звука
                        // звука лая большой и грозной собаки
                        RobotAPI.play(RobotAPI.getFromMemory("uf-uf"));
                        // говорим голосом хозяина - Тузик - Фу
                        RobotAPI.play(RobotAPI.getFromMemory("bobik - fu"));
                        // и замолкаем
                    }
                }else if(state == 1){
                    // если звук продолжается и усиливается(работают с дверью)
                    // собака снова лает
                    RobotAPI.play(RobotAPI.getFromMemory("uf-uf"));
                    // хозяин спрашивает - Кто там?
                    RobotAPI.play(RobotAPI.getFromMemory("kto tam"));
                    // собака продолжает лаять, хозяин молчит
                    RobotAPI.play(RobotAPI.getFromMemory("uf-uf"));
                    RobotAPI.play(RobotAPI.getFromMemory("uf-uf"));
                    RobotAPI.play(RobotAPI.getFromMemory("uf-uf"));
                    state = 2;

                }else if(state==2){
                    // если кто-то что-то говорит за дверью -
                    if(isQuestion(voice)) {
                        // хозяин говорит - Спасибо не надо, я сейчас занят
                        RobotAPI.play(RobotAPI.getFromMemory("spasibo ne nado"));
                    }
                    state = 3;

                }else if(state==3){
                    // если при этом шум продолжается
                    // хозяин говорит - Я сейчас вызову милицию и у вас есть 15 мин, чтобы удалиться отсюда
                    RobotAPI.play(RobotAPI.getFromMemory("vizov_milicii"));
                    callPolice();
                    state = 4;
                }

            }else {
                state = 0;
                // если звук не подозрительный
                // мы молчим
            }
            RobotAPI.sleep(10);
        }
    }

    public static boolean isQuestion(Object voice) {
        System.out.println("Изучаем звук: " + voice);
        System.out.println("Да это речь и это вопрос");
        return true;
    }
    public static boolean isStrange(Object voice) {
        System.out.println("Изучаем звук: " + voice);
        System.out.println("Да это очень странный звук");
        return true;
    }
    private static boolean isNotNoise(Object listen) {
        System.out.println("Мы слышим какой-то звук");
        return true;
    }
    private static void lightOn() {
        System.out.println("Свет включен");
    }
    private static void callPolice() {
        int number = (Integer)RobotAPI.getFromMemory("police-number");
        byte[] numbers = getNumbers(number);

        for(byte n : numbers){
            Point point = (Point) RobotAPI.getFromMemory("[x,y]" + n);
            RobotAPI.moveTo(point.getX(), point.getY());
            RobotAPI.buttonDown();
            RobotAPI.buttonUp();
        }
        RobotAPI.play("call-police");
    }

    private static byte[] getNumbers(int number) {
        byte[] result = new byte[3];
        int index = 0;
        do {
            byte b = (byte) (number % 10);
            number = number / 10;
            result[result.length - index - 1] = b;
            index++;
        }while (number != 0);
        return result;//TODO
    }
}
