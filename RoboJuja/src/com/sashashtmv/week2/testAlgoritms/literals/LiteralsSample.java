package com.sashashtmv.week2.testAlgoritms.literals;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by indigo on 2017-04-26.
 */
public class LiteralsSample {

    /*TODO ----------- identifiers ---------- TODO*/

    public String classField = "bla bla";
    public static final int SOME_CONSTANT = 123;

    public boolean someMethodName() {
        return false;
    }

    public static class SomeClassName {

        // Это параметр метода, у него тоже есть свое имя
        public void someOtherMethod(int someParameter) {
            // do nothing
        }
    }

    @Test
    public void identifiers() {
        System.out.println("Это константа: " + SOME_CONSTANT);

        System.out.println("Это поле класса: " + classField);

        // это вызов метода
        boolean someLocalVariable = someMethodName();

        System.out.println("Это локальная переменная: " + someLocalVariable);

        // это создание объекта из класса
        SomeClassName someOtherVariable = new SomeClassName();

        // и потом вызов метода с параметром
        someOtherVariable.someOtherMethod(12);

        // читай Java Code Conventions
        // http://www.oracle.com/technetwork/java/codeconventions-150003.pdf
        // и узнаешь, почему так плохо

        int VARIABLE = 123;
        final String my_constant = "bla bla";
        boolean _qT647 = true;
    }

    /*TODO ----------- keywords ---------- TODO*/

    public static abstract class AbstractClass extends Object implements SomeInterface {
        abstract void method(int parameter);

        public String method2() throws Exception {
            return null;
        }
    }

    interface SomeInterface {

    }

    private final transient int CONSTANT2 = 123456;

    protected volatile String code = "1010100101011111";

    public enum Enum {
        QWE, ASD, ZXC;
    }

    public native void method3();

    public strictfp void method4() {
        // do nothing
    }

    @Test
    public void keywords() {
        byte input = 12;
        boolean overflow = (input < 100);
        assert overflow : "Ойкс!";
        switch (input) {
            case 1 :
                System.out.println("Ввели 1!"); break;
            case 2 :
                System.out.println("Ввели 2!"); break;
            default :
                System.out.println("Ввели " + input); break;
        }

        for (int i = 0; i < input; i++) {
            if (input < 5) {
                do {
                    System.out.println("Куку!");
                    input++;
                } while (input > 3);

                continue;
            } else {
                while (input < 10) {
                    input++;
                    System.out.println("Руку!");
                }
                break;
            }
        }

        try {
            System.out.println("Осторожно пробуем...");

            throw new RuntimeException("Ошибка!");
        } catch (Exception e) {
            System.out.println("Ойкс!");
        } finally {
            System.out.println("Закончили!");
        }

        char ch = '1';
        System.out.println(ch);

        final int CONSTANT = 123;
        System.out.println(CONSTANT);

        double temperature = 12.45;
        System.out.println(temperature);

        float temperature2 = 12.45F;
        System.out.println(temperature);

        loops:
        for (int i = 0; i < CONSTANT; i++) {
            for (int j = 0; j < CONSTANT; j++) {
                // do stuff
                break loops;
            }
        }

        if (this.getClass() instanceof Class) {
            System.out.println("Трям пам!");
        }

        int[] array = new int[] {1, 2, 3, 4, 5};

        LinkedList<String> strings = new LinkedList<String>() {{
            add("1");
            add("2");
            add("3");
        }};

        long longVariable = Long.MAX_VALUE;
        System.out.println(longVariable);

        System.out.println(new String("Кукарача!"));

        short shortVariable = 12345;
        System.out.println(shortVariable);

        synchronized (this) {
            int hashCode = super.hashCode();
            System.out.println(hashCode);
        }

        this.someMethodName();
    }

    /*TODO ----------- operators ---------- TODO*/

    @Test
    public void operators() {
        String myName = new String("Alexander Baglay");

        int sum = 1 + 2;

        sum++;
        sum--;

        int lastValue = --sum;
        int lastValue2 = ++sum;

        sum = -sum;
        sum = +sum;
        sum = ~sum;
        boolean aTrue = !false;

        int value = sum + lastValue;
        int value2 = sum - lastValue2;

        int multiple = value * value2;
        double div = value / value2;
        int rest = value % value2;

        long shift1 = multiple << value;
        long shift2 = multiple >> value;
        long shift3 = multiple >>> value;

        boolean flag1 = shift1 < shift2;
        boolean flag2 = shift1 <= shift2;
        boolean flag3 = shift1 >= shift2;
        boolean flag4 = shift1 > shift2;
        boolean flag5 = shift1 == shift2;
        boolean flag6 = shift1 != shift2;

        boolean flag7 = (flag3 && flag5 || flag6) && !(flag1 || flag3);

        long data = (shift1 & shift2 | shift3) & shift1 & ~shift2;

        long value3 = (flag7 && data < 12) ? 123 : 456;

        long value4 = 0;

        value4 += shift1 - shift2/shift1;
        value4 *= rest;
        value4 -= value3;
        value4 /= 2;
        value4 %= 12;
        value4 &= shift2 | shift1;
        value4 |= shift3;
        value4 ^= 0x1234556;
        value4 <<= 12;
        value4 >>= 2;
        value4 >>>= 5;

        System.out.println(value4);
    }

    /*TODO ----------- literals ---------- TODO*/

    @Test
    public void numeralLiterals() {
        long binary1 = 0b10010010001;
        long binary2 = 0b0;
        long binary3 = 0b1;
        long binary4 = 0b0000_1010_1110_1101;
        int binary5 = 0b1010_1110_1101_1110_0011_1101_0000_1001;
        long binary6 = 0b1010_1110_1101_1110_0011_1101_0000_1001_0000_1010_1110_1101_1110_0011_1101_0000L;
        // long binary7 = 0b12345; // так нельзя

        long octal1 = 01234567;
        long octal2 = 01_234_567;
        // long octal3 = 0188888; // так нельзя

        // тут и везде дальше литералом является только число,
        // а '-' это уже унарный оператор
        long octal4 = -01234567;

        long hexademical1 = 0x12345678;
        long hexademical2 = 0x123456789ABCDEF0L;
        long hexademical3 = 0x1234_5678_9ABC_DEF0L;
        long hexademical4 = -0x12345678;

        long decimal1 = 0;
        long decimal2 = -1;
        long decimal3 = -1000;
        long decimal4 = 42;
        long decimal5 = 1234567890;
        long decimal6 = 1234567890123456789L;
    }

    @Test
    public void floatPointLiterals() {
        double double1 = 0.0;
        double double2 = 0.1;
        double double3 = -0.1;
        double double4 = 0.123456789;
        double double5 = 123.456789e-9;
        double double6 = 0.123456789e+120;

        double double7 = 3.141_592_653_589_793_238;
        // последние разряды 238 мы потеряем
        System.out.println(double7);

        double double8 = 3.14159269793238d;
        double double9 = 3.14159269793238D;

        // float - использует 32 бита для хранения, и это меньше в двое чем double
        // важно понимать, что по умолчанию всегда используется double
        // если хотим float - надо прибавлять f|F в конце

        float float1 = 0.0f;
        float float2 = 0.1F;
        float float3 = -0.1F;
        float float4 = 0.123456789e+12F;

        float float5 = 3.141_592_653_589_793_238F;
        // последние разряды 653_589_793_238 мы потеряем
        System.out.println(float5);
    }

    @Test
    public void booleanLiterals() {
        boolean boolean1 = true;
        boolean boolean2 = false;
        // "Быть или не быть - вот в чем вопрос..." (с)
    }

    @Test
    public void charLiterals() {
        char char1 = 'a';
        char char2 = 'A';
        char char3 = '☺';
        char char4 = '龍';
        char char5 = 65535; // тут произойдет кастинг int в char, с кастингами осторожнее!
        char char6 = '\n';
        char char7 = '\t';
        char char8 = '\'';
        char char9 = '\\';
        char char10 = '\"';
        char char11 = '\r';
        char char12 = '\u0123';
        char char13 = '\u1E3D';
        System.out.println(char13); // любопытно что там получилось :)
    }

    @Test
    public void stringLiterals() {
        String message = "Hello World!";
        System.out.println(message);
    }

    @Test
    public void nullLiterals() {
        Object object = null;
        System.out.println(object);

        object = "String";
        System.out.println(object);
    }

    /*TODO ----------- comments ---------- TODO*/

    /**
     * Это JavaDoc - из нее генерируется сайт с описанием методов,
     * классов, интерфейсов, полей и констант.
     * @param question Описание параметра
     * @return Описание возвращемого результата
     */
    public int method(String question) {
        return 42;
    }

    @Test
    public void commentLiterals() {
        // а это однострочный комментарий
        System.out.println( // он может быть в любом месте,
                method("Какой главный вопрос жизни, " + // и тут
                "вселенной и всего такого?")); // и тут
        // но не в начале строчки кода
        // потому как все что за симвоолами // - станет комментарием
        // и даже код
        // System.out.println("Эта строчка никогда не выполнится");

        // Вообще-то комментировать код плохо!

         /*
          * Если лень писать // на каждую новую строчку
          * Можно воспользоваться многострочным комментарием
          * IDE позаботится о том, чтобы вставить новый символ
          */
    }

    /*TODO ------ statement / expression / block ------ TODO*/

    // это блок
    {
        // в нем может быть любое число statements
        method("Куку!");
        method("Hello world!");
        // expression - может стать частью statement;
        String result = method("Куку!") + " ☺"; //
        { // а вот еще блок
            System.out.println(result);
        }
    }

}
