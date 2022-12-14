package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {


    public static void log(String message) {
        System.out.println(String.format("%s: %s",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()), message));
    }

    public static void log(int message) {
        System.out.println(String.format("%s: %d",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()), message));
    }

    public static <T> void logArr(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void logIArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void logIArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void logLArr(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void logDArr(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    public static boolean isLetter(char c) {
        return (c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A');
    }

    public static boolean isNumber(char c) {
        return c <= '9' && c >= '0';
    }
}
