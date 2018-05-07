package ru.bav.practice;

import java.io.FileInputStream;
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


    /**
     * Метод ввода пути для изображения
     *
     * @return путь до изображения
     */
    public static String pathForImg() {
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

    public static String pathToArch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь для сохранения архива");
        System.out.println("Например: " + "C:\\name.zip");
        return scanner.nextLine();
    }


    /**
     * Метод zip-архивации
     *
     * Cоздаёт архив и записывает в него изображение.
     */
    private static String archiving(){
        String imgPath = pathForImg();
        String archPath = pathToArch();
        //Создание архива
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(archPath));
             //Считывание из файла с изображением
             FileInputStream fis = new FileInputStream(imgPath)) {

            //Отдельная запись в архиве
            ZipEntry entry1 = new ZipEntry("image.jpg");

            zout.putNextEntry(entry1); //добавление файла в архив
            // добавление содержимого файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();


        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return archPath;
    }

    public static void main(String[] args) {
        System.out.println("Путь к архиву: "+archiving());

    }


}
