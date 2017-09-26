package threads;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    private FileUtils() {
    }

    public static String readFromFile(String path) throws IOException {
        String json = new Scanner(new File(path)).useDelimiter("\\Z").next();
        System.out.println("\nФайл загружен: " + path);
        return json;
    }
}
