import com.sun.tools.javac.util.List;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileManager {
    public static String openFile(String filePath){

            String line = "";
            String text = "";
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader =
                        new FileReader(filePath);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                  //  System.out.println(line);
                    text+=line+"\n";
                }

                //Remove last newline char
                text=text.substring(0,text.length() - 1);

                // Always close files.
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e);
        }
        return text;
    }
    public static void fileSaver(String documentContents, String filepath){
        try {
            ArrayList<String> fileLines = new ArrayList<>();
            fileLines.add(documentContents);

            Files.write(Paths.get(filepath), fileLines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
