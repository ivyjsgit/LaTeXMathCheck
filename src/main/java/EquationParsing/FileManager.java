package EquationParsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {


    public static void fileSaver(String documentContents, String filepath) {
        try {
            ArrayList<String> fileLines = new ArrayList<>();
            fileLines.add(documentContents);

            Files.write(Paths.get(filepath), fileLines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String stringFromFile(File file) {
        StringBuilder output = new StringBuilder();
        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                output.append(sc.nextLine());
                if (sc.hasNextLine()) output.append("\n");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

}
