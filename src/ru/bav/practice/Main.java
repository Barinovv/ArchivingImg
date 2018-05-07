package ru.bav.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Класс, предназначенный для архивирования изображения в zip-архив
 *
 * @author Barinov 15IT18.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Путь к архиву: "+archiving());

    }

    /**
     * Метод для ввода пути для изображения
     *
     * @return путь до изображения
     */
    public static String enterPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к изображению для архивации");
        System.out.println("Например: " + "C:\\image.jpg");
        return scanner.nextLine();
    }

    /**
     * Метод для ввода пути сохранения архива
     *
     * @return путь до архива
     */

    public static String output_path() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь для сохранения архива");
        System.out.println("Например: " + "C:\\name.zip");
        return scanner.nextLine();
    }


    /**
     * Метод zip-архивации, создаёт архив и записывает в него файл.
     */
    private static String archiving(){
        String name = enterPath();
        String output = output_path();
        //Создание архива
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(output));
             //Считывание из файла
             FileInputStream fis = new FileInputStream(name)) {

            //Отдельная запись в архиве
            ZipEntry entry1 = new ZipEntry("image.jpg");

            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();


        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return output;
    }


}
