package threads;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.List;

public class Task_2 {
    private static long endTime;
    private static long startTime;
    private static long result1 = 0;
    private static long result2 = 0;

    public static void load(String pathToJsonFile) {
        String json = null;
        try {
            json = FileUtils.readFromFile(pathToJsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // наполняем массив
        startTime = System.currentTimeMillis();
        List<Integer> list = JSON.parseArray(json, Integer.class);
        endTime = System.currentTimeMillis();
        System.out.println("загруза данных из файла в массив за " + (endTime - startTime) + "ms");

        // суммируем
        startTime = System.currentTimeMillis();
        long result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("1 поток - сумма = " + result + " за " + (endTime - startTime) + "ms");

        // умножаем
        startTime = System.currentTimeMillis();
        result = 1;
        for (int i = 0; i < list.size(); i++) {
            result *= list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("1 поток - произведение = " + result + " за " + (endTime - startTime) + "ms");

        // делим
        startTime = System.currentTimeMillis();
        double resultDivide = 0;
        for (int i = 0; i < list.size(); i++) {
            resultDivide += list.get(i) / (i + 1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("1 поток - отношение = " + resultDivide + " за " + (endTime - startTime) + "ms");

        // отнимаем
        startTime = System.currentTimeMillis();
        result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result -= list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("1 поток - разница = " + result + " за " + (endTime - startTime) + "ms");

        System.out.println("--------------------------------");
        System.out.println("Количество ядер в системе = " + getCountCore());
//
//        Thread one = new Thread(() -> {
//            System.out.println("1 начал + " + System.currentTimeMillis());
//            startTime = System.currentTimeMillis();
//            for (int i = 0; i < list.size() / 2; i++) {
//                result1 += list.get(i);
//            }
//            System.out.println("1 закончил + " + System.currentTimeMillis());
//            endTime = System.currentTimeMillis();
//            System.out.println("сумма 1 " + result1 + " за " + (endTime - startTime) + "ms");
//        });
//
//
//        Thread two = new Thread(() -> {
//            System.out.println("2 начал + " + System.currentTimeMillis());
//            startTime = System.currentTimeMillis();
//            for (int i = list.size() / 2; i < list.size(); i++) {
//                result2 += list.get(i);
//            }
//            endTime = System.currentTimeMillis();
//            System.out.println("2 закончил + " + System.currentTimeMillis());
//            System.out.println("сумма 2 " + result2 + " за " + (endTime - startTime) + "ms");
//
//        });
//        one.start();
//        two.start();
//        try {
//            one.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            two.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("сумма 2 потока " + (result2 + result1) + "ms");

    }

    // получаем количество ядер
    private static int getCountCore(){
        return Runtime.getRuntime().availableProcessors();
    }


}
