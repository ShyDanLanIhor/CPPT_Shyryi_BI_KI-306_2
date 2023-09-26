package CI_306.Shyryi.Lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The `FileUtil` class provides utility methods for reading and appending to files.
 */
public class FileUtil {
	
    /**
     * Reads the content of a file and prints it to the console.
     *
     * @param fileName The name of the file to be read
     * @param logText  A string to store each line of the file content
     */
    public static void readFile(String fileName, String logText) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((logText = reader.readLine()) != null) {
                System.out.println(logText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Appends text to a specified file with a timestamp.
     *
     * @param fileName The name of the file to which the text will be appended
     * @param logText  The text to be appended to the file
     */
    public static void appendToFile(String fileName, String logText) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDateTime = LocalDateTime.now();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("\n" + logText + " [" + currentDateTime.format(formatter) + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
