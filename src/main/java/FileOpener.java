import java.io.*;

public class FileOpener {
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
                    text+=line;
                }

                // Always close files.
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e);
        }
        return text;
    }
}
