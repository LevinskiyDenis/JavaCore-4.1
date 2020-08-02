package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        File games = new File("C:\\Games");

        File temp = new File("C:\\Games", "temp");
        File tempTxt = new File(temp, "temp.txt");

        try {
            if (temp.mkdir() && tempTxt.createNewFile()) {
                writeToLog(temp, tempTxt);
                writeToLog(tempTxt, tempTxt);
            }
        } catch (IOException e) {
            System.out.println("Не удалось создать файл или папку temp");
        }

        File src = new File(games, "src");
        if (src.mkdir()) writeToLog(src, tempTxt);

        File res = new File(games, "res");
        if (res.mkdir()) writeToLog(res, tempTxt);

        File savegames = new File("C:\\Games", "savegames");
        if (savegames.mkdir()) writeToLog(savegames, tempTxt);

        File srcMain = new File(src, "main");
        if (srcMain.mkdir()) writeToLog(srcMain, tempTxt);

        File srcTest = new File(src, "test");
        if (srcTest.mkdir()) writeToLog(srcTest, tempTxt);

        File mainJava = new File("C:\\Games\\src\\main\\main.java");
        try {
            if (mainJava.createNewFile()) writeToLog(mainJava, tempTxt);
        } catch (IOException e) {
            System.out.println("Не удалось создать файл");
        }

        File utilsJava = new File(srcMain, "utils.java");
        try {
            if (utilsJava.createNewFile()) writeToLog(utilsJava, tempTxt);
        } catch (IOException e) {
            System.out.println("Не удалось создать файл");
        }

        File resDrawables = new File(res, "drawables");
        if (resDrawables.mkdir()) writeToLog(resDrawables, tempTxt);

        File resVectors = new File(res, "vector");
        if (resVectors.mkdir()) writeToLog(resVectors, tempTxt);

        File resIcons = new File(res, "icons");
        if (resIcons.mkdir()) writeToLog(resIcons, tempTxt);
    }

    public static void writeToLog(File file, File tempTxt) {
        String text = "\n" + file.getName() + " записан в " + file.getPath();
        try (FileWriter fileWriter = new FileWriter(tempTxt, true)) {
            fileWriter.append(text);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
