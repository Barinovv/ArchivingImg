package ru.bav.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к изображению для архивации");
        System.out.println("Например: " + "C:\\image.jpg");
        String filename = scanner.nextLine();

        try (ZipOutputStream zola = new ZipOutputStream(new FileOutputStream("C:\\Program Files (x86)\\ready.zip"));
             FileInputStream fis = new FileInputStream(filename)) {
            ZipEntry zipEntry = new ZipEntry("image.jpg");
            zola.putNextEntry(zipEntry);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];

            // добавляем содержимое к архиву
            zola.write(buffer);
            // закрываем текущую запись для новой записи

            zola.closeEntry();
            fis.read(buffer);

            long size = zipEntry.getCompressedSize();
            long nsize = zipEntry.getSize();
            System.out.println("Размер найденного изображения " + nsize + "Кб");
            System.out.println("Размер найденного изображения после сжатия " + size + "Кб");

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }
}


